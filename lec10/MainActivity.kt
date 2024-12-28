
package com.example.lec10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.lec10.data.Endpoints
import com.example.lec10.ui.state.ArtState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val artRepository = (application as MyApp).artRepository

        setContent {

            val navController = rememberNavController()
            val artState = ArtState(artRepository)

            NavHost(navController, "home"){

                composable("home"){

                    viewModel(navController.getBackStackEntry("home")){
                        ArtState(artRepository)  // ComponentActivity 로 auto scope setting?
                    }
                    Home(navController)
                }
            }


            LaunchedEffect(artState) { // key;artState 바뀌면 이 블록은 계속 refresh
                artState.getArtwork() // now suspend function, coRouting, composable
            }
            Box() {
                LazyColumn {
                    items(artState.artwork.size) {
                        Column {
                            Text(artState.artwork[it].title, fontSize = 30.sp)
                            AsyncImage(
                                model = Endpoints.IMAGE_ENDPOINT.format(artState.artwork[it].image),
                                contentDescription = null
                            )
                            Spacer(Modifier.height(30.dp))
                        }

                    }
                }
            }
        }
    }
}


