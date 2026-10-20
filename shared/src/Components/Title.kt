package evry.thought.captive.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title() {
    Row(modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 5.dp), horizontalArrangement = Arrangement.Center) {
        Text("CAPTIVE", style = MaterialTheme.typography.displayLarge, color = Color.White, fontSize = 70.sp)
    }
    Row(horizontalArrangement = Arrangement.Start) {
        Text("... Bring into captivity every thought to the obedience of Christ.", style = MaterialTheme.typography.bodySmall, fontStyle = FontStyle.Italic, color = Color.White)
    }
}