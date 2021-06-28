package ridaz.ksk.PipPipYallahEx2.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ridaz.ksk.PipPipYallahEx2.models.results

/**
 * Rida Dhimni
 * 27/06/2021
 **/

interface ApiService {

    @GET("api/?")
    fun getUsers(@Query("nat") nl : String, @Query("results") result: Int): Call<results>

}