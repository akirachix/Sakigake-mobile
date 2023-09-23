package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAccountSettingsBinding

class AccountSettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivdotsset.setOnClickListener {
            startActivity(Intent(this@AccountSettingsActivity, NavActivity::class.java))
        }

        binding.ivbackset.setOnClickListener {
            startActivity(Intent(this@AccountSettingsActivity, SubjectActivity::class.java))
        }
        binding.btnupdate.setOnClickListener {
            startActivity(Intent(this@AccountSettingsActivity, AccountSettingsActivity::class.java))
        }
    }
}