import androidx.compose.ui.window.ComposeUIViewController
import component.RootComponent

fun mainViewController(component: RootComponent) = ComposeUIViewController { App(
    component = component
) }