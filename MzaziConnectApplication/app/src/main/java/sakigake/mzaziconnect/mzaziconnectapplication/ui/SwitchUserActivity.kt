package sakigake.mzaziconnect.mzaziconnectapplication.ui

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
    }
}