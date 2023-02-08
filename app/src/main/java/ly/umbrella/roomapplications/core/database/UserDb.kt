package ly.umbrella.roomapplications.core.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [UserDbModel::class],
    version = 1,
    )
abstract class UserDb:RoomDatabase() {
    abstract fun getuserDao(): UserDao
    companion object{
        @Volatile
        private var database:UserDb? =null

        fun initDb(context: Context?):UserDb{
            if(database==null){
                synchronized(this){
                    database = Room.databaseBuilder(
                        context!!,
                        UserDb::class.java,
                        name = "campdb"
                    ).build()
                    return database!!
                }

            }
          return database!!
        }

    }
}

