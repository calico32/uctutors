package lol.calico.uctutors.ui.page.calendar

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import lol.calico.uctutors.util.modifier

@Composable
fun CalendarPage(contentPadding: PaddingValues) {
  val scrollState = rememberScrollState()

  Column(
    modifier =
      modifier {
        fillMaxSize()
        padding(contentPadding)
        padding(16.dp)
        verticalScroll(scrollState)
      },
  ) {
    Text("Calendar")
  }
}

const val TAG = "@CalendarPageFab"

@Composable
fun CalendarPageFab() {
  ExtendedFloatingActionButton(
    icon = { Icon(Icons.Outlined.CalendarMonth, contentDescription = "") },
    text = { Text("Schedule") },
    onClick = { Log.d(TAG, "Clicked") },
  )
}
