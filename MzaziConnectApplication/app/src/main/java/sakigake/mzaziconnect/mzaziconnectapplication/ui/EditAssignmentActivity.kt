package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityEditAssignmentBinding
import java.util.Calendar
import java.util.Locale

class EditAssignmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditAssignmentBinding
    private lateinit var editTextDate: EditText
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editTextDate = binding.editTextDate
    }

    override fun onResume() {
        super.onResume()
        clearErrors()

        binding.btnPostAssignment.setOnClickListener {
            if (validateEditAssignment()) {

                val intent = Intent(this, Assign_detailsActivity::class.java)
                startActivity(intent)
            }
        }

        binding.ivcancel.setOnClickListener {
            val intent = Intent(this, SubjectAssignmentActivity::class.java)
            startActivity(intent)
        }
    }

    fun showDatePickerDialog(view: View) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                editTextDate.setText(
                    String.format(
                        Locale.getDefault(),
                        "%02d/%02d/%04d",
                        selectedDay,
                        selectedMonth + 1,
                        selectedYear
                    )
                )
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    fun validateEditAssignment(): Boolean {
        val topic = binding.ettopic.text.toString()
        val message = binding.ettypemessage.text.toString()
        val resources = binding.etresources.text.toString()
        val categories = binding.etcategories.text.toString()

        var error = false
        if (topic.isBlank()) {
            binding.tiltopic.error = "Topic is required"
            error = true
        }
        if (message.isBlank()) {
            binding.tiltypemessage.error = "Message is required"
            error = true
        }
        if (resources.isBlank()) {
            binding.tilresources.error = "Resources is required"
            error = true
        }
        if (categories.isBlank()) {
            binding.tilcategories.error = "Categories is required"
            error = true
        }

        return !error
    }

    fun clearErrors() {
        binding.tilcategories.error = null
        binding.tilresources.error = null
        binding.tiltopic.error = null
        binding.tiltypemessage.error = null
    }
}