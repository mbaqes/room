package ly.umbrella.roomapplications

import ly.umbrella.roomapplications.data.entity.UserEntity

interface ClickItem {
    fun onUserClickItem(user :UserEntity)
}