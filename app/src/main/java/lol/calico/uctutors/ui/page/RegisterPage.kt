package lol.calico.uctutors.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlinx.coroutines.launch
import lol.calico.uctutors.data.state.RegisterData
import lol.calico.uctutors.generated.api.v1.School
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.classYears

@Composable
fun RegisterPage(
  onRegister: suspend (RegisterData) -> Result<Unit, String>,
) {
  val scope = rememberCoroutineScope()
  var school by remember { mutableStateOf("") }
  var classYear by remember { mutableIntStateOf(0) }
  var bio by remember { mutableStateOf("") }

  val schools = listOf("AAHS", "AIT", "APA", "MHS", "UCTECH")
  val years = classYears()

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
          Text(
            "School",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp),
          )
          Row(
            modifier = Modifier
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
          ) {
            schools.forEachIndexed { i, it ->
              Button(
                modifier = Modifier
                  .fillMaxWidth()
                  .weight(it.length.toFloat() + 5),
                onClick = {
                  school = it
                },
                shape = when (i) {
                  0 -> RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                  schools.size - 1 -> RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                  else -> RectangleShape
                },
                contentPadding = PaddingValues(horizontal = 12.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (school == it) {
                    MaterialTheme.colorScheme.primary
                  } else {
                    MaterialTheme.colorScheme.primaryContainer
                  },
                  contentColor = if (school == it) {
                    MaterialTheme.colorScheme.onPrimary
                  } else {
                    MaterialTheme.colorScheme.onPrimaryContainer
                  }
                ),
              ) {
                Text(it)
              }
            }
          }
          Text(
            "Class Year",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp),
          )
          Row(
            modifier = Modifier
              .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
          ) {
            years.forEachIndexed { i, it ->
              Button(
                modifier = Modifier
                  .fillMaxWidth(0.8f)
                  .weight(1f),
                onClick = {
                  classYear = it
                },
                shape = when (i) {
                  0 -> RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                  years.size - 1 -> RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                  else -> RectangleShape
                },
                contentPadding = PaddingValues(horizontal = 12.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = if (classYear == it) {
                    MaterialTheme.colorScheme.secondary
                  } else {
                    MaterialTheme.colorScheme.secondaryContainer
                  },
                  contentColor = if (classYear == it) {
                    MaterialTheme.colorScheme.onSecondary
                  } else {
                    MaterialTheme.colorScheme.onSecondaryContainer
                  }
                ),
              ) {
                Text(it.toString())
              }
            }
          }
          Text(
            "Bio",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp),
          )
          Text(
            "This will be shown to students when they request a session with you.",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 4.dp),
          )
          Text(
            "You can edit this later.",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(top = 4.dp),
          )
          OutlinedTextField(
            bio,
            onValueChange = { bio = it },
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            label = { Text("Bio") },
            colors = TextFieldDefaults.colors(
              focusedIndicatorColor = MaterialTheme.colorScheme.primary,
              unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
            ),
          )
          Button(
            onClick = {
              scope.launch {
                onRegister(
                  RegisterData(
                    school = School.valueOf(school),
                    classYear = classYear,
                    bio = bio,
                  )
                )
              }
            },
            modifier = Modifier
              .fillMaxWidth()
              .padding(top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
              containerColor = MaterialTheme.colorScheme.primary,
              contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
          ) {
            Text("Register")
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