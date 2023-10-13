package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignDetails2Binding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.ResourcesAdapter
//import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.Shops

class AssignDetails2Activity : AppCompatActivity() {
    lateinit var binding:ActivityAssignDetails2Binding
    private lateinit var resourcesAdapter: ResourcesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignDetails2Binding.inflate(layoutInflater)
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
//        binding.rvresources.setOnClickListener {
//            val intent = Intent(this@AssignDetails2Activity, Shops::class.java)
//            startActivity(intent)
//        }

        val recyclerView: RecyclerView = binding.rvresources
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val resources1 = listOf(
            Resources("Panga"),
            Resources("Dustcoat"),
            Resources("Rabbit"),
            Resources("Seedlings"),
            Resources("Gumboots"),
            Resources("Jembe"),
            Resources("Basket"),
            Resources("Trees")
        )

        resourcesAdapter = ResourcesAdapter(resources1) { selectedResource ->
//            val intent = Intent(this@AssignDetails2Activity, ShopsActivity::class.java)
            intent.putExtra("Name", selectedResource.name)
            startActivity(intent)
        }

        binding.ivarrowfoward.setOnClickListener {
            scrollRecyclerView(true)
        }
        binding.ivarrowback.setOnClickListener {
            scrollRecyclerView(false)
        }

        binding.ivsend.setOnClickListener {
            startActivity(Intent(this, CommentsActivity::class.java))
        }

        recyclerView.adapter = resourcesAdapter
    }
    override fun onResume() {
        super.onResume()
        binding.ivarrow2.setOnClickListener {
            startActivity(Intent(this, SubjectAssignmentActivity::class.java))
        }
        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
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
//        binding.tvresources.text = resources.joinToString(", ")
        binding.tvPlantss.text = competency
//        binding.tvcategory.text = category.toString()
        binding.tvtask .text = task
        binding.tv30th.text = due_date
    }

    private fun scrollRecyclerView(forward: Boolean) {
        val layoutManager = binding.rvresources.layoutManager as LinearLayoutManager

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        val scrollAmount = if (forward) visibleItemCount else -visibleItemCount
        val targetPosition = firstVisibleItemPosition + scrollAmount

        if (targetPosition >= 0 && targetPosition < totalItemCount) {
            binding.rvresources.smoothScrollToPosition(targetPosition)
        }
    }

}