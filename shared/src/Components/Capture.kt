package evry.thought.captive.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import evry.thought.captive.resources.Res
import evry.thought.captive.resources.massimiliano_morosinotto
import org.jetbrains.compose.resources.painterResource

@Composable
fun Capture(toCapture: () -> Boolean) {
    Button(onClick = { toCapture() }) {
        Text("Capture",  style = MaterialTheme.typography.displaySmall)
    }
}

enum class CaptureProcess {
    REPEAT, DISERN, REBUKE, REPENT, ABIDE
}

data class CaptureData(val glory: MutableState<RadioChoices>,
                       val comingFrom: MutableState<RadioChoices>,
                       val law: MutableState<RadioChoices>,
                       val lust: MutableState<RadioChoices>,
                       val affirm: MutableState<RadioChoices>) {

    fun abiding() : Boolean { // if all answers are correct the user is abiding in God.
        if (this.affirm.value == RadioChoices.YES && this.law.value == RadioChoices.YES && this.lust.value == RadioChoices.DESIGN && this.comingFrom.value == RadioChoices.HOLY && this.glory.value == RadioChoices.GOD) {
            return true
        }
        return false
    }

}


@Composable
fun CaptureActionButtons(nextAction: () -> Unit, toLanding: () -> Boolean) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
        Button(onClick = nextAction) {
            Text("Continue")
        }
        Button(onClick = { toLanding() }) {
            Text("Home")
        }
    }
}

@Composable
fun VerseDisplay(verse: Verse) {
    Row(modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 16.dp, bottom = 4.dp)) {
        Text("\"${verse.ver}\"",  style = MaterialTheme.typography.bodyMedium, fontStyle = FontStyle.Italic)
    }
    Row(modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 4.dp, bottom = 16.dp)) {
        Text(verse.ref, style = MaterialTheme.typography.bodySmall, fontStyle = FontStyle.Italic)
    }
}

@Composable
fun FormResults(formData: CaptureData) {
    when {
        (formData.law.value == RadioChoices.NO) -> {
            Text("TODO: here Show them verses on what it means to follow the summary of the law.")
        }
        (formData.lust.value == RadioChoices.DESIRE) -> {
            Text("TODO: show them the heart is evil above all things, when sin concieve, and we should walk in the spirit not in the flesh")
        }
        else -> {}
    }

}