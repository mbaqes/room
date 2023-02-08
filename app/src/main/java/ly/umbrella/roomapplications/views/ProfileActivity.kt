package ly.umbrella.roomapplications.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.umbrella.roomapplications.R
import ly.umbrella.roomapplications.data.entity.UserEntity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        intent.getSerializableExtra("user") as UserEntity?
    }
}