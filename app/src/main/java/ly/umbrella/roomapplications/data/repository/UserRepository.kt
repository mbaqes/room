package ly.umbrella.roomapplications.data.repository

import kotlinx.coroutines.flow.Flow
import ly.umbrella.roomapplications.core.Recourc
import ly.umbrella.roomapplications.data.entity.UserEntity

interface LocalUserRepository {
    fun getallUSer(): Flow<Recourc<List<UserEntity>>>
   fun insertUser(user:UserEntity)

}