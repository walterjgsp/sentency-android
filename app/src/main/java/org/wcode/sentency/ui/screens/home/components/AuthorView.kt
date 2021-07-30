package org.wcode.sentency.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import org.wcode.sentency.domain.network.responses.AuthorResponse
import org.wcode.sentency.ui.theme.SentencyColors

@Composable
fun AuthorView(authorResponse: AuthorResponse) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(50.dp)) {
            when (authorResponse.picUrl) {
                is String -> {
                    Image(
                        painter = rememberCoilPainter(
                            request = authorResponse.picUrl
                        ),
                        contentDescription = "Author image",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                            .border(2.dp, SentencyColors.Purple700, CircleShape)
                    )
                }
                else -> {
                    Icon(
                        Icons.Default.Person, "Default Author",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                            .border(2.dp, SentencyColors.Purple700, CircleShape)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = authorResponse.name,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )
    }
}