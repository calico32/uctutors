package lol.calico.uctutors.ui.page.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.github.michaelbull.result.Ok
import com.google.protobuf.Timestamp
import com.google.type.DayOfWeek
import com.google.type.Interval
import kotlinx.coroutines.launch
import lol.calico.uctutors.generated.api.v1.RegisterData
import lol.calico.uctutors.generated.api.v1.VirtualAvailability
import lol.calico.uctutors.generated.api.v1.registerData
import lol.calico.uctutors.generated.api.v1.virtualAvailability
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier
import lol.calico.uctutors.util.titlecase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScope.RegisterPageVirtualAvailability(
  initialData: RegisterData,
  onPrevious: (RegisterData) -> Unit,
  onNext: (RegisterData) -> Unit,
) {
  val scope = rememberCoroutineScope()
  val configuration = LocalConfiguration.current
  val scrollState = rememberScrollState()
  var virtualAvailability by remember {
    if (initialData.virtualAvailabilityList.isNotEmpty()) {
      mutableStateOf(initialData.virtualAvailabilityList.toList())
    } else {
      mutableStateOf(listOf<VirtualAvailability>())
    }
  }

  val days = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

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
    "Virtual Availability",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 16.dp)
        fillMaxWidth()
      }
  )
  Text(
    "If you are available for virtual tutoring, please select the times you would like to tutor.",
    color = MaterialTheme.colorScheme.onBackground,
    modifier =
      modifier {
        padding(top = 4.dp)
        fillMaxWidth()
      }
  )

  Column(
    modifier =
      modifier {
        padding(top = 16.dp)
        fillMaxWidth()
        heightIn(0.dp, configuration.screenHeightDp.dp - 600.dp)
        composed { verticalScroll(scrollState) }
      }
  ) {
    virtualAvailability.forEachIndexed { i, it ->
      Row(
        modifier =
          modifier {
            padding(top = 10.dp)
            fillMaxWidth()
            clip(RoundedCornerShape(100))
            background(Colors.Secondary90)
            padding(vertical = 4.dp)
            padding(start = 16.dp, end = 8.dp)
          },
        verticalAlignment = Alignment.CenterVertically,
      ) {
        CompositionLocalProvider(
          LocalContentColor provides Color.Black,
        ) {
          Box(
            modifier =
              modifier {
                weight(1f)
                padding(end = 4.dp)
              }
          ) {
            var dialogOpen by remember { mutableStateOf(false) }
            Text(
              if (it.day != DayOfWeek.DAY_OF_WEEK_UNSPECIFIED) it.day.name.titlecase() else "Day",
              style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
              textAlign = TextAlign.Left,
              modifier =
                modifier {
                  clip(RoundedCornerShape(100))
                  if (it.day == DayOfWeek.DAY_OF_WEEK_UNSPECIFIED) {
                    background(Colors.Error90)
                  }
                  clickable { dialogOpen = true }
                  padding(vertical = 4.dp, horizontal = 8.dp)
                }
            )
            if (dialogOpen) {

              Dialog(
                onDismissRequest = { dialogOpen = false },
              ) {
                Card {
                  Column {
                    days.forEach { day ->
                      Text(
                        day,
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
                        textAlign = TextAlign.Center,
                        modifier =
                          modifier {
                            clip(RoundedCornerShape(100))
                            clickable {
                              virtualAvailability =
                                virtualAvailability.toMutableList().also { list ->
                                  list[i] = virtualAvailability {
                                    this.day = DayOfWeek.valueOf(day.uppercase())
                                    interval = it.interval
                                  }
                                }
                              dialogOpen = false
                            }
                            padding(vertical = 4.dp, horizontal = 8.dp)
                          }
                      )
                    }
                  }
                }
              }
            }
          }

          val initialStartTime = (it.interval.startTime).toTime()
          val startTime =
            rememberTimePickerState(
              initialHour = initialStartTime.hour,
              initialMinute = initialStartTime.minute,
            )
          var startTimeDialogOpen by remember { mutableStateOf(false) }
          Text(
            it.interval.startTime.toTime().toTimeString(),
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier =
              modifier {
                weight(0.7f)
                clip(RoundedCornerShape(100))
                clickable { startTimeDialogOpen = true }
                padding(vertical = 4.dp)
              }
          )
          if (startTimeDialogOpen) {
            Dialog(
              onDismissRequest = { startTimeDialogOpen = false },
            ) {
              Card(modifier = modifier { background(Color.White) }) {
                Column {
                  Text(
                    "Start Time",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
                    textAlign = TextAlign.Center,
                    modifier =
                      modifier {
                        clip(RoundedCornerShape(100))
                        padding(vertical = 4.dp, horizontal = 8.dp)
                      }
                  )
                  TimePicker(
                    state = startTime,
                    modifier = modifier { padding(vertical = 4.dp, horizontal = 8.dp) }
                  )
                  Button(
                    onClick = {
                      virtualAvailability =
                        virtualAvailability.toMutableList().also { list ->
                          list[i] = virtualAvailability {
                            this.day = it.day
                            interval =
                              Interval.newBuilder()
                                .setStartTime(startTime.toTime().toTimestamp())
                                .setEndTime(it.interval.endTime)
                                .build()
                          }
                        }
                      startTimeDialogOpen = false
                    },
                    modifier = modifier { padding(vertical = 4.dp, horizontal = 8.dp) }
                  ) {
                    Text("Save")
                  }
                }
              }
            }
          }

          Text(
            "-",
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier = modifier { padding(horizontal = 1.dp) }
          )

          Text(
            it.interval.endTime.toTime().toTimeString(),
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Center,
            modifier =
              modifier {
                weight(0.7f)
                clip(RoundedCornerShape(100))
                clickable {}
                padding(vertical = 4.dp)
              }
          )

          IconButton(
            onClick = {
              virtualAvailability =
                virtualAvailability.toMutableList().also { list -> list.removeAt(i) }
            },
            modifier = modifier { clickable {} },
          ) {
            Icon(Icons.Outlined.Close, contentDescription = "")
          }
        }
      }
    }
  }
  Button(
    colors =
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
      ),
    modifier =
      modifier {
        align(Alignment.Start)
        padding(top = 16.dp)
      },
    onClick = {
      scope.launch {
        virtualAvailability =
          virtualAvailability +
            listOf(
              virtualAvailability {
                day = DayOfWeek.DAY_OF_WEEK_UNSPECIFIED
                interval =
                  Interval.newBuilder()
                    .setStartTime(Time.fromTimeString("12:00 AM").toTimestamp())
                    .setEndTime(Time.fromTimeString("12:00 AM").toTimestamp())
                    .build()
              }
            )
        scrollState.animateScrollTo(scrollState.maxValue)
      }
    },
    contentPadding = PaddingValues(vertical = 12.dp, horizontal = 28.dp)
  ) {
    Icon(Icons.Outlined.Add, contentDescription = "")
    Text("New")
  }

  Text(
    "You can edit this information later.",
    color = Colors.Neutral50,
    modifier = modifier { padding(top = 24.dp) }
  )
  Row {
    OutlinedButton(
      onClick = ::previous,
      modifier = modifier { padding(top = 8.dp, end = 12.dp) },
      shape = RoundedCornerShape(8.dp)
    ) {
      Icon(
        Icons.Outlined.ArrowBack,
        contentDescription = "",
        modifier =
          modifier {
            padding(end = 12.dp)
            align(Alignment.CenterVertically)
          }
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
        if (virtualAvailability.isEmpty()) "Skip" else "Continue",
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

@Preview(showSystemUi = true, device = "id:pixel_6_pro", fontScale = 0.85f)
@Composable
fun RegisterPageVirtualAvailabilityPreview() {
  UCTutorsTheme {
    RegisterPage(onRegister = { Ok(Unit) }) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier { fillMaxWidth() }
      ) {
        RegisterPageVirtualAvailability(
          initialData =
            registerData {
              virtualAvailability.addAll(
                listOf(
                  virtualAvailability {
                    day = DayOfWeek.MONDAY
                    interval =
                      Interval.newBuilder()
                        .setStartTime(Time.fromTimeString("10:00 AM").toTimestamp())
                        .setEndTime(Time.fromTimeString("12:00 PM").toTimestamp())
                        .build()
                  },
                  virtualAvailability {
                    day = DayOfWeek.WEDNESDAY
                    interval =
                      Interval.newBuilder()
                        .setStartTime(Time.fromTimeString("12:00 PM").toTimestamp())
                        .setEndTime(Time.fromTimeString("2:00 PM").toTimestamp())
                        .build()
                  },
                  virtualAvailability {
                    day = DayOfWeek.FRIDAY
                    interval =
                      Interval.newBuilder()
                        .setStartTime(Time.fromTimeString("12:00 PM").toTimestamp())
                        .setEndTime(Time.fromTimeString("2:00 PM").toTimestamp())
                        .build()
                  },
                )
              )
            },
          onPrevious = {},
          onNext = {},
        )
      }
    }
  }
}

data class Time(val hour: Int, val minute: Int) {
  fun toTimestamp(): Timestamp {
    val seconds = (hour * 3600) + (minute * 60)
    return Timestamp.newBuilder().setSeconds(seconds.toLong()).setNanos(0).build()
  }

  fun toTimeString(): String {
    return if (hour < 12) {
      "%d:%02d AM".format(hour, minute)
    } else {
      "%d:%02d PM".format(if (hour == 12) hour else hour - 12, minute)
    }
  }

  companion object {
    fun fromTimeString(str: String): Time {
      val (time, ampm) = str.split(" ")
      val (hour, minute) = time.split(":")
      var hourInt = hour.toInt()
      val minuteInt = minute.toInt()
      if (ampm == "PM" && hourInt < 12) {
        hourInt += 12
      }
      return Time(hourInt, minuteInt)
    }
  }
}

fun Timestamp.toTime(): Time {
  val hour = seconds / 3600
  val minute = (seconds % 3600) / 60
  return Time(hour.toInt(), minute.toInt())
}

@OptIn(ExperimentalMaterial3Api::class) fun TimePickerState.toTime(): Time = Time(hour, minute)
