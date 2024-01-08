package lol.calico.uctutors.ui.page.register

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlinx.coroutines.launch
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.compose.LocalAccountHandler
import lol.calico.uctutors.ui.compose.LocalAppController
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier

data class Page(
  val content: (@Composable ColumnScope.(Int) -> Unit)?,
)

@Composable
fun RegisterPage(
  onRegister: suspend (RegisterData) -> Result<Unit, String>,
  debugContent: (@Composable () -> Unit)? = null,
) {
  val scope = rememberCoroutineScope()
  var page by remember { mutableIntStateOf(0) }
  var data by remember { mutableStateOf(registerData {}) }
  var registerError by remember { mutableStateOf("") }
  val accountHandler = LocalAccountHandler.current

  val pages = remember {
    listOf(
      Page { i ->
        RegisterPageProfile(
          initialData = data,
          onNext = {
            data = it
            page = i + 1
          }
        )
      },
      Page { i ->
        RegisterPageCampusAvailability(
          initialData = data,
          onPrevious = {
            data = it
            page = i - 1
          },
          onNext = {
            data = it
            page = i + 1
          }
        )
      },
      Page { i ->
        RegisterPageVirtualAvailability(
          initialData = data,
          onPrevious = {
            data = it
            page = i - 1
          },
          onNext = {
            data = it
            page = i + 1
          }
        )
      },
      Page { i ->
        RegisterPageTopics(
          initialData = data,
          onPrevious = {
            data = it
            page = i - 1
          },
          onNext = {
            data = it
            page = i + 1
            scope.launch {
              //              onRegister(data).fold(
              //                { page = i + 2 },
              //                { err -> registerError = err }
              //              )
              accountHandler.register(data)
              page = i + 2
            }
          }
        )
      },
      Page { RegisterPageLoading() },
      Page {
        val appController = LocalAppController.current
        LaunchedEffect(Unit) { appController.navigate("pages") }
      }
    )
  }

  Surface(color = Colors.Primary40, modifier = modifier { fillMaxSize() }) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = modifier { padding(12.dp) },
    ) {
      Box(
        modifier =
          modifier {
            animateContentSize()
            composed { clip(MaterialTheme.shapes.medium) }
            shadow(10.dp)
            composed { background(MaterialTheme.colorScheme.background) }
            fillMaxWidth()
            padding(20.dp)
            composed { verticalScroll(rememberScrollState()) }
          }
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier =
            modifier {
              fillMaxWidth()
              padding(top = 8.dp)
            }
        ) {
          Text(
            "Complete your Account",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
          )
          AnimatedContent(
            page,
            label = "RegisterPage",
            transitionSpec = {
              if (targetState > initialState) {
                slideInHorizontally(tween(300)) { it } + fadeIn() togetherWith
                  slideOutHorizontally(tween(300)) { -it } + fadeOut()
              } else {
                slideInHorizontally(tween(300)) { -it } + fadeIn() togetherWith
                  slideOutHorizontally(tween(300)) { it } + fadeOut()
              }
            }
          ) { currentPage ->
            if (debugContent != null) {
              debugContent()
              return@AnimatedContent
            }

            pages[currentPage].content?.run {
              val content = this
              Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                  modifier {
                    fillMaxWidth()
                    padding(top = 16.dp)
                  }
              ) {
                content(currentPage)
              }
            }
          }
        }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPagePreview() {
  UCTutorsTheme { RegisterPage(onRegister = { Ok(Unit) }) }
}
