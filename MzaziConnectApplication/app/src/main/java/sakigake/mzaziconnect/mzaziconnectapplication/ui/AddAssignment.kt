package sakigake.mzaziconnect.mzaziconnectapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.AddAssignmentBinding

class AddAssignment : AppCompatActivity() {
    lateinit var binding :AddAssignmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AddAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
