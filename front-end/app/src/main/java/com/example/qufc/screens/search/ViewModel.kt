package com.example.qufc.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class VideoItem(
    val title: String,
    val userName: String,
    val date: String
)

class SearchViewModel : ViewModel() {

    // Estado para o campo de busca
    var searchQuery by mutableStateOf("")
        private set

    // Lista de vídeos
    var videoList by mutableStateOf(listOf<VideoItem>())
        private set

    // Lista filtrada com base na pesquisa
    var filteredVideoList by mutableStateOf(listOf<VideoItem>())
        private set

    init {
        // Simula o carregamento de dados
        loadVideos()
    }

    private fun loadVideos() {
        viewModelScope.launch {
            // Simula um carregamento do back-end
            delay(1000)
            videoList = listOf(
                VideoItem("Resolução lista Matemática Discreta - Somatórios", "Usuário 1", "01/02/24"),
                VideoItem("Introdução à Álgebra Linear", "Usuário 2", "02/02/24"),
                VideoItem("Geometria Analítica - Vetores", "Usuário 3", "03/02/24"),
                VideoItem("Resolução lista de Física - Dinâmica", "Usuário 4", "04/02/24"),
                VideoItem("Matemática Discreta - Conjuntos", "Usuário 5", "05/02/24")
            )
            filteredVideoList = videoList
        }
    }

    // Atualiza a pesquisa
    fun onSearchQueryChanged(query: String) {
        searchQuery = query
        filteredVideoList = if (query.isBlank()) {
            videoList
        } else {
            videoList.filter { it.title.contains(query, ignoreCase = true) }
        }
    }
}
