package lol.calico.uctutors.ui.page.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.michaelbull.result.Ok
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.campusAvailability
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.components.ButtonGrid
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier

@Composable
fun ColumnScope.RegisterPageCampusAvailability(
  initialData: RegisterData,
  onPrevious: (RegisterData) -> Unit,
  onNext: (RegisterData) -> Unit,
) {
  var campusAvailability by remember {
    if (initialData.campusAvailabilityList.isNotEmpty()) {
      mutableStateOf(initialData.campusAvailabilityList.toList())
    } else {
      mutableStateOf(
        listOf(
          campusAvailability {},
          campusAvailability {},
          campusAvailability {},
          campusAvailability {},
          campusAvailability {},
          campusAvailability {
            p5 = true
            p6 = true
          },
          campusAvailability {
            p5 = true
            p6 = true
          }
        )
      )
    }
  }

  val days = listOf("M", "Tu", "W", "Th", "F")

  fun save() = registerData {
    school = initialData.school
    classOf = initialData.classOf
    bio = initialData.bio
    this.campusAvailability += campusAvailability
    this.virtualAvailability += initialData.virtualAvailabilityList
    this.topics += initialData.topicsList
  }

  fun previous() {
    onPrevious(save())
  }

  fun next() {
    onNext(save())
  }

  Text(
    "Campus Availability",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 16.dp)
        fillMaxWidth()
      }
  )
  Text(
    "Select the lunch/co-curricular periods you are free to tutor during.",
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 4.dp)
        fillMaxWidth()
      }
  )
  Row(
    modifier = modifier { fillMaxWidth() },
    horizontalArrangement = Arrangement.Center,
  ) {
    days.forEach {
      Text(
        it,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        modifier =
          modifier {
            weight(1f)
            padding(vertical = 8.dp)
          }
      )
    }
  }

  ButtonGrid(
    items = listOf(days, days),
    rowModifier = modifier { fillMaxWidth() },
    columnModifier = modifier { fillMaxWidth() },
    onClick = { _, row, col ->
      val new = campusAvailability.toMutableList()
      new[col] = campusAvailability {
        p5 = (row == 0) xor campusAvailability[col].p5
        p6 = (row == 1) xor campusAvailability[col].p6
      }
      campusAvailability = new
    },
    active = { _, row, col ->
      when (row) {
        0 -> campusAvailability[col].p5
        1 -> campusAvailability[col].p6
        else -> false
      }
    },
  ) { _, row, _ ->
    Text(
      when (row) {
        0 -> "P5"
        1 -> "P6"
        else -> ""
      }
    )
  }

  Row(
    modifier =
      modifier {
        fillMaxWidth()
        padding(top = 8.dp)
        height(40.dp)
      },
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Box(
      modifier =
        modifier {
          weight(1f)
          fillMaxHeight()
          drawWithContent {
            drawLine(
              Colors.Neutral70,
              start = Offset(0f, size.height / 2),
              end = Offset(size.width, size.height / 2),
              strokeWidth = 1.dp.toPx()
            )
          }
        }
    )
    Text(
      "AND",
      style =
        MaterialTheme.typography.labelLarge.copy(
          letterSpacing = 2.sp,
        ),
      color = Colors.Neutral70,
      textAlign = TextAlign.Center,
      modifier = modifier { padding(horizontal = 16.dp) }
    )
    Box(
      modifier =
        modifier {
          weight(1f)
          fillMaxHeight()
          drawWithContent {
            drawLine(
              Colors.Neutral70,
              start = Offset(0f, size.height / 2),
              end = Offset(size.width, size.height / 2),
              strokeWidth = 1.dp.toPx()
            )
          }
        }
    )
  }

  Row(
    modifier = modifier { fillMaxWidth() },
  ) {
    Column(
      modifier = modifier { fillMaxWidth(0.6f) },
    ) {
      Text(
        "A/B Availability",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground,
      )
      Text(
        "You can restrict your availability based on the A/B schedule as well.",
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier { padding(top = 8.dp) }
      )
    }

    Column(
      modifier = modifier { fillMaxWidth() },
    ) {
      Row(
        modifier = modifier { fillMaxWidth() },
        horizontalArrangement = Arrangement.Center,
      ) {
        Text(
          "A",
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.onBackground,
          textAlign = TextAlign.Center,
          modifier =
            modifier {
              weight(1f)
              padding(bottom = 8.dp)
            }
        )
        Text(
          "B",
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.onBackground,
          textAlign = TextAlign.Center,
          modifier =
            modifier {
              weight(1f)
              padding(bottom = 8.dp)
            }
        )
      }
      ButtonGrid(
        items = listOf(listOf("A", "B"), listOf("A", "B")),
        rowModifier = modifier { fillMaxWidth() },
        columnModifier = modifier { fillMaxWidth() },
        onClick = { _, row, col ->
          val new = campusAvailability.toMutableList()
          new[col + 5] = campusAvailability {
            p5 = (row == 0) xor campusAvailability[col + 5].p5
            p6 = (row == 1) xor campusAvailability[col + 5].p6
          }
          campusAvailability = new
        },
        active = { _, row, col ->
          when (row) {
            0 -> campusAvailability[col + 5].p5
            1 -> campusAvailability[col + 5].p6
            else -> false
          }
        },
      ) { _, row, _ ->
        Text(
          when (row) {
            0 -> "P5"
            1 -> "P6"
            else -> ""
          }
        )
      }
    }
  }

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
        "Continue",
        style = MaterialTheme.typography.labelLarge,
      )
      Icon(
        Icons.Outlined.ArrowForward,
        contentDescription = "",
        modifier =
          modifier {
            padding(start = 12.dp)
            align(Alignment.CenterVertically)
          },
      )
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPageCampusAvailabilityPreview() {
  UCTutorsTheme {
    RegisterPage(onRegister = { Ok(Unit) }) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier { fillMaxWidth() }
      ) {
        RegisterPageCampusAvailability(
          initialData = registerData {},
          onNext = { Ok(Unit) },
          onPrevious = {},
        )
      }
    }
  }
}
