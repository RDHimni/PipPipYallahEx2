package ridaz.ksk.PipPipYallahEx2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import ridaz.ksk.PipPipYallahEx2.adapter.CustomAdapter
import ridaz.ksk.PipPipYallahEx2.viewmodel.MyViewModel

/**
 * Rida Dhimni
 * 27/06/2021
 **/


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var myViewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        getUsers()

    }


    fun getUsers() {
        progressBarCercle.visibility = View.VISIBLE
        myViewModel!!.getUserFromRepo("nl", 10)
        myViewModel!!.get_usersMutableLiveData().observe(this, Observer {
            recyclerView.adapter = CustomAdapter(it.results)
            progressBarCercle.visibility = View.GONE
        })

    }
}


