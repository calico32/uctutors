package lol.calico.uctutors.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import lol.calico.uctutors.ui.Route
import lol.calico.uctutors.ui.compose.Baseline
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.compose.LocalUser
import lol.calico.uctutors.util.TestData
import lol.calico.uctutors.util.modifier

@Composable
fun AppBar() {
  NavigationBar {
    val pageController = LocalPageController.current
    val currentBackStateEntry = pageController.currentBackStackEntryAsState()

    val selected = remember {
      derivedStateOf {
        Route.screens
          .map { it.route }
          .filter { route ->
            currentBackStateEntry.value?.destination?.hierarchy?.any { it.route == route } ?: false
          }
          .getOrNull(0)
      }
    }

    for (route in Route.screens) {
      AppBarItem(
        route,
        selected = route.route == selected.value,
        useUserAvatar = route == Route.You
      ) {
        val options = navOptions {
          val target =
            try {
              pageController.graph.findStartDestination().route!!
            } catch (e: Throwable) {
              "login"
            }

          popUpTo(target) { saveState = true }
          restoreState = true
          launchSingleTop = true
        }

        pageController.navigate(route.route, options)
      }
    }
  }
}

@Composable
fun RowScope.AppBarItem(
  route: Route,
  selected: Boolean,
  useUserAvatar: Boolean = false,
  onClick: () -> Unit
) {
  val user = LocalUser.current

  NavigationBarItem(
    selected = selected,
    onClick = onClick,
    icon = {
      if (useUserAvatar && user != null && user.avatarId != null) {
        RemoteImage(
          id = user.avatarId,
          modifier =
            modifier {
              clip(CircleShape)
              size(24.dp)
            },
          contentScale = ContentScale.Fill,
        )
      } else {
        Icon(route.icon ?: error("screen route has no icon"), contentDescription = "")
      }
    },
    label = { Text(route.name) },
  )
}

@Preview
@Composable
fun AppBarPreview() {
  Baseline { CompositionLocalProvider(LocalUser provides TestData.user) { AppBar() } }
}
