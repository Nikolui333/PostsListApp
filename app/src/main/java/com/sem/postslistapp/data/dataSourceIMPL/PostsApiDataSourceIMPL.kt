package com.sem.postslistapp.data.dataSourceIMPL

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sem.postslistapp.data.dataSource.PostsApiDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.sem.postslistapp.data.api.ApiClient
import com.sem.postslistapp.data.dataSource.PostsDataSource
import com.sem.postslistapp.data.models.PostsApiModel
import com.sem.postslistapp.data.models.PostsApiModelItem
import com.sem.postslistapp.data.models.PostsLocalModel

class PostsApiDataSourceIMPL(private val dataSource: PostsDataSource) : PostsApiDataSource {

    override fun startMigration(context: Context) {

        val call = ApiClient.instance?.api?.loadPostsApi()
        call?.enqueue(object: Callback<PostsApiModel>
        {
            override fun onResponse(
                call: Call<PostsApiModel>,
                response: Response<PostsApiModel>
            ) {

                Log.d("ApiDataSource", "onResponse status: ${response.code()}")

                var loadNameList: ArrayList<PostsApiModelItem>? = null

                loadNameList?.clear()

                loadNameList = response.body() as PostsApiModel

                for (audit in loadNameList!!) {

                    audit.id?.let {
                        PostsLocalModel(
                            it,

                            audit.title,
                            audit.body,
                            audit.userId

                            )
                    }?.let {
                        dataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<PostsApiModel>
                                   , t: Throwable) {
                t.printStackTrace()
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
                Log.e("ApiDataSource2", "onFailure", t)
            }
        })
    }


}