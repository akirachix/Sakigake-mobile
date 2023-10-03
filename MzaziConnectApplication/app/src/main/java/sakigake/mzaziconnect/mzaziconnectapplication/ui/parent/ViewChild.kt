package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityViewChildBinding

class ViewChild : AppCompatActivity() {
    lateinit var binding: ActivityViewChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewChildBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userPhoneNumber = intent.getStringExtra("userPhoneNumber")

        binding.btnChildName.setOnClickListener {
            val intent = Intent(this, ChildGrade::class.java)
            startActivity(intent)
        }
    }
}

