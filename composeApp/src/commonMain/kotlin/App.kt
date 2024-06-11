import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import cubic.CubicScreen
import list.ListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import root.component.RootComponent

@Composable
@Preview
fun App(
    component: RootComponent,
) {
    MaterialTheme {
        Children(
            stack = component.stack,
            animation = stackAnimation(fade()),
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.ListChild -> ListScreen(
                    component = child.component,
                    navigateTo = { config ->
                        component.navigate(config = config)
                    }
                )

                is RootComponent.Child.CubicChild -> CubicScreen(component = child.component)
            }
        }
    }
}