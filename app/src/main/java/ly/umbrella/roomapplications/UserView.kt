package ly.umbrella.roomapplications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.umbrella.roomapplications.core.Recourc
import ly.umbrella.roomapplications.data.entity.UserEntity
import ly.umbrella.roomapplications.data.repository.LocalUserRepositoryImp

class UserViewModel:ViewModel() {
   val userrepository = LocalUserRepositoryImp()
  private  var currnetState =Recourc.Inti<List<UserEntity>>()
    val state = MutableLiveData<Recourc<List<UserEntity>>>(currnetState)
 fun getUsers(){
   userrepository.getallUSer().onEach {
    state.value=it
   }.launchIn(viewModelScope)

 }

}