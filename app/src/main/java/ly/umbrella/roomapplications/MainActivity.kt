package ly.umbrella.roomapplications

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         UserDb.initDb(this)
        GlobalScope.launch {

              var reposity = LocalUserRepositoryImp()
            reposity.insertUser(UserEntity(name = "Mailk", id = 0, phonNumber = "525555"))
            reposity.getallUSer().onEach {
             when(it){
                 is Recourc.Success<List<UserEntity>> -> {
                     Log.d("ff",it.data!!.first().name)
                 }
                 else ->{

                 }
             }
            }.launchIn(this)

        }

    }
}