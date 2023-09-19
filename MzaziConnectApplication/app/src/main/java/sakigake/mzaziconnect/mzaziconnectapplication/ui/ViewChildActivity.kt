package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityViewChildBinding


class ViewChildActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewChildBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityViewChildBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.btnChildName.setOnClickListener {
            val intent = Intent(this, ChildGradeActivity::class.java)
            startActivity(intent)
        }
    }
}