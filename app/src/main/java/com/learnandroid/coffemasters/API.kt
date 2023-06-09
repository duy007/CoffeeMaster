package com.learnandroid.coffemasters

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// kotlin coroputine, async programming, and threading
interface CoffeeMastersApiService {
    @GET("menu.json")
    suspend fun fetchMenu(): List<Category>
}

object API {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://firtman.github.io/coffeemasters/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val menuService: CoffeeMastersApiService by lazy {
        retrofit.create(CoffeeMastersApiService::class.java)
    }
}