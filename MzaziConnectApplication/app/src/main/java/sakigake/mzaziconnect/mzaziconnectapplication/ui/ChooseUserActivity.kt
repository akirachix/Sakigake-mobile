package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityChooseUserBinding

class ChooseUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityChooseUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onResume()



    }

    override fun onResume() {
        super.onResume()

        binding.btnparent.setOnClickListener {
            val intent = Intent(this@ChooseUserActivity, LoginActivity::class.java)
            intent.putExtra("userType", "parent")
            startActivity(intent)
        }

        binding.btnteacher.setOnClickListener {
            val intent = Intent(this@ChooseUserActivity, LoginActivity::class.java)
            intent.putExtra("userType", "teacher")
            startActivity(intent)
        }

    }
}