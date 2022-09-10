package com.sem.postslistapp.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.postslistapp.data.models.PostsLocalModel

interface PostsCall {

    fun loadPosts(): LiveData<List<PostsLocalModel>>

    suspend fun startMigration(context: Context)

}