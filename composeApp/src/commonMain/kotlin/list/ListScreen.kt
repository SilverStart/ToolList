package list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import root.component.DefaultRootComponent

@Composable
fun ListScreen(
    component: ListComponent,
    navigateTo: (DefaultRootComponent.Config) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "go to cubic!",
            fontSize = 24.sp,
            modifier = Modifier.clickable {
                navigateTo(DefaultRootComponent.Config.Cubic)
            }
        )
    }
}