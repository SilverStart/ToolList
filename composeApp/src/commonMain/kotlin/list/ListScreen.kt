package list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import root.component.DefaultRootComponent

@Composable
fun ListScreen(
    component: ListComponent,
    navigateTo: (DefaultRootComponent.Config) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(
                text = "1. Cubic Background",
                fontSize = 24.sp,
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
                    .clickable {
                        navigateTo(DefaultRootComponent.Config.Cubic)
                    }
                    .padding(16.dp)
            )
        }
    }
}