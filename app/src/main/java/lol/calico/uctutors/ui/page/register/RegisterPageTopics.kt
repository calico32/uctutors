package lol.calico.uctutors.ui.page.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier

@Composable
fun ColumnScope.RegisterPageTopics(
  initialData: RegisterData,
  onPrevious: (RegisterData) -> Unit,
  onNext: (RegisterData) -> Unit,
) {
  var topics by remember {
    if (initialData.topicsList.isNotEmpty()) {
      mutableStateOf(initialData.topicsList.toList())
    } else {
      mutableStateOf(listOf<String>())
    }
  }

  fun validate(): Boolean {
    return true
  }

  fun save() = registerData {
    this.school = initialData.school
    this.classOf = initialData.classOf
    this.bio = initialData.bio
    this.campusAvailability += initialData.campusAvailabilityList
    this.virtualAvailability += virtualAvailability
    this.topics += initialData.topicsList
  }

  fun previous() {
    onPrevious(save())
  }

  fun next() {
    if (!validate()) return
    onNext(save())
  }

  Text(
    "Topics",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 16.dp)
        fillMaxWidth()
      },
  )
  Text(
    "What topics are you interested in tutoring?",
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 4.dp)
        fillMaxWidth()
      },
  )

  Text(
    "You can edit this information later.",
    color = Colors.Neutral50,
    modifier = modifier { padding(top = 24.dp) },
  )
  Row {
    OutlinedButton(
      onClick = ::previous,
      modifier = modifier { padding(top = 8.dp, end = 12.dp) },
      shape = RoundedCornerShape(8.dp),
    ) {
      Icon(
        Icons.Outlined.ArrowBack,
        contentDescription = "",
        modifier =
          modifier {
            padding(end = 12.dp)
            align(Alignment.CenterVertically)
          },
      )
      Text(
        "Previous",
        style = MaterialTheme.typography.labelLarge,
      )
    }
    Button(
      onClick = ::next,
      modifier = modifier { padding(top = 8.dp) },
      shape = RoundedCornerShape(8.dp),
      colors =
        ButtonDefaults.buttonColors(
          containerColor = MaterialTheme.colorScheme.primary,
          contentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    ) {
      Text(
        if (topics.isEmpty()) "Skip" else "Continue",
        style = MaterialTheme.typography.labelLarge,
      )
      Icon(
        Icons.Outlined.ArrowForward,
        contentDescription = "",
        modifier =
          modifier {
            padding(start = 12.dp)
            align(Alignment.CenterVertically)
          }
      )
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPageTopicsPreview() {
  UCTutorsTheme {
    RegisterPage(onRegister = { Ok(Unit) }) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier { fillMaxWidth() }
      ) {
        RegisterPageTopics(
          initialData = registerData {},
          onPrevious = {},
          onNext = {},
        )
      }
    }
  }
}
