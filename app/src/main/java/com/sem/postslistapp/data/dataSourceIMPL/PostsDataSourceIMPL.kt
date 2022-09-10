package com.sem.postslistapp.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.sem.postslistapp.data.dataSource.PostsDataSource
import com.sem.postslistapp.data.models.PostsLocalModel

class PostsDataSourceIMPL : PostsDataSource {

    override fun insert(postsLocalModel: PostsLocalModel) {
        TODO("Not yet implemented")
    }

    override fun loadPosts(): LiveData<List<PostsLocalModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }


}