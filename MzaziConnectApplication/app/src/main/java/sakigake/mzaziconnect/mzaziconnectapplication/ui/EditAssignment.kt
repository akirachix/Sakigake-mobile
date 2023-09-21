package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityEditAssignmentBinding

class EditAssignment : AppCompatActivity() {
      lateinit var binding: ActivityEditAssignmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnAssignement.setOnClickListener {
            val intent = Intent(this, PlantsActivity::class.java)
            startActivity(intent)
        }
    }
}
