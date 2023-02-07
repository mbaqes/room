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
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.umbrella.roomapplications.core.Recourc
import ly.umbrella.roomapplications.core.database.UserDb
import ly.umbrella.roomapplications.core.database.UserDbModel
import ly.umbrella.roomapplications.data.entity.UserEntity
import ly.umbrella.roomapplications.data.repository.LocalUserRepositoryImp

class MainActivity : AppCompatActivity() {
     private val vmUser:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         UserDb.initDb(this)
       val observer=Observer<Recourc<List<UserEntity>>>{
           when(it){
               is Recourc.Success<List<UserEntity>>-> {
                   Log.d("state" ,it.data!!.first().toString())
               }
           }

       }
       vmUser.state.observe(this,observer)
        vmUser.getUsers()

    }
}