package ly.umbrella.roomapplications.data.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import ly.umbrella.roomapplications.core.database.UserDbModel
import java.io.Serializable

data class UserEntity (
      val id:Int,
     val name:String,
     val phonNumber:String
){
    fun convertToModelDb():UserDbModel{
        return UserDbModel(name = this.name, id = this.id, phonNumber = this.phonNumber, bbb = "", city = "")
    }
}