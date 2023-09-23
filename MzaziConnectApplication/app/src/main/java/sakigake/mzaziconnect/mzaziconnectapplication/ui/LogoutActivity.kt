package sakigake.mzaziconnect.mzaziconnectapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityLogoutBinding

class LogoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}