package com.sem.postslistapp.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.postslistapp.data.dataSource.PostsApiDataSource
import com.sem.postslistapp.data.dataSource.PostsDataSource
import com.sem.postslistapp.data.models.PostsLocalModel
import com.sem.postslistapp.domain.repository.PostsCall

class PostsRepository(private val apiDataSource: PostsApiDataSource,
                      private val dataSource: PostsDataSource
) : PostsCall {

    override fun loadPosts(): LiveData<List<PostsLocalModel>> {
        return dataSource.loadPosts()
    }

    override suspend fun startMigration(context: Context) {
        dataSource.clear()
        apiDataSource.startMigration(context)
    }

}