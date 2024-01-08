package lol.calico.uctutors.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import lol.calico.uctutors.ui.Route
import lol.calico.uctutors.ui.compose.LocalPageController

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
      AppBarItem(route, selected = route.route == selected.value) {
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
fun RowScope.AppBarItem(route: Route, selected: Boolean, onClick: () -> Unit) {
  NavigationBarItem(
    selected = selected,
    onClick = onClick,
    icon = { Icon(route.icon ?: error("screen route has no icon"), contentDescription = "") },
    label = { Text(route.name) },
  )
}
