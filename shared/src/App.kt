package evry.thought.captive

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import evry.thought.captive.Screens.Landing
import evry.thought.captive.resources.Felipa
import evry.thought.captive.resources.Merienda
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import evry.thought.captive.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun FelipaBoldFamily() = FontFamily(
    Font(Res.font.Felipa, weight = FontWeight.Bold)
)

@Composable
fun MeriendaBoldFamily() = FontFamily(
    Font(Res.font.Merienda, weight = FontWeight.Bold)
)

@Composable
fun MeriendaFamily() = FontFamily(
    Font(Res.font.Merienda, weight = FontWeight.Medium)
)

@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = Color(0XFF0F1622),
            onPrimary = Color(0XFFC2B8B0),
            secondary = Color(0XFFA9757F),
            onSecondary = Color(0XFFC2B8B0),
            tertiary = Color(0XFF483F5B),
            error = Color(0XFFE4947B),

        ),
        typography = MaterialTheme.typography.copy(
            displayLarge = MaterialTheme.typography.displayLarge.copy(
            fontFamily = FelipaBoldFamily(),
            fontSize = 35.sp
        ),
            displayMedium = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FelipaBoldFamily(),
                fontSize = 25.sp
            ),
            displaySmall = MaterialTheme.typography.displaySmall.copy(
                fontFamily = MeriendaBoldFamily(),
                fontSize = 20.sp
            ),
            bodyLarge = MaterialTheme.typography.bodyLarge.copy(fontFamily = MeriendaFamily()),
            bodyMedium = MaterialTheme.typography.bodyMedium.copy(fontFamily = MeriendaFamily()),
            bodySmall = MaterialTheme.typography.bodySmall.copy(fontFamily = MeriendaFamily()),)
    ) {
        appRoot()
    }
}

