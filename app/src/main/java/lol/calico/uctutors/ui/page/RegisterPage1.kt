package lol.calico.uctutors.ui.page

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.ui.components.ButtonGroup
import lol.calico.uctutors.ui.components.ColorPalette
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.classYears
import lol.calico.uctutors.util.schoolFrom
import lol.calico.uctutors.util.schoolToString

@Composable
fun RegisterPage1(
  initialData: RegisterData,
  onNext: (RegisterData) -> Unit,
) {
  var school by remember { mutableStateOf(schoolToString(initialData.school)) }
  var classOf by remember { mutableIntStateOf(initialData.classOf) }
  var bio by remember { mutableStateOf(initialData.bio) }

  val schools = listOf("AAHS", "AIT", "APA", "MHS", "UCTECH")
  val years = classYears()

  var schoolError by remember { mutableStateOf(false) }
  var classYearError by remember { mutableStateOf(false) }

  fun validate(): Boolean {
    schoolError = school.isEmpty()
    classYearError = classOf == 0

    return !(schoolError || classYearError)
  }

  fun next() {
    if (!validate()) return
    onNext(
      registerData {
        this.school = schoolFrom(school)
        this.classOf = classOf
        this.bio = bio
      }
    )
  }


  Text(
    "School",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth(),
  )

  ButtonGroup(
    items = schools,
    modifier = Modifier.fillMaxWidth(),
    onClick = { it ->
      school = it
      schoolError = false
    },
    weight = { it.length + 5f },
    active = { school == it }
  ) {
    Text(it)
  }

  if (schoolError) {
    Text(
      "Please select a school.",
      color = MaterialTheme.colorScheme.error,
      modifier = Modifier
        .padding(top = 2.dp)
        .fillMaxWidth(),
    )
  }

  Text(
    "Class Year",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth(),
  )
  ButtonGroup(
    items = years,
    modifier = Modifier.fillMaxWidth(),
    colorPalette = ColorPalette.Secondary,
    onClick = { year, _ ->
      classOf = year
      classYearError = false
    },
    active = { year, _ -> classOf == year },
  ) { year, i ->
    Text(year.toString())
  }
  if (classYearError) {
    Text(
      "Please select a class year.",
      color = MaterialTheme.colorScheme.error,
      modifier = Modifier
        .padding(top = 2.dp)
        .fillMaxWidth(),
    )
  }
  Text(
    "Bio",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth(),
  )
  Text(
    "This will be shown on your public profile.",
    color = MaterialTheme.colorScheme.onBackground,
    modifier = Modifier
      .padding(top = 4.dp)
      .fillMaxWidth(),
  )
  OutlinedTextField(
    bio,
    onValueChange = { bio = it },
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 8.dp),
    label = { Text("Bio") },
  )
  Text(
    "You can edit this information later.",
    color = Colors.Neutral50,
    modifier = Modifier
      .padding(top = 24.dp),
  )
  Button(
    onClick = ::next,
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
