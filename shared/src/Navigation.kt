package evry.thought.captive

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import evry.thought.captive.Screens.CaptureThought
import evry.thought.captive.Screens.Landing
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


@Serializable
data object LandingRoute : NavKey

@Serializable
data object CaptiveRoute: NavKey

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(LandingRoute::class, LandingRoute.serializer())
            subclass(CaptiveRoute::class, CaptiveRoute.serializer())
        }
    }
}


@Composable
fun appRoot() {
    val backStack = rememberNavBackStack(
        evry.thought.captive.config,
        LandingRoute
    )

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
        ),
        entryProvider = { key ->
            when(key) {
                is LandingRoute -> {
                    NavEntry(
                        key = key,
                    ) {
                        val routeToCaptive =  {
                            backStack.add(CaptiveRoute)
                        }
                        Landing(routeToCaptive)
                    }
                }
                is CaptiveRoute -> {
                    NavEntry(
                        key = key,
                    ) {
                        val routeToLanding = {
                            backStack.add(LandingRoute)
                        }
                        CaptureThought(routeToLanding)
                    }
                }
                else -> throw RuntimeException("Invalid NavKey.")
            }
        },
    )
}