package ridaz.ksk.PipPipYallahEx2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ridaz.ksk.PipPipYallahEx2.models.results
import ridaz.ksk.PipPipYallahEx2.repo.Repository
import javax.inject.Inject

/**
 * Rida Dhimni
 * 27/06/2021
 **/

@HiltViewModel
class MyViewModel @Inject constructor(var rep : Repository) : ViewModel() {
    private val TAG = "MyViewModel"

    var usersMutableLiveData = MutableLiveData<results>()


    fun get_usersMutableLiveData() =  usersMutableLiveData

    fun getUserFromRepo(nl: String, result: Int){
        rep.getUserFromApi(nl, result)
            .enqueue(object : Callback<results>{
                override fun onResponse(call: Call<results>, response: Response<results>) {
                    usersMutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<results>, t: Throwable) {
                    Log.d(TAG, "onFailure: "+t.message)
                }
            })
    }


}