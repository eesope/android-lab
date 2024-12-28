package com.example.miniapp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.miniapp2.data.Character


@Composable
fun Details(character: Character) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            model = character.profileImg,
            contentDescription = "Character Image",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = character.name, fontSize = 30.sp)
        Text(text = "House: ${character.house}", fontSize = 20.sp)
        Text(text = "Patronus: ${character.patronus}", fontSize = 20.sp)
    }
}