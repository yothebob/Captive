package evry.thought.captive.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import evry.thought.captive.resources.Merienda
import evry.thought.captive.resources.Res
import org.jetbrains.compose.resources.Font
import kotlin.random.Random


data class Verse(val ref: String, val ver: String)

fun verseOfDay(): Verse { // TODO: make this look better
    val verses = mapOf<String, String>(
        "James 1:14-15" to
        "But every man is tempted, when he is drawn away of his own lust, and enticed.\n" +
                "Then when lust hath conceived, it bringeth forth sin: and sin, when it is finished, bringeth forth death.\n",
        "2 Cor. 10:5" to "Casting down imaginations, and every high thing that exalteth itself against the knowledge of God, and bringing into captivity every thought to the obedience of Christ;",

    "Ephesians 6:12-13" to  "For we wrestle not against flesh and blood, but against principalities, against powers, against the rulers of the darkness of this world, against spiritual wickedness in high places.\n" +
            "Eph.:6:13 Wherefore take unto you the whole armour of God, that ye may be able to withstand in the evil day, and having done all, to stand.\n",
    "1 Cor 13:4-7" to "I may boast, but do not have love, I gain nothing.\n" + "Love is patient, love is kind. It does not envy, it does not boast, it is not proud. \n" +
            "It does not dishonor others, it is not self-seeking, it is not easily angered, it keeps no record of wrongs. \n" +
            "Love does not delight in evil but rejoices with the truth. 7It always protects, always trusts, always hopes, always perseveres.\n",
       "1 Pet 5:8" to "Be sober, be vigilant; because your adversary the devil, as a roaring lion, walketh about, seeking whom he may devour.",
        "Galatians 5:22-23" to "But the fruit of the Spirit is love, joy, peace, longsuffering, gentleness, goodness, faith,\n" +
                "Meekness, temperance: against such there is no law.\n",
        "Galatians 5:25-26" to "If we live in the Spirit, let us also walk in the Spirit.\n" +
                "Let us not be desirous of vain glory, provoking one another, envying one another.\n",
        "James:1:19-20" to "Wherefore, my beloved brethren, let every man be swift to hear, slow to speak, slow to wrath:\n" +
                "For the wrath of man worketh not the righteousness of God.\n"
    )

    val thingy = verses.keys.random()
    return Verse(ref = thingy, ver = verses[thingy].toString())
}

@Composable
fun VerseOfDayBox() {
    val scrollState = rememberScrollState()
    val showModal = remember { mutableStateOf(false) }
    val verse = remember { verseOfDay() }

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5F), RoundedCornerShape(20.dp))
            .padding(20.dp)
            .clickable {
                showModal.value = !showModal.value
            }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .height(100.dp)
                .fillMaxWidth()

        ) {
            Text(text = verse.ver,
                color = MaterialTheme.colorScheme.onPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontFamily = FontFamily(
                    Font(Res.font.Merienda)
                ), fontSize = 20.sp)
            Text(text = verse.ref,
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = FontFamily(
                    Font(Res.font.Merienda)
                ), fontSize = 10.sp)
        }

    }

    if (showModal.value) {
        Dialog(
            onDismissRequest = {showModal.value = false},
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .alpha(0.5F)
                    .padding(20.dp),
                shape = RoundedCornerShape(20.dp),
            ) {
                Text(
                    text = verse.ver,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5F))
                        .padding(20.dp)
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }

//    Row(modifier = Modifier.padding(20.dp)
//        .background(Color(0xFF2f3255).copy(alpha = 0.25F)).clip(
//        RoundedCornerShape(20.dp)
//    )) {
////        Text(text = "James 1:20", fontFamily = FontFamily(
////                Font(Res.font.Merienda)
////                ), fontSize = 10.sp)
//        Text(modifier = Modifier.padding(4.dp).height(100.dp).verticalScroll(scrollState),
//            text = verseOfDay(),
//            color = Color.White,
//            maxLines = 2,
//            overflow = TextOverflow.MiddleEllipsis,
//            fontFamily = FontFamily(
//                Font(Res.font.Merienda)
//            ), fontSize = 20.sp)
//    }
}

