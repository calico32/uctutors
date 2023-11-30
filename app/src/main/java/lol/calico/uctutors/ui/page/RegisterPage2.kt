package lol.calico.uctutors.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Result
import kotlinx.coroutines.launch
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.VirtualAvailability
import lol.calico.uctutors.generated.api.v1.campusAvailability
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.components.ButtonGrid
import lol.calico.uctutors.ui.theme.Colors

@Composable
fun RegisterPage2(
  initialData: RegisterData,
  onRegister: suspend (RegisterData) -> Result<Unit, String>,
  onPrevious: (RegisterData) -> Unit,
) {
  val scope = rememberCoroutineScope()
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
  var virtualAvailability by remember {
    if (initialData.virtualAvailabilityList.isNotEmpty()) {
      mutableStateOf(initialData.virtualAvailabilityList.toList())
    } else {
      mutableStateOf(listOf<VirtualAvailability>())
    }
  }

  val days = listOf("M", "Tu", "W", "Th", "F")

  fun validate(): Boolean {
    return true
  }

  fun previous() {
    onPrevious(
      registerData {
        school = initialData.school
        classOf = initialData.classOf
        bio = initialData.bio
        for (campus in campusAvailability) {
          this.campusAvailability += campus
        }
        for (virtual in virtualAvailability) {
          this.virtualAvailability += virtual
        }
      }
    )
  }

  fun register() {
    if (!validate()) return
    scope.launch {
      onRegister(
        registerData {
          school = initialData.school
          classOf = initialData.classOf
          bio = initialData.bio
          for (campus in campusAvailability) {
            this.campusAvailability += campus
          }
          for (virtual in virtualAvailability) {
            this.virtualAvailability += virtual
          }
        }

      )
    }
  }


  Text(
    "Campus Availability",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth(),
  )
  Text(
    "Select the lunch/co-curricular periods you are free to tutor during.",
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 4.dp)
      .fillMaxWidth(),
  )
  Row(
    modifier = Modifier
      .fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
  ) {
    days.forEach {
      Text(
        it,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .weight(1f)
          .padding(vertical = 8.dp)
      )
    }
  }

  ButtonGrid(
    items = listOf(
      days, days
    ),
    rowModifier = Modifier
      .fillMaxWidth(),
    columnModifier = Modifier
      .fillMaxWidth(),
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
  Text(
    "You can edit this information later.",
    color = Colors.Neutral50,
    modifier = Modifier
      .padding(top = 24.dp),
  )
  Row {
    OutlinedButton(
      onClick = ::previous,
      modifier = Modifier
        .padding(top = 8.dp, end = 12.dp),
      shape = RoundedCornerShape(8.dp),
    ) {
      Icon(
        Icons.Outlined.ArrowBack, contentDescription = "",
        modifier = Modifier
          .padding(end = 12.dp)
          .align(Alignment.CenterVertically),
      )
      Text(
        "Previous",
        style = MaterialTheme.typography.labelLarge,
      )
    }
    Button(
      onClick = ::register,
      modifier = Modifier
        .padding(top = 8.dp),
      shape = RoundedCornerShape(8.dp),
      colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
      ),
    ) {
      Text(
        "Continue",
        style = MaterialTheme.typography.labelLarge,
      )
      Icon(
        Icons.Outlined.ArrowForward, contentDescription = "",
        modifier = Modifier
          .padding(start = 12.dp)
          .align(Alignment.CenterVertically),
      )
    }
  }
}
