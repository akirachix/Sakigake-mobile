package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityViewChildBinding

class ViewChild : AppCompatActivity() {
    lateinit var binding: ActivityViewChildBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewChildBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChildName.setOnClickListener {
            val intent = Intent(this, ChildGrade::class.java)
            startActivity(intent)
        }
        binding.btnChildName1.setOnClickListener {
            val intent = Intent(this, ChildGrade::class.java)
            startActivity(intent)
        }
        binding.imgMore.setOnClickListener{
            startActivity(Intent(this@ViewChild, AccountSettings::class.java))
        }
    }
}