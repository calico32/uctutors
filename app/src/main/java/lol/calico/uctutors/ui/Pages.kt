package lol.calico.uctutors.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import lol.calico.uctutors.ui.compose.Baseline
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.compose.LocalUser
import lol.calico.uctutors.ui.layout.AppLayout
import lol.calico.uctutors.util.TestData.user
import lol.calico.uctutors.util.modifier

private const val TAG = "@Pages"

enum class Direction(val offset: Int) {
  RightToLeft(1000),
  LeftToRight(-1000)
}

fun slideIn(direction: Direction) =
  slideInHorizontally(initialOffsetX = { direction.offset }, animationSpec = tween(300))

fun slideOut(direction: Direction) =
  slideOutHorizontally(targetOffsetX = { direction.offset }, animationSpec = tween(300))

fun enterTransitionFor(prev: String?, next: String?): EnterTransition {
  val routes = Route.screens.map { it.route }
  val nextIndex = routes.indexOf(next)
  val prevIndex = routes.indexOf(prev)

  return if (nextIndex != -1 && prevIndex != -1) {
    if (nextIndex > prevIndex) {
      // Screen -> Screen, right
      slideIn(Direction.RightToLeft)
    } else {
      // Screen -> Screen, left
      slideIn(Direction.LeftToRight)
    }
  } else if (prevIndex == -1 && nextIndex == -1) {
    // Page -> Page
    slideIn(Direction.RightToLeft)
  } else if (prevIndex == -1) {
    // Page -> Screen
    slideIn(Direction.LeftToRight)
  } else {
    // Screen -> Page
    slideIn(Direction.RightToLeft)
  }
}

fun exitTransitionFor(prev: String?, next: String?): ExitTransition {
  val routes = Route.screens.map { it.route }
  val nextIndex = routes.indexOf(next)
  val prevIndex = routes.indexOf(prev)

  return if (nextIndex != -1 && prevIndex != -1) {
    if (nextIndex > prevIndex) {
      // Screen -> Screen, right
      slideOut(Direction.LeftToRight)
    } else {
      // Screen -> Screen, left
      slideOut(Direction.RightToLeft)
    }
  } else if (prevIndex == -1 && nextIndex == -1) {
    // Page -> Page
    slideOut(Direction.LeftToRight)
  } else if (prevIndex == -1) {
    // Page -> Screen
    slideOut(Direction.RightToLeft)
  } else {
    // Screen -> Page
    slideOut(Direction.LeftToRight)
  }
}

fun transitionFor(prev: String?, next: String?): ContentTransform {
  return enterTransitionFor(prev, next) togetherWith exitTransitionFor(prev, next)
}

@Composable
fun Pages() {
  val pageController = rememberNavController()

  CompositionLocalProvider(
    LocalPageController provides pageController,
    LocalUser provides user,
  ) {
    AppLayout(
      // title = {
      //   val currentBackStateEntry by pageController.currentBackStackEntryAsState()
      //   val currentRoute by remember {
      //     derivedStateOf { currentBackStateEntry?.destination?.route }
      //   }
      //
      //   AnimatedContent(
      //     targetState = currentRoute,
      //     label = "title",
      //     transitionSpec = { transitionFor(initialState, targetState) }
      //   ) {
      //     val route = Route.find(it ?: "")
      //     Text(
      //       route?.name ?: it?.replaceFirstChar(Char::uppercaseChar) ?: "UCTutors",
      //       style = MaterialTheme.typography.titleLarge,
      //       textAlign = TextAlign.Center,
      //       modifier = modifier { fillMaxWidth() }
      //     )
      //   }
      // },
      floatingActionButton = {
        val currentBackStateEntry by pageController.currentBackStackEntryAsState()
        val currentRoute by remember {
          derivedStateOf { currentBackStateEntry?.destination?.route }
        }

        AnimatedContent(
          targetState = currentRoute,
          label = "fab",
          transitionSpec = {
            val origin = TransformOrigin(1f, 1f)
            val enter = scaleIn(tween(150, 150), 0.30f, origin) + fadeIn(tween(150, 150))
            val exit = scaleOut(tween(150), 0.30f, origin) + fadeOut(tween(150))
            val clip = SizeTransform(clip = false)

            enter togetherWith exit using clip
          }
        ) {
          val fab = Route.find(it ?: "")?.fab
          if (fab != null) {
            Box(modifier = modifier { padding(bottom = 18.dp, end = 6.dp) }) { fab() }
          } else {
            ExtendedFloatingActionButton(
              onClick = {},
              modifier =
                modifier {
                  alpha(0f)
                  size(1.dp)
                }
            ) {}
          }
        }
      }
    ) { contentPadding ->
      NavHost(
        pageController,
        startDestination = "home",
        enterTransition = {
          enterTransitionFor(initialState.destination.route, targetState.destination.route) +
            fadeIn(tween(300))
        },
        exitTransition = {
          exitTransitionFor(initialState.destination.route, targetState.destination.route) +
            fadeOut(tween(300))
        }
      ) {
        for (route in Route.all) {
          composable(route.route, route.arguments) { route.content(contentPadding) }
        }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun PagesPreview() {
  Baseline { Pages() }
}
