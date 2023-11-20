package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityEditAssignmentBinding
import java.util.Calendar
import java.util.Locale
import android.widget.Toast
import androidx.activity.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.model.ShopData
import sakigake.mzaziconnect.mzaziconnectapplication.model.SubjectData
import sakigake.mzaziconnect.mzaziconnectapplication.repository.AssignmentRepo
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.ShopViewModel
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EditAssignmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditAssignmentBinding
    private lateinit var editTextDate: EditText
    private val calendar = Calendar.getInstance()
    lateinit var postrepo: AssignmentRepo
    private lateinit var subjectSpinner: Spinner
    private lateinit var shopSpinner:Spinner
    val subjectViewModel: SubjectViewModel by viewModels()
    val shopViewModel: ShopViewModel by viewModels()
    private lateinit var adapter: ArrayAdapter<SubjectData>
    private lateinit var shopAdapter:ArrayAdapter<ShopData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subjectSpinner = binding.spinnerSubject
        shopSpinner = binding.spinnercategories
        postrepo=AssignmentRepo()
    }

    override fun onResume() {
        super.onResume()
        clearErrors()

        binding.btnPostAssignment.setOnClickListener {
            postAsignment()
        }

        binding.ivcancel.setOnClickListener {
            val intent = Intent(this, SubjectAssignmentActivity::class.java)
            startActivity(intent)
        }
        getCustomSubjectsData()
        getCustomShopData()

    }




    private fun getCustomSubjectsData() {
        subjectViewModel.subjectsLiveData.observe(this) { subjectsList ->
            adapter = SubjectAdapter(this, subjectsList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            subjectSpinner.adapter = adapter

            subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                    val selectedObject = subjectSpinner.selectedItem as SubjectData


//                    Toast.makeText (
//                        this@EditAssignmentActivity,
//                        "ID: ${selectedObject.id} Name: ${selectedObject.subject_name}",
//                        Toast.LENGTH_SHORT
//                    ).show()

                }


            }

        }
    }


    private fun getCustomShopData(){
        shopViewModel.shopLiveData.observe(this){shopList ->
            shopAdapter=ShopAdapter(this, shopList)
            shopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            shopSpinner.adapter = shopAdapter

            shopSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val selectedObject = shopSpinner.selectedItem as ShopData
//                    Toast.makeText(
//                        this@EditAssignmentActivity,
//                        "ID: ${selectedObject.id} Name: ${selectedObject.category}",
//                        Toast.LENGTH_SHORT
//                    ).show()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }

        }

    }

    fun formatDate():String{
        val now= LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[:ss[.uuuuuu]][XXX]")
        return formatter.format(now)
    }


fun postAsignment() {
    if (!validateEditAssignment()) {
        return  // Return early if the validation fails
    }

    val dueDate = formatDate()
    val topic = binding.ettopic.text.toString()
    val task = binding.ettypemessage.text.toString()
    val resources = binding.etresources.text.toString()
    val compentecy = binding.etcompetency.text.toString()

    val selectedSubject = subjectSpinner.selectedItem as SubjectData
    val selectedShop = shopSpinner.selectedItem as ShopData

    val assignmentData = AssignmentsData(
        topic = topic,
        task = task,
        category = selectedShop.id,
        competency = compentecy,
        due_date = dueDate,
        resources = arrayOf(resources),
        subject = selectedSubject.id
    )

    CoroutineScope(Dispatchers.IO).launch {
        postrepo.postAssignment(assignmentData)
        runOnUiThread {
            showToast()
            val intent = Intent(this@EditAssignmentActivity, SubjectAssignmentActivity::class.java)
            startActivity(intent)
        }
    }
}

    fun showToast() {
        Toast.makeText(applicationContext, "Assignment posted", Toast.LENGTH_SHORT).show()
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
        val compentency = binding.etcompetency.text.toString()

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
        if (compentency.isBlank()){
            binding.tilcomptenecy.error = "Competency is required"
            error = true
        }
        return !error
    }

    fun clearErrors() {
        binding.tilresources.error = null
        binding.tiltopic.error = null
        binding.tiltypemessage.error = null
        binding.tilcomptenecy.error = null
    }
}