package com.example.miniapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miniapp2.ui.state.CharState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val charRepository = (application as MyApp).charRepository
        val charState = CharState(charRepository)

        setContent {
            val navController = rememberNavController()

            LaunchedEffect(charState) {
                charState.getCast()
            }

            Scaffold(
                topBar = {
                    MainTopBar(navController = navController)
                },
                content = { paddingValues ->

                    // content
                    Box(modifier = Modifier.padding(paddingValues)) {

                        // navigation in screen
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                Home(navController = navController, charState = charState)
                            }
                            composable("details/{character_name}") { backStackEntry ->
                                val characterName = backStackEntry.arguments?.getString("character_name")
                                val selectedCharacter = charState.character.find { it.name == characterName }
                                selectedCharacter?.let {
                                    Details(character = it)
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navController: NavController) {
    TopAppBar(
        title = { Text("Dictionary of HPU Biography") },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
        }
    )
}



