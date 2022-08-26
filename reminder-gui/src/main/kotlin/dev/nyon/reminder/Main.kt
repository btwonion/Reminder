package dev.nyon.reminder

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import compose.icons.FeatherIcons
import compose.icons.feathericons.Box
import compose.icons.feathericons.Edit
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Sun

private enum class Screen(val displayName: String, val icon: ImageVector) {

    OVERVIEW("Overview", FeatherIcons.Box), EDIT("Edit", FeatherIcons.Edit)

}

@OptIn(ExperimentalMaterial3Api::class)
fun main() {

    application {
        var dark by remember { mutableStateOf(true) }

        MaterialTheme(if (dark) darkColorScheme() else lightColorScheme()) {
            var currentScreen by remember { mutableStateOf(Screen.OVERVIEW) }

            Window(
                onCloseRequest = { exitApplication() },
                title = "Reminder",
                state = rememberWindowState(width = 1200.dp, height = 800.dp)
            ) {
                Row {
                    NavigationBar {
                        remember { Screen.values() }.forEach {
                            NavigationBarItem(currentScreen == it,
                                onClick = { currentScreen = it },
                                icon = { Icon(it.icon, it.displayName) },
                                label = { Text(it.displayName) })
                        }

                        Spacer(Modifier.weight(1f))
                        IconButton(onClick = { dark = !dark }) {
                            Icon(if (dark) FeatherIcons.Sun else FeatherIcons.Moon, "Toggle theme")
                        }
                    }
                }

            }
        }

    }

}