package sakigake.mzaziconnect.mzaziconnectapplication.ui

import SubjectAssignmentsAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.database.AssignmentDataClass
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectAssignmentsActitvityBinding

class SubjectAssignmentsActitvity : AppCompatActivity() {
    lateinit var  binding: ActivitySubjectAssignmentsActitvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectAssignmentsActitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.rvAssignmentTopics)
        val assignments = listOf(
            AssignmentDataClass("Agriculture  - ", "25/12/2023", "Plants", "No resources required", "Posted at 25/12/2023"),
            AssignmentDataClass("English  - ", "25/12/2023", "Adjectives", "No resources required", "Posted at 25/12/2023"),
            AssignmentDataClass("Kiswahili  - ", "25/12/2023", "Misamiati", "No resources required", "Posted at 25/12/2023"),
            AssignmentDataClass("Science   - ", "25/12/2023", "Digestive System", "No resources required", "Posted at 25/12/2023")

        )
        val adapter = SubjectAssignmentsAdapter(assignments) { selectedassignment ->
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            intent.putExtra("", selectedassignment.subjectName)
            intent.putExtra("", selectedassignment.topicName)
            intent.putExtra("", selectedassignment.dueDate)
            intent.putExtra("", selectedassignment.updatedAt)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, ChildGrade::class.java)
            startActivity(intent)
        }
    }
}