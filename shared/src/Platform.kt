package evry.thought.captive

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
