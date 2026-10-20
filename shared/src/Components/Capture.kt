package evry.thought.captive.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Capture() {
    Button(onClick = { captureThought() }) {
        Text("Capture",  style = MaterialTheme.typography.displaySmall)
    }
}

enum class CaptureProcess {
    REPEAT, DISERN, REBUKE, ABIDE
}

//data class CaptureData(val datetime: LocalDateTime)


@Composable
fun CaptureThought() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val captureStep = remember { mutableStateOf<CaptureProcess>(CaptureProcess.REPEAT) }
        //val captureData = remember { CaptureData(datetime = Clock.System.now().toLocalDateTime()) }
        when (captureStep.value) {
            CaptureProcess.REPEAT -> {
                // TODO: if they have previous entries try to see if its related to one..
                Text("Take a second and repeat your thought out loud. ")
                Text("For every one that doeth evil hateth the light, neither cometh to the light, lest his deeds should be reproved. ")
                Text("John 3:20")
                Button(onClick = {}) {
                    Text("Next")
                }
            }

            CaptureProcess.DISERN -> {
                // TODO: these are checkboxes
                Text("Rev.:20:13 And the sea gave up the dead which were in it; and death and hell delivered up the dead which were in them: and they were judged every man according to their works.")

                Text("Does this give Glory to God or to you? Rom.:11:36 For of him, and through him, and to him, are all things: to whom be glory for ever. Amen.") // TODO: Better verse?
                Text("Is this a feeling coming from the heart or from the Holy Spirit? Jer. 17:9 The heart is deceitful above all things, and desperately wicked: who can know it?")
                Text("Does this follow in the summary of the law? Matt. 22:37 Jesus said unto him, Thou shalt love the Lord thy God with all thy heart, and with all thy soul, and with all thy mind.")
                Text("Is this an act of Lust (desire or passion) for something outside God's Design?")
                Text("Rom.:1:24 Wherefore God also gave them up to uncleanness through the lusts of their own hearts, to dishonour their own bodies between themselves:\n" +
                        "Rom.:1:25 Who changed the truth of God into a lie, and worshipped and served the creature more than the Creator, who is blessed for ever. Amen.\n")
                Text("Does this affirm Jesus is Lord? John:8:42 Jesus said unto them, If God were your Father, ye would love me: for I proceeded forth and came from God; neither came I of myself, but he sent me.\n") // TODO: maybe a better verse for this?
                // TODO: these are checkboxes
                Button(onClick = {
                    // if any checked rebuke, else jump to abide
                }) {
                    Text("Next")
                }
            }

            CaptureProcess.REBUKE -> {
                Text("Here the user needs some love, support and suggestions on how to make their thought obedient to christ or move on")
                Text("James:1:12 Blessed is the man that endureth temptation: for when he is tried, he shall receive the crown of life, which the Lord hath promised to them that love him.\n" +
                        "James:1:13 Let no man say when he is tempted, I am tempted of God: for God cannot be tempted with evil, neither tempteth he any man:\n" +
                        "James:1:14 But every man is tempted, when he is drawn away of his own lust, and enticed.\n" +
                        "James:1:15 Then when lust hath conceived, it bringeth forth sin: and sin, when it is finished, bringeth forth death.\n" +
                        "James:1:16 Do not err, my beloved brethren.\n" +
                        "James:1:17 Every good gift and every perfect gift is from above, and cometh down from the Father of lights, with whom is no variableness, neither shadow of turning.\n" +
                        "James:1:18 Of his own will begat he us with the word of truth, that we should be a kind of firstfruits of his creatures.\n" +
                        "James:1:19 Wherefore, my beloved brethren, let every man be swift to hear, slow to speak, slow to wrath:\n" +
                        "James:1:20 For the wrath of man worketh not the righteousness of God.\n" +
                        "James:1:21 Wherefore lay apart all filthiness and superfluity of naughtiness, and receive with meekness the engrafted word, which is able to save your souls.\n" +
                        "James:1:22 But be ye doers of the word, and not hearers only, deceiving your own selves.\n" +
                        "James:1:23 For if any be a hearer of the word, and not a doer, he is like unto a man beholding his natural face in a glass:\n" +
                        "James:1:24 For he beholdeth himself, and goeth his way, and straightway forgetteth what manner of man he was.\n")
            }
            CaptureProcess.ABIDE-> {
                Text("Great Job! Here show some progress over time. and show some scripture to continue encouragement.")

            }
        }
    }
}


//1 Cor.:6:9 Know ye not that the unrighteous shall not inherit the kingdom of God? Be not deceived: neither fornicators, nor idolaters, nor adulterers, nor effeminate, nor abusers of themselves with mankind,
//1 Cor.:6:10 Nor thieves, nor covetous, nor drunkards, nor revilers, nor extortioners, shall inherit the kingdom of God.
//1 Cor.:6:11 And such were some of you: but ye are washed, but ye are sanctified, but ye are justified in the name of the Lord Jesus, and by the Spirit of our God.

fun Discern() {
    // this is kinda like capture? not sure if I will make them be 2 things or one.
}

// when capturing thought, make it obedient to christ. that can be done by testing it in scripture, I should compile a list of verses to convict the core sins.
fun captureThought(): String { // this could be reduced to the 2 summarys of the law (love Lord with all heart & love neighbor as self. )
    // TODO: we will capture these things so we can check habits & times.
    // Test for provoking pride? Does this give Glory to God or You? if so what?
    // Greed? Who is this for? Does this give Glory to God or You? if so what?
    // Lust, are you burning with passion for something disobedient to christ. if so what? Gal.:5:16-17
    // Envy & covet. is this selfish, test with word. what is it about?
    // glottony... ?
    // wrath, are you angry. why, with who?
    // sloth,  Spiritual apathy, laziness, or a lack of care and interest in taking action or fulfilling duties
    return ""
}
