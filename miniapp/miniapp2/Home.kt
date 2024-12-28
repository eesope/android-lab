package com.example.miniapp2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.miniapp2.ui.state.CharState


@Composable
fun Home(navController: NavController, charState: CharState) {
    Column(modifier = Modifier.fillMaxSize()) {

        // lazy to display the list of paginated card items
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(charState.character.size) { index ->
                val character = charState.character[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("details/${character.name}")
                        },
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = character.profileImg,
                            contentDescription = "Character Image",
                            modifier = Modifier.size(150.dp)
                        )
                        Text(text = character.name, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

