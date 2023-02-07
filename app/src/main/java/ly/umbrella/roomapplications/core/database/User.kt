package ly.umbrella.roomapplications.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ly.umbrella.roomapplications.core.basemodols.BaseModel
import ly.umbrella.roomapplications.data.entity.UserEntity

@Entity(tableName = "usertb")
data class UserDbModel(
    @PrimaryKey @ColumnInfo(name= "id")  val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "phone_number")  val phonNumber:String,
    @ColumnInfo(name = "city")  val city:String,
    @ColumnInfo(name = "bbb")  val bbb:String? =""

):BaseModel<UserDbModel,UserEntity>(){
    override fun converToEntity(): UserEntity {
       return UserEntity(id=this.id,name=this.name,phonNumber=this.phonNumber)
    }

}

