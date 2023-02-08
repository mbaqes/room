package ly.umbrella.roomapplications

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.umbrella.roomapplications.adapter.UserAdapter
import ly.umbrella.roomapplications.core.Recourc
import ly.umbrella.roomapplications.core.database.UserDb
import ly.umbrella.roomapplications.core.database.UserDbModel
import ly.umbrella.roomapplications.data.entity.UserEntity
 import ly.umbrella.roomapplications.views.ProfileActivity

class MainActivity : AppCompatActivity(),ClickItem {
     private val vmUser:UserViewModel by viewModels()
     private lateinit var userAdapter :UserAdapter
     private lateinit var rvListUser:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         UserDb.initDb(this)
        initUi()
       val observer=Observer<Recourc<List<UserEntity>>>{
//           when(it){
//               is Recourc.Loading<List<UserEntity>>-> {
//                   // UI
//               }
//               is Recourc.Success<List<UserEntity>>-> {
//
//                   userAdapter.fillUserList(it.data!!)
//               }
//           }

       }
       vmUser.state.observe(this,observer)
        vmUser.insertUser()
        vmUser.getUsers()


    }

    override fun onUserClickItem(user: UserEntity) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("user",user)
    }
    fun initUi(){
        userAdapter = UserAdapter(ArrayList())
        userAdapter.clickListItem=this
        rvListUser.adapter=userAdapter
        rvListUser.layoutManager=LinearLayoutManager(this)

    }
    fun fillUserList(){

    }
}