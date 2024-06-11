package silver.star.toollist

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import root.component.DefaultRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component =
            DefaultRootComponent(
                componentContext = defaultComponentContext(),
            )

        setContent {
            App(component = component)
        }
    }
}