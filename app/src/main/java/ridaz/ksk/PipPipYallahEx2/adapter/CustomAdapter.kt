package ridaz.ksk.PipPipYallahEx2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ridaz.ksk.PipPipYallahEx2.R
import ridaz.ksk.PipPipYallahEx2.models.Result

/**
 * Rida Dhimni
 * 27/06/2021
 **/


class CustomAdapter(private var dataSet: ArrayList<Result>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    ////////////////////////////////////////////////////////////////////////////////////
    /////////////******************class MyViewHolder()***********************//////////////
    ////////////////////////////////////////////////////////////////////////////////////

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val FirstNameTv: TextView
        val EmailTv: TextView
        val NumberPhoneTv: TextView
        val AvatarMv : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            FirstNameTv = itemView.findViewById(R.id.FirstNameTv)
            EmailTv = itemView.findViewById(R.id.EmailTv)
            NumberPhoneTv = itemView.findViewById(R.id.NumberPhoneTv)
            AvatarMv = itemView.findViewById(R.id.avatarIMv)
        }


    }


    ////////////////////////////////////////////////////////////////////////////////////
    /////////////******************onCreateViewHolder***********************//////////////
    ////////////////////////////////////////////////////////////////////////////////////

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_item, viewGroup, false)

        return ViewHolder(view)
    }




    ////////////////////////////////////////////////////////////////////////////////////
    /////////////******************onBindViewHolder()***********************//////////////
    ////////////////////////////////////////////////////////////////////////////////////

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.FirstNameTv.text = dataSet[position].name.first
        viewHolder.EmailTv.text = dataSet[position].email
        viewHolder.NumberPhoneTv.text = dataSet.get(position).phone
        Glide.with(viewHolder.itemView)
            .load(dataSet.get(position).picture.medium)
            .into(viewHolder.AvatarMv)
    }



    ////////////////////////////////////////////////////////////////////////////////////
    /////////////******************onBindViewHolder()***********************//////////////
    ////////////////////////////////////////////////////////////////////////////////////
    override fun getItemCount() = dataSet.size

}
