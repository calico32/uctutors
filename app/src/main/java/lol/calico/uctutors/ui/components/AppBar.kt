package lol.calico.uctutors.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.House
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import lol.calico.uctutors.ui.compose.LocalPageController

@Composable
fun AppBar() {
  val pageController = LocalPageController.current
  val navOptions = navOptions {
    val target = try {
      pageController.graph.findStartDestination().route!!
    } catch (e: Throwable) {
      "login"
    }

    popUpTo(target) {
      inclusive = true
      saveState = true
    }
    restoreState = true
    launchSingleTop = true
    anim {
      enter = android.R.anim.slide_in_left
      exit = android.R.anim.slide_out_right
    }
  }

  val currentDestination = pageController
    .currentBackStackEntryAsState().value?.destination

  NavigationBar {
    NavigationBarItem(
      selected = currentDestination?.hasRouteInHierarchy("home") ?: false,
      onClick = {
        pageController.navigate("home", navOptions)
      },
      icon = {
        Icon(Icons.Outlined.House, contentDescription = "")
      },
      label = {
        Text("Home")
      },
    )
    NavigationBarItem(
      selected = currentDestination?.hasRouteInHierarchy("calendar") ?: false,
      onClick = {
        pageController.navigate("calendar", navOptions)
      },
      icon = {
        Icon(Icons.Outlined.CalendarMonth, contentDescription = "")
      },
      label = {
        Text("Calendar")
      },
    )
    NavigationBarItem(
      selected = currentDestination?.hasRouteInHierarchy("explore") ?: false,
      onClick = {
        pageController.navigate("explore", navOptions)
      },
      icon = {
        Icon(Icons.Outlined.Explore, contentDescription = "")
      },
      label = {
        Text("Explore")
      },
    )
    NavigationBarItem(
      selected = currentDestination?.hasRouteInHierarchy("you") ?: false,
      onClick = {
        pageController.navigate("you", navOptions)
      },
      icon = {
        Icon(Icons.Outlined.AccountCircle, contentDescription = "Description")
      },
      label = {
        Text("You")
      },
    )
  }
}

private fun NavDestination?.hasRouteInHierarchy(route: String) =
  this?.hierarchy?.any {
    it.route?.contains(route, true) ?: false
  } ?: false