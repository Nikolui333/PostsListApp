package com.sem.postslistapp.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.postslistapp.data.models.PostsLocalModel
import com.sem.postslistapp.domain.repository.PostsCall

class PostsUseCase(private val postsCall: PostsCall) {

    fun loadPosts(): LiveData<List<PostsLocalModel>> {

        return postsCall.loadPosts()

    }

    suspend fun startMigration (context: Context) {

        postsCall.startMigration(context)

    }

}