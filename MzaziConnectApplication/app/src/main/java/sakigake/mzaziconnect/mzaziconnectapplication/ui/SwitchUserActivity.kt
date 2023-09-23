package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySwitchUserBinding

class SwitchUserActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwitchUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySwitchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivbacksswitch.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, SubjectActivity::class.java)
            startActivity(intent)
        }
        binding.btnparent.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnteacher.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}