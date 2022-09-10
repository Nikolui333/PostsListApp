package com.sem.postslistapp.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.postslistapp.domain.useCase.PostsUseCase
import kotlinx.coroutines.launch

class PostsViewModel(private val postsUseCase: PostsUseCase) : ViewModel() {

    val loadPosts = postsUseCase.loadPosts()

    fun migration(context: Context) = viewModelScope.launch {
        postsUseCase.startMigration(context)
    }

}