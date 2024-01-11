package lol.calico.uctutors.ui.page.you

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import lol.calico.uctutors.generated.api.v1.Experience
import lol.calico.uctutors.generated.api.v1.School
import lol.calico.uctutors.generated.api.v1.User
import lol.calico.uctutors.ui.components.Fill
import lol.calico.uctutors.ui.components.RemoteImage
import lol.calico.uctutors.ui.compose.BaselineLayout
import lol.calico.uctutors.ui.compose.LocalUser
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.TestData
import lol.calico.uctutors.util.modifier
import lol.calico.uctutors.util.schoolToString
import lol.calico.uctutors.util.toDate
import java.text.SimpleDateFormat

@Composable
fun YouPage(contentPadding: PaddingValues) {
  val user = LocalUser.current

  YouPageLayout(contentPadding, user)
}

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("SimpleDateFormat")
@Composable
fun YouPageLayout(contentPadding: PaddingValues, user: User?) {
  val scrollState = rememberScrollState()

  Column(
    modifier =
      modifier {
        fillMaxSize()
        padding(contentPadding)
        verticalScroll(scrollState)
        padding(bottom = 10.dp)
      }
  ) {
    ConstraintLayout(modifier = modifier { fillMaxWidth() }) {
      val (banner, avatar, name, school, topics) = createRefs()
      RemoteImage(
        id = user?.bannerId ?: "",
        modifier =
          modifier {
            constrainAs(banner) {
              top.linkTo(parent.top)
              start.linkTo(parent.start)
              end.linkTo(parent.end)
            }
            height(150.dp)
            background(Colors.Primary60)
          },
        contentScale = ContentScale.Fill,
      )
      RemoteImage(
        id = user?.avatarId ?: "",
        modifier =
          modifier {
            constrainAs(avatar) {
              centerAround(banner.bottom)
              start.linkTo(parent.start)
            }
            padding(Dp.Hairline)
            border(BorderStroke(6.dp, Colors.Neutral99), CircleShape)
            size(150.dp)
            clip(CircleShape)
          },
        contentScale = ContentScale.Crop,
      )

      if (user != null) {
        Text(
          user.firstName + " " + user.lastName,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.W600,
          fontSize = 24.sp,
          lineHeight = 24.sp,
          letterSpacing = 0.15.sp,
          modifier =
            modifier {
              constrainAs(name) {
                start.linkTo(avatar.end, 8.dp)
                top.linkTo(banner.bottom, 6.dp)
              }
            }
        )

        Text(
          "${schoolToString(user.school ?: School.SCHOOL_UNSPECIFIED)} '${
              (user.classOf).toString().substring(2, 4)
            }  •  Joined ${SimpleDateFormat("M/d/yy").format(user.joined.toDate())}",
          color = Colors.Neutral60,
          fontSize = 14.sp,
          modifier =
            modifier {
              constrainAs(school) {
                top.linkTo(name.bottom, 0.dp)
                start.linkTo(name.start)
              }
            }
        )

        Box(
          modifier =
            modifier {
              constrainAs(topics) {
                // strangely, this doesn't work
                // end.linkTo(parent.end)
                top.linkTo(avatar.bottom, 6.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
              }
              fillMaxWidth()
              padding(horizontal = 10.dp)
            }
        ) {
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
          ) {
            user.topicsList.forEach { topic ->
              Text(
                topic,
                fontSize = 12.sp,
                modifier =
                  modifier {
                    clip(CircleShape)
                    border(BorderStroke(1.dp, Colors.Neutral50), CircleShape)
                    background(color = Colors.Neutral95)
                    padding(horizontal = 12.dp, vertical = 4.dp)
                  }
              )
            }
          }
        }
      }
    }
    Text(
      user?.bio ?: "",
      style = MaterialTheme.typography.bodyMedium,
      modifier =
        modifier {
          padding(horizontal = 10.dp, vertical = 10.dp)
          fillMaxWidth()
        }
    )

    Row(
      horizontalArrangement = Arrangement.spacedBy(10.dp),
      modifier =
        modifier {
          fillMaxWidth()
          composed {
            val scrollThumbThickness = 1.dp
            val state = rememberScrollState()
            horizontalScroll(state)

            if (state.maxValue == 0) return@composed

            val targetAlpha = if (state.isScrollInProgress) 1f else 0f
            val duration = if (state.isScrollInProgress) 150 else 500

            val alpha by
              animateFloatAsState(
                targetValue = targetAlpha,
                animationSpec = tween(durationMillis = duration),
                label = "scrollbarAlpha"
              )

            drawWithContent {
              drawContent()
              if (state.maxValue == 0 || size.width == 0f) return@drawWithContent

              val needDrawScrollbar = state.isScrollInProgress || alpha > 0.0f

              if (!needDrawScrollbar) return@drawWithContent
              val visiblePx = size.width - state.maxValue
              val visiblePortion = (size.width - state.maxValue) / size.width
              val scrollThumbSize = (visiblePx * visiblePortion).coerceAtLeast(16.dp.toPx())
              val scrollablePx = visiblePx - scrollThumbSize
              val scrollbarOffset = (state.value / state.maxValue.toFloat()) * scrollablePx

              drawRect(
                color = Colors.Neutral70,
                topLeft =
                  Offset(
                    state.value + scrollbarOffset,
                    size.height - scrollThumbThickness.toPx(),
                  ),
                size = Size(scrollThumbSize, scrollThumbThickness.toPx()),
                alpha = alpha
              )
            }
          }
        }
    ) {
      AssistChip(
        onClick = {},
        label = { Text("Request Tutoring") },
        leadingIcon = { Icon(Icons.Outlined.School, contentDescription = "Request Tutoring") },
        modifier = modifier { padding(start = 10.dp) },
      )
      AssistChip(
        onClick = {},
        label = { Text("Message") },
        leadingIcon = { Icon(Icons.Outlined.Message, contentDescription = "Message") }
      )
      AssistChip(
        onClick = {},
        label = { Text("Email") },
        leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = "Email") },
        modifier = modifier { padding(end = 10.dp) },
      )
    }

    Text(
      "Experience",
      style = MaterialTheme.typography.titleMedium,
      modifier =
        modifier {
          padding(horizontal = 10.dp, vertical = 10.dp)
          fillMaxWidth()
        }
    )
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      user?.experiencesList?.forEach { experience -> ExperienceCard(experience) }
      user?.experiencesList?.forEach { experience -> ExperienceCard(experience) }
      user?.experiencesList?.forEach { experience -> ExperienceCard(experience) }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExperienceCard(experience: Experience) {

  Row(
    horizontalArrangement = Arrangement.spacedBy(10.dp),
    modifier =
      modifier {
        padding(horizontal = 10.dp)
        clip(RoundedCornerShape(size = 8.dp))
        border(
          width = 1.dp,
          color = Colors.Primary20.copy(alpha = 0.4f),
          shape = RoundedCornerShape(size = 8.dp)
        )
        background(Colors.Primary70.copy(alpha = 0.05f))
        fillMaxWidth()
        padding(top = 10.dp, bottom = 10.dp)
        padding(horizontal = 15.dp)
      }
  ) {
    RemoteImage(
      id = experience.imageId,
      modifier =
        modifier {
          size(90.dp)
          clip(CircleShape)
          padding(Dp.Hairline)
        },
      contentScale = ContentScale.Crop,
    )
    Column {
      Text(
        experience.title,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier { padding(bottom = 5.dp) }
      )
      Text(
        experience.description,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier { padding(bottom = 5.dp) }
      )
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        modifier = modifier { padding(top = 5.dp) }
      ) {
        experience.skillsList.forEach { skill ->
          Text(
            skill,
            fontSize = 10.sp,
            modifier =
              modifier {
                clip(CircleShape)
                border(BorderStroke(1.dp, Colors.Primary30.copy(alpha = 0.5f)), CircleShape)
                background(color = Colors.Primary95.copy(alpha = 0.3f))
                padding(horizontal = 8.dp, vertical = 2.5.dp)
              }
          )
        }
      }
    }
  }
}

@Preview(showSystemUi = true, device = "id:pixel_6_pro", fontScale = 0.85f)
@Composable
fun YouPageLayoutPreview() {
  BaselineLayout { YouPageLayout(contentPadding = it, user = TestData.user) }
}
