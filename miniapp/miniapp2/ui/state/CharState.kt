package com.example.miniapp2.ui.state

import androidx.compose.runtime.mutableStateListOf
import com.example.miniapp2.data.Character
import com.example.miniapp2.data.CharRepository


class CharState(private val charRepository: CharRepository) {

    var character = mutableStateListOf<Character>()

    suspend fun getCast(){
        character.also{
            it.clear()
            val character = charRepository.getCast()
            val filteredCharacter = filterJson(character)
            it.addAll(filteredCharacter)
        }
    }

     fun filterJson(pieces: List<Character>): List<Character> {
         return pieces.map { character ->
             Character(
                 name = character.name,
                 house = character.house,
                 patronus = character.patronus,
                 profileImg = character.profileImg
             )
         }
     }
}