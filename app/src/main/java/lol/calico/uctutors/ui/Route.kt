package lol.calico.uctutors.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import lol.calico.uctutors.ui.page.calendar.CalendarPage
import lol.calico.uctutors.ui.page.calendar.CalendarPageFab
import lol.calico.uctutors.ui.page.channel.ChannelPage
import lol.calico.uctutors.ui.page.home.HomePage
import lol.calico.uctutors.ui.page.messages.MessagesPage
import lol.calico.uctutors.ui.page.messages.MessagesPageFab
import lol.calico.uctutors.ui.page.messages.NewChannelPage
import lol.calico.uctutors.ui.page.you.YouPage

sealed class Route(
  val route: String,
  val name: String,
  val icon: ImageVector?,
  val title: @Composable () -> Unit = {},
  val arguments: List<NamedNavArgument> = emptyList(),
  val fab: (@Composable () -> Unit)? = null,
  val content: @Composable (PaddingValues) -> Unit,
) {
  data object Home :
    Route(route = "home", name = "Home", icon = Icons.Outlined.House, content = { HomePage(it) })

  data object Calendar :
    Route(
      route = "calendar",
      name = "Calendar",
      icon = Icons.Outlined.CalendarMonth,
      fab = { CalendarPageFab() },
      content = { CalendarPage(it) }
    )

  data object Messages :
    Route(
      route = "messages",
      name = "Messages",
      icon = Icons.Outlined.Message,
      fab = { MessagesPageFab() },
      content = { MessagesPage(it) }
    )

  data object You :
    Route(
      route = "you",
      name = "You",
      icon = Icons.Outlined.AccountCircle,
      content = { YouPage(it) }
    )

  data object NewChannel :
    Route(
      route = "new-channel",
      name = "New Channel",
      icon = Icons.Outlined.Message,
      content = { NewChannelPage(it) }
    )

  data object Channel :
    Route(
      route = "channel/{channelId}",
      name = "Channel",
      icon = Icons.Outlined.Message,
      arguments = listOf(navArgument("channelId") { type = NavType.StringType }),
      content = { ChannelPage(it) }
    )

  infix fun with(param: Pair<String, String>): String {
    val (key, value) = param
    return route.replace("{$key}", value)
  }

  companion object {
    val screens = listOf(Home, Calendar, Messages, You)
    val all = screens + listOf(NewChannel, Channel)

    fun find(route: String): Route? = all.find { it.route == route }

    fun findScreen(route: String): Route? = screens.find { it.route == route }
  }
}

fun NavController.navigate(route: Route) {
  navigate(route.route)
}

infix fun String.and(param: Pair<String, String>): String {
  val (key, value) = param
  return replace("{$key}", value)
}
