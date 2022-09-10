package com.sem.postslistapp.data.dataSource

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.postslistapp.data.models.PostsLocalModel

interface PostsDataSource {

    fun insert(postsLocalModel: PostsLocalModel)

    fun loadPosts(): LiveData<List<PostsLocalModel>>

    suspend fun clear()

}