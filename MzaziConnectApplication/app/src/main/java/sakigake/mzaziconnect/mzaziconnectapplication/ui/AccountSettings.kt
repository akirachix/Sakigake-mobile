package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAccountSettingsBinding

class AccountSettings : AppCompatActivity(){
    lateinit var binding: ActivityAccountSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding =ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.ivdotsset.setOnClickListener {
//            startActivity(Intent(this@AccountSettings, NavActivity::class.java))
//        }

        binding.ivbackset.setOnClickListener {
            startActivity(Intent(this@AccountSettings, ChildGrade::class.java))
        }
        binding.btnupdate.setOnClickListener {
            Toast.makeText(this@AccountSettings, "Settings successfully updated", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@AccountSettings, ChildGrade::class.java))

        }
    }
}