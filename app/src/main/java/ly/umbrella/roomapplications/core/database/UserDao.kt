package ly.umbrella.roomapplications.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM usertb")
    fun getallUser():List<UserDbModel>
    @Insert(onConflict = 1)
    fun inserUser(vararg user: UserDbModel)
    @Delete
    fun deleteUser(user: UserDbModel)


}