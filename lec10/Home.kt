package com.example.lec10

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lec10.ui.state.ArtState
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavController) {

    val artState:ArtState = viewModel(navController.getBackStackEntry("home")) // viewmodel 안에 store owner 넘겨줌

    var searchState by rememberSaveable{
        mutableStateOf("")
    }

    // 잠깐 앱 내리면...?
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        TextField(value = searchState, onValueChange = { searchState = it}, textStyle = TextStyle(fontSize = 30.sp))
        Button(onClick = {
            scope.launch {
                artState.search(searchState)
            }

        }) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn {
            items(artState.artwork.size){
                Column {
                    Text(artState.)
                }

            }
        }

    }
}