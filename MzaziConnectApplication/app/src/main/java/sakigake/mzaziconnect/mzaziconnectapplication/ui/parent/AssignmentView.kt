package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.CommentsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.ResourcesAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.NavActivity

class AssignmentView : AppCompatActivity() {
    lateinit var binding: ActivityAssignmentViewBinding
    private lateinit var resourcesAdapter: ResourcesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val assignmentId = intent.getIntExtra("selectedAssignmentId", 0)
        val topic = intent.getStringArrayExtra("selectedAssignmentTopic") ?: emptyArray()
        val competency = intent.getStringExtra("selectedAssignmentCompetency") ?: ""
        val task = intent.getStringExtra("selectedAssignmentTask") ?: ""
        val resources = intent.getStringArrayExtra("selectedAssignmentResources") ?: emptyArray()
        val subject = intent.getIntExtra("selectedAssignmentSubject", 0)
        val category = intent.getIntExtra("selectedAssignmentCategory", 0)
        val due_date = intent.getStringExtra("selectedAssignmentDueDate") ?: ""



        populateAssignmentDetails(
//            assignmentId,
            topic,
            competency,
            task,
            resources,
            subject,
            category,
            due_date

        )

    }


    override fun onResume() {
        super.onResume()
        binding.ivarrow2.setOnClickListener {
            startActivity(Intent(this, SubjectChoosenAssignments::class.java))
        }
        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
        binding.tvresources.setOnClickListener {
            startActivity(Intent(this, ShopsActivity::class.java))
        }
    }

    private fun populateAssignmentDetails(
//        assignmentId: Int,
        topic: Array<String>,
        competency: String,
        task: String,
        resources: Array<String>,
        subject: Int,
        category: Int,
        due_date: String
    ) {
        binding.tvAgric.text = topic.joinToString(", ")
        binding.tvresources.text = resources.joinToString(", ")
        binding.tvPlantss.text = competency
//        binding.tvcategory.text = category.toString()
        binding.tvtask .text = task
        binding.tv30th.text = due_date
    }

}