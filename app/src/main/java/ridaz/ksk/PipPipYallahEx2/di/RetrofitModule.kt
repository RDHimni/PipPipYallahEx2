package ridaz.ksk.PipPipYallahEx2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ridaz.ksk.PipPipYallahEx2.network.ApiService
import javax.inject.Singleton

/**
 * Rida Dhimni
 * 27/06/2021
 **/

@Module
@InstallIn(SingletonComponent::class)
class retrofitModule {

    companion object{
        val baseUrl = "https://randomuser.me/"

        @Provides
        @Singleton
        fun ApiServiceProvider() =  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

}