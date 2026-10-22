package evry.thought.captive.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import evry.thought.captive.Components.CaptureActionButtons
import evry.thought.captive.Components.CaptureData
import evry.thought.captive.Components.CaptureProcess
import evry.thought.captive.Components.FormResults
import evry.thought.captive.Components.RadioButtonSingleSelection
import evry.thought.captive.Components.RadioChoices
import evry.thought.captive.Components.Verse
import evry.thought.captive.Components.VerseDisplay
import evry.thought.captive.resources.Res
import evry.thought.captive.resources.massimiliano_morosinotto
import org.jetbrains.compose.resources.painterResource


@Composable
fun CaptureThought(toLanding: () -> Boolean) {
    Scaffold(
        modifier = Modifier
    ) { innerPadding ->
        val form = remember { mutableStateOf(CaptureData(
            mutableStateOf(RadioChoices.UNSURE),
            mutableStateOf(RadioChoices.UNSURE),
            mutableStateOf(RadioChoices.UNSURE),
            mutableStateOf(RadioChoices.UNSURE),
            mutableStateOf(RadioChoices.UNSURE))) }
        Box() {
            Image(
                painter = painterResource(Res.drawable.massimiliano_morosinotto),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().blur(10.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp)
                .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5F), RoundedCornerShape(20.dp))
                .padding(16.dp)
                .fillMaxSize().verticalScroll(rememberScrollState()),
        ) {
            val captureStep = remember { mutableStateOf<CaptureProcess>(CaptureProcess.REPEAT) }
            //val captureData = remember { CaptureData(datetime = Clock.System.now().toLocalDateTime()) }
            when (captureStep.value) {
                CaptureProcess.REPEAT -> {
                    Text("Listen", style = MaterialTheme.typography.displayLarge, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(10.dp))
                    // TODO: if they have previous entries try to see if its related to one..
                    Text("Please take a second, focus on Christ and repeat your thought out loud. \n", style = MaterialTheme.typography.bodyLarge)
                    VerseDisplay(Verse(ver = "For every one that doeth evil hateth the light, neither cometh to the light, lest his deeds should be reproved.", ref = "John 3:20"))
                    Spacer(Modifier.height(20.dp))
                    Text("Ready?", style = MaterialTheme.typography.bodyLarge)
                    CaptureActionButtons({
                        captureStep.value = CaptureProcess.DISERN
                    }, toLanding)
                }

                CaptureProcess.DISERN -> {
                    Text("Disern", style = MaterialTheme.typography.displayLarge, textAlign = TextAlign.Center)
                    VerseDisplay(Verse(ver = "And the sea gave up the dead which were in it; and death and hell delivered up the dead which were in them: and they were judged every man according to their works.",
                        ref = "Revelation 20:13"))
                    Text("Fill out the following questions sincerely.", style = MaterialTheme.typography.bodyLarge)
                    Spacer(Modifier.height(8.dp))
                    Text("Does this give Glory to God or to you?") // TODO: Better verse?
                    VerseDisplay(Verse(ver = "For of him, and through him, and to him, are all things: to whom be glory for ever. Amen.",
                        ref = "Romans 11:36"))
                    RadioButtonSingleSelection(Modifier, radioOptions = listOf(RadioChoices.UNSURE,
                        RadioChoices.GOD , RadioChoices.ME), form.value.glory)
                    Text("Is this a feeling coming from the heart or from the Holy Spirit?")
                    VerseDisplay(Verse("Jeremiah 17:9", "The heart is deceitful above all things, and desperately wicked: who can know it?"))
                    RadioButtonSingleSelection(Modifier, radioOptions = listOf(RadioChoices.UNSURE,
                        RadioChoices.HEART , RadioChoices.HOLY), form.value.comingFrom)
                    Text("Does this follow in the summary of the law?")
                    VerseDisplay(Verse("Matthew 22:37", "Jesus said unto him, Thou shalt love the Lord thy God with all thy heart, and with all thy soul, and with all thy mind."))
                    RadioButtonSingleSelection(Modifier, radioOptions = listOf(RadioChoices.UNSURE,
                        RadioChoices.YES, RadioChoices.NO), form.value.law)
                    Text("Is this an act of lust (desire or passion) for something outside God's Design?")
                    VerseDisplay(
                        Verse("Romans 1:24-25","Wherefore God also gave them up to uncleanness through the lusts of their own hearts, to dishonour their own bodies between themselves:\n" +
                                "Who changed the truth of God into a lie, and worshipped and served the creature more than the Creator, who is blessed for ever. Amen.\n"))
                    RadioButtonSingleSelection(Modifier, radioOptions = listOf(RadioChoices.UNSURE,
                        RadioChoices.DESIRE , RadioChoices.DESIGN), form.value.lust)
                    Text("Does this affirm Jesus is Lord?")
                    VerseDisplay(Verse("John 8:42","Jesus said unto them, If God were your Father, ye would love me: for I proceeded forth and came from God; neither came I of myself, but he sent me.")) // TODO: maybe a better verse for this?
                    RadioButtonSingleSelection(Modifier, radioOptions = listOf(RadioChoices.UNSURE,
                        RadioChoices.YES , RadioChoices.NO), form.value.affirm)
                    CaptureActionButtons({
                        println(form.value)
                        if (form.value.abiding()) {
                            captureStep.value = CaptureProcess.ABIDE
                        } else {
                            captureStep.value = CaptureProcess.REBUKE
                        }
                    }, toLanding)
                }

                CaptureProcess.REBUKE -> {
                    Text("Lets align your thought according to Christ")
                    VerseDisplay(Verse("James 1:13-16",
                                                        "Let no man say when he is tempted, I am tempted of God: for God cannot be tempted with evil, neither tempteth he any man:\n" +
                                "But every man is tempted, when he is drawn away of his own lust, and enticed.\n" +
                                "Then when lust hath conceived, it bringeth forth sin: and sin, when it is finished, bringeth forth death.\n" +
                                "Do not err, my beloved brethren.\n"
                        ))
                    Text("How To Proceed:\n", textDecoration = TextDecoration.Underline)
                    Text("• Talk to a friend,\n • Spend 10-20 mins in prayer or in the word.\n • Assess your situation and see if there are any triggers. Implement plan to cut off those triggers.\n • Have an accountability partner.")

                    FormResults(form.value)

                    CaptureActionButtons({
                        captureStep.value = CaptureProcess.REPENT
                        // if any checked rebuke, else jump to abide
                    }, toLanding)
                }

                CaptureProcess.REPENT -> {
                    Text("Your doing great! ")
                    VerseDisplay(Verse("1 Corinthians 6:9-11", "Know ye not that the unrighteous shall not inherit the kingdom of God? Be not deceived: neither fornicators, nor idolaters, nor adulterers, nor effeminate, nor abusers of themselves with mankind,\n" +
                            "Nor thieves, nor covetous, nor drunkards, nor revilers, nor extortioners, shall inherit the kingdom of God.\n" +
                            "And such were some of you: but ye are washed, but ye are sanctified, but ye are justified in the name of the Lord Jesus, and by the Spirit of our God."))
                    Text("1 Corinthians reminds us that we WERE those things but are now a new creation justified by Jesus. We are called to live in the spirit and not in the flesh.")
                    VerseDisplay(Verse("Galatians 5:24","And they that are Christ's have crucified the flesh with the affections and lusts.\n" +
                            "If we live in the Spirit, let us also walk in the Spirit."))
                    Text("Part of walking in the spirit is recognizing the spiritual battle around us, we are armored by god and called to fight.")
                    VerseDisplay(Verse(
                "Ephesians 6:10","Finally, my brethren, be strong in the Lord, and in the power of his might.\n" +
                        "Put on the whole armour of God, that ye may be able to stand against the wiles of the devil.\n" +
                        "For we wrestle not against flesh and blood, but against principalities, against powers, against the rulers of the darkness of this world, against spiritual wickedness in high places.\n" +
                        "Wherefore take unto you the whole armour of God, that ye may be able to withstand in the evil day, and having done all, to stand.\n" +
                        "Stand therefore, having your loins girt about with truth, and having on the breastplate of righteousness;\n" +
                        "And your feet shod with the preparation of the gospel of peace;\n" +
                        "Above all, taking the shield of faith, wherewith ye shall be able to quench all the fiery darts of the wicked.\n" +
                        "And take the helmet of salvation, and the sword of the Spirit, which is the word of God:\n" +
                        "Praying always with all prayer and supplication in the Spirit, and watching thereunto with all perseverance and supplication for all saints;"
                    ))
                    Button(onClick = {
                        toLanding()
                    }) {
                        Text("Finish")
                    }
                }

                CaptureProcess.ABIDE -> {
                    Text("Great Job! ")
                    //TODO: Here show some progress over time. and show some scripture to continue encouragement.
                    VerseDisplay(Verse("Isaiah 26:3", "Thou wilt keep him in perfect peace, whose mind is stayed on thee: because he trusteth in thee."))
                    Text("Take this time to encourage your fellow believers on their journey too!")
                    VerseDisplay(Verse("1 Thessalonians 5:11", "Wherefore comfort yourselves together, and edify one another, even as also ye do."))

                    Button(onClick = {
                        toLanding()
                    }) {
                        Text("Finish")
                    }
                }
            }
        }
    }
}

