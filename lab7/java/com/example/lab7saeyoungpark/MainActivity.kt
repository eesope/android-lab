package com.example.lab7saeyoungpark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp

data class Starwars(val name: String, val imageID: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val names = stringArrayResource(id = R.array.starwars_names)
            // ???????? Starwars(names[i], R.drawable.${ names[i] })

            // actual data list
            val starwarsList = listOf(
                Starwars(names[0], R.drawable.ahsoka),
                Starwars(names[1], R.drawable.bb8),
                Starwars(names[2], R.drawable.c3po),
                Starwars(names[3], R.drawable.chewbacca),
                Starwars(names[4], R.drawable.grogu),
                Starwars(names[5], R.drawable.jabba),
                Starwars(names[6], R.drawable.kilo),
                Starwars(names[7], R.drawable.trooper),
                Starwars(names[8], R.drawable.yoda),
                )

            // state list for shuffle
            val starwarsStateList = remember {
                starwarsList.toMutableStateList()
            }

            // cards in rows 3*3; scroll x*y
            val rowSize = (starwarsStateList.size)/3
            val row1 = starwarsStateList.subList(0, rowSize)
            val row2 = starwarsStateList.subList(rowSize, rowSize*2)
            val row3 = starwarsStateList.subList(rowSize*2, starwarsList.size)


            Box(
                modifier = Modifier
            ){
                Column (
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                    ) {

                    Row {
                        Button(
                            onClick = {
                                starwarsStateList.shuffle()
                            }
                        ) {
                            Text(text = "Shuffle")
                        }
                    }

                    Row {
                        // scrollable with LazyColumn
                        LazyColumn {

                            item {
                                LazyRow {
                                    items(
                                        row1.size
                                    ) {
                                        ItemCard(row1[it])
                                    }
                                }
                            }

                            item {
                                LazyRow {
                                    items(
                                        row2.size
                                    ) {
                                        ItemCard(row2[it])
                                    }
                                }
                            }

                            item {
                                LazyRow {
                                    items(
                                        row3.size
                                    ) {
                                        ItemCard(row3[it])
                                    }
                                }
                            }
                        }

                    }
                }
            }


        }
    }
}

@Composable
fun ItemCard(starwars: Starwars){

     var isExpanded by remember {
         mutableStateOf(false)
     }

    Card(modifier = Modifier
        .padding(12.dp)
        .clickable { isExpanded =! isExpanded }
        .animateContentSize()

    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            if (!isExpanded) {
                Text( text = starwars.name)
                Image(
                    painter = painterResource(id = starwars.imageID),
                    contentDescription = "Image of ${starwars.name}",
                    modifier = Modifier.size(100.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = starwars.imageID),
                    contentDescription = "Image of ${starwars.name}",
                    modifier = Modifier.size(300.dp)
                )
            }
        }
    }
}


