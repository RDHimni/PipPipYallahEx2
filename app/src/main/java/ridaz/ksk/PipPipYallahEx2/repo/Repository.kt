package ridaz.ksk.PipPipYallahEx2.repo

import ridaz.ksk.PipPipYallahEx2.network.ApiService
import javax.inject.Inject

/**
 * Rida Dhimni
 * 27/06/2021
 **/

class Repository @Inject constructor(var apiService: ApiService) {
    fun getUserFromApi(nl: String, result: Int) = apiService.getUsers(nl, result)
}