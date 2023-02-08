package ly.umbrella.roomapplications

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.umbrella.roomapplications.core.Recourc
 import ly.umbrella.roomapplications.data.entity.UserEntity
import ly.umbrella.roomapplications.data.repository.LocalUserRepositoryImps

class UserViewModel() : ViewModel() {
   private val userrepository = LocalUserRepositoryImps()
    private var currnetState = Recourc.Inti<List<UserEntity>>()
    val state = MutableLiveData<Recourc<List<UserEntity>>>(currnetState)

    fun getUsers() {
        viewModelScope.launch {
            userrepository.getallUSer().onEach {
                state.value = it
            }.launchIn(viewModelScope)
        }

    }

    fun insertUser() {
        viewModelScope.launch {
            userrepository.insertUser(
                UserEntity(
                    id = 0,
                    name = "Ahhemed new ",
                    phonNumber = "256555555"
                )
            )
        }

    }
}