package com.sem.postslistapp.data.api

import com.sem.postslistapp.data.models.PostsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun loadPostsApi(): Call<PostsApiModel>

}