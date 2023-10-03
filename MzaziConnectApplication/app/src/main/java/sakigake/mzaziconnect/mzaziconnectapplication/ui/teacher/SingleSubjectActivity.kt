package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySingleSubjectBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentData
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.AssignmentView

class SingleSubjectActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingleSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleSubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.rvAssignmentTopics)
        val assignments = listOf(
            AssignmentData(
                "Agriculture  - ",
                "Due: 10th Nov",
                "Plants",
                "No resources required",
                "Posted at 25/12/2023"
            ),
            AssignmentData(
                "English  - ",
                "Due: 10th Nov",
                "Adjectives",
                "No resources required",
                "Posted at 25/12/2023"
            ),
            AssignmentData(
                "Kiswahili  - ",
                "Due: 10th Nov",
                "Misamiati",
                "No resources required",
                "Posted at 25/12/2023"
            ),
            AssignmentData(
                "Science   - ",
                "Due: 10th Nov",
                "Digestive System",
                "No resources required",
                "Posted at 25/12/2023"
            )
        )
        val adapterAssign = AssignmentAdapter(assignments) { selectedassignment ->
            val intent = Intent(this@SingleSubjectActivity, AssignmentView::class.java)
            intent.putExtra("subjectName", selectedassignment.subjectName)
            intent.putExtra("topicName", selectedassignment.topicName)
            intent.putExtra("dueDate", selectedassignment.dueDate)
            intent.putExtra("updateAt", selectedassignment.updatedAt)
            startActivity(intent)
        }


        var rvassign= binding.rvAssignmentTopics
        rvassign.adapter=adapterAssign
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, SubjectActivity::class.java)
            startActivity(intent)
        }

        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
    }
}