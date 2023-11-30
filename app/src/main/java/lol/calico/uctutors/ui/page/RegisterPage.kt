package lol.calico.uctutors.ui.page

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme

@Composable
fun RegisterPage(
  onRegister: suspend (RegisterData) -> Result<Unit, String>,
) {
  var page by remember { mutableIntStateOf(1) }
  var data by remember { mutableStateOf(registerData {}) }
  Surface(
    color = Colors.Primary40,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = Modifier
        .padding(12.dp),
    ) {
      Box(
        modifier = Modifier
          .animateContentSize()
          .clip(MaterialTheme.shapes.medium)
          .shadow(10.dp)
          .background(MaterialTheme.colorScheme.background)
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
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
            when (currentPage) {
              1 ->
                Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  modifier = Modifier
                    .fillMaxWidth()
                ) {
                  RegisterPage1(
                    initialData = data,
                    onNext = {
                      data = it
                      page = 2
                    },
                  )
                }

              2 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                  .fillMaxWidth()
              ) {
                RegisterPage2(
                  initialData = data,
                  onPrevious = {
                    data = it
                    page = 1
                  },
                  onRegister = onRegister,
                )
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
  UCTutorsTheme {
    RegisterPage(onRegister = { Ok(Unit) })
  }
}

