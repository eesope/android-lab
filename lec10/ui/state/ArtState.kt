package com.example.lec10.ui.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lec10.data.ArtPieces
import com.example.lec10.data.ArtRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArtState(private val artRepository: ArtRepository) : ViewModel() { // view model owner needed

    var artwork = mutableStateListOf<ArtPieces>()
    var searchFlow = MutableStateFlow()

    suspend fun getArtwork()
    {
        artwork.also{
            it.clear()
            it.addAll(artRepository.getArtwork().pieces)
        }
    }

    private fun collectSearchInfo(){
        viewModelScope.launch {
            searchFlow.debounce()
        }
    }

    suspend fun search(searchState: String) {
//        viewModelScope.launch { // 이 scope 가 있어서 검색 버튼 누른 후 화면 전환해도 scope cancel 되지 않고 그대로 검색 결과 data 를 갖게 됨

            artwork.also {
                it.clear()
                it.addAll(artRepository.search(str).pieces)
            }

//        }

    }
}