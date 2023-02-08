package ly.umbrella.roomapplications.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ly.umbrella.roomapplications.ClickItem
import ly.umbrella.roomapplications.R
import ly.umbrella.roomapplications.data.entity.UserEntity

class UserAdapter(var userLisr: List<UserEntity>) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {
    var clickListItem: ClickItem? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserHolder {
        var currentItem =
            LayoutInflater.from(parent.context).inflate(R.layout.useritem, parent, false)
        return UserHolder(currentItem)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserHolder, position: Int) {
        holder.txtName.text = userLisr[position].name
        holder.txtPhonNumber.text = userLisr[position].phonNumber
        holder.itemView.setOnClickListener {
            clickListItem!!.onUserClickItem(userLisr[position])
        }
    }

    override fun getItemCount(): Int {
        return userLisr.size
    }
    fun  fillUserList(newList:List<UserEntity>){

    }
    class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtName: TextView = view.findViewById(R.id.txtname)
        var txtPhonNumber: TextView = view.findViewById(R.id.txtphonenumber)
    }
}