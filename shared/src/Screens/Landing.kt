package evry.thought.captive.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import evry.thought.captive.Components.Capture
import evry.thought.captive.Components.Title
import evry.thought.captive.Components.VerseOfDayBox
import evry.thought.captive.resources.Res
import evry.thought.captive.resources.massimiliano_morosinotto
import org.jetbrains.compose.resources.painterResource

@Composable
fun Landing(toCapture: () -> Boolean) {
    Scaffold(
        modifier = Modifier,
    ) { innerPadding ->

        Box() {
            Image(
                painter = painterResource(Res.drawable.massimiliano_morosinotto),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Title()
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.padding(20.dp)) {
                VerseOfDayBox()
            }
            Spacer(modifier = Modifier.height(60.dp))
            Capture(toCapture)
            // TODO: Encourage a friend
            // TODO: here an about screen thing with a ? icon
        }
    }

}