package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.CommentsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.ResourcesAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.NavActivity
import java.text.SimpleDateFormat

class AssignmentView : AppCompatActivity() {
    lateinit var binding: ActivityAssignmentViewBinding
    private lateinit var resourcesAdapter: ResourcesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topic = intent.getStringArrayExtra("selectedAssignmentTopic") ?: emptyArray()
        val competency = intent.getStringExtra("selectedAssignmentCompetency") ?: ""
        val task = intent.getStringExtra("selectedAssignmentTask") ?: ""
        val resources = intent.getStringArrayExtra("selectedAssignmentResources") ?: emptyArray()
        val subject = intent.getIntExtra("selectedAssignmentSubject", 0)
        val category = intent.getIntExtra("selectedAssignmentCategory", 0)
        val due_date = intent.getStringExtra("selectedAssignmentDueDate") ?: ""

        populateAssignmentDetails(
            topic,
            competency,
            task,
            resources,
            subject,
            category,
            due_date
        )

//        binding.rvresources.setOnClickListener {
//            val intent = Intent(this@AssignmentView, Shops::class.java)
//            startActivity(intent)
//        }

        binding.rvresources.setOnClickListener {
            val intent = Intent(this@AssignmentView, ShopsActivity::class.java)
            startActivity(intent)
        }


        val recyclerView: RecyclerView = binding.rvresources
        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        binding.rvresources.layoutManager = layoutManager

        val resourcesList = resources.map { Resources(it) }

        resourcesAdapter = ResourcesAdapter(resourcesList) { selectedResource ->
            val intent = Intent(this@AssignmentView, ShopsActivity::class.java)
            intent.putExtra("Name", selectedResource.name)
            startActivity(intent)
        }



//        val recyclerView: RecyclerView = binding.rvresources
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

//        binding.ivarrowfoward.setOnClickListener {
//            scrollRecyclerView(true)
//        }
//        binding.ivarrowback.setOnClickListener {
//            scrollRecyclerView(false)
//        }
        binding.tvMessage.setOnClickListener {
            startActivity(Intent(this, CommentsActivity::class.java))
        }


        recyclerView.adapter = resourcesAdapter


    }


    override fun onResume() {
        super.onResume()
        binding.ivarrow2.setOnClickListener {
            startActivity(Intent(this, SubjectChoosenAssignments::class.java))
        }
        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
        binding.rvresources.setOnClickListener {
            startActivity(Intent(this, ShopsActivity::class.java))
        }
    }

    private fun populateAssignmentDetails (
        topic: Array<String>,
        competency: String,
        task: String,
        resources: Array<String>,
        subject: Int,
        category: Int,
        due_date: String
    ) {

//        binding.tvAgric.text = topic.joinToString(", ")
//        binding.tvAgric.text = topic.toString()
        binding.tvPlantss.text = competency
        binding.tvTask.text = task
        val inputFormat = SimpleDateFormat("yyyy-MM-dd") // Assuming the input format is yyyy-MM-dd
        val outputFormat = SimpleDateFormat("dd/MM/yyyy") // Desired output format: dd/MM/yyyy
        val formattedDate = outputFormat.format(inputFormat.parse(due_date))
        binding.tv30th.text = formattedDate

        binding.rvresources.layoutManager = LinearLayoutManager(this)

        val resourcesList = resources.map { Resources(it) }

        resourcesAdapter = ResourcesAdapter(resourcesList) { selectedResource ->
            val intent = Intent(this@AssignmentView, ShopsActivity::class.java)
            intent.putExtra("Name", selectedResource.name)
            startActivity(intent)
        }
        binding.rvresources.adapter = resourcesAdapter
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