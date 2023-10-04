package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding

class TeachersAssignmentView : AppCompatActivity() {
    lateinit var binding: ActivityAssignmentViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
//        binding.ivarrow2.setOnClickListener {
//            val intent = Intent(this, ::class.java)
//            startActivity(intent)
//        }
        binding.ivhome.setOnClickListener {
            val intent =Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
    }



}



//package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
//import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding
//import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
//import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.CommentsActivity
//import sakigake.mzaziconnect.mzaziconnectapplication.ui.ResourcesAdapter
//import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.NavActivity
//
//class AssignmentView : AppCompatActivity() {
//    lateinit var  binding: ActivityAssignmentViewBinding
//    private lateinit var resourcesAdapter: ResourcesAdapter
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityAssignmentViewBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val assignmentId = intent.getStringExtra("selected")
//        val topic = intent.getStringExtra("Assignment_topic")
//        val competency = intent.getStringExtra("Assignment_competency")
//        val task = intent.getStringExtra("Assignment_task")
//        val materials = intent.getStringExtra("Assignment_resources")
//        val subject = intent.getStringExtra("Assignment_subject")
//        val category = intent.getStringExtra("Assignment_category")
//        val due_date = intent.getStringExtra("Assignment_due_date")

//        populateAssignmentDetails(
//            assignmentId = 0, topic= arrayOf(),competency,task,  materials, subject = 0 , category = 0, due_date = ""
//        )
//
//        binding.rvresources.setOnClickListener {
//            val intent = Intent(this@AssignmentView, Shops::class.java)
//            startActivity(intent)
//        }
//
//        val bundle: Bundle? = intent.extras
//        val selectedAssignmentId = bundle?.getString("selectedAssignmentId")
//        val recyclerView: RecyclerView = binding.rvresources
//
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        val resources = listOf(
//            Resources("Panga"),
//            Resources("Dustcoat"),
//            Resources("Rabbit"),
//            Resources("Seedlings"),
//            Resources("Gumboots"),
//            Resources("Jembe"),
//            Resources("Basket"),
//            Resources("Trees")
//        )
//
//        resourcesAdapter = ResourcesAdapter(resources) { selectedResource ->
//            val intent = Intent(this@AssignmentView, ShopsActivity::class.java)
//            intent.putExtra("Name", selectedResource.name)
//            startActivity(intent)
//        }
//
//

//

//    private fun scrollRecyclerView(forward: Boolean) {
//        val layoutManager = binding.rvresources.layoutManager as LinearLayoutManager
//
//        val visibleItemCount = layoutManager.childCount
//        val totalItemCount = layoutManager.itemCount
//        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
//
//        val scrollAmount = if (forward) visibleItemCount else -visibleItemCount
//        val targetPosition = firstVisibleItemPosition + scrollAmount
//
//        if (targetPosition in 0 until totalItemCount) {
//            binding.rvresources.smoothScrollToPosition(targetPosition)
//        }
//    }
//
//    private fun populateAssignmentDetails(
//        assignmentId:Int,
//        topic:Array<String>,
//        competency:String?,
//        task:String?,
//        resources: String?,
//        subject:Int,
//        category: Int,
//        due_date:String
//
//    ){
//        binding.tvtopic.text = topic.joinToString(", ")
//        binding.tvresources.text = resources
//        binding.tvcompentency.text = competency ?: ""
//        binding.tvcategory.text = category.toString()
//        binding.tvtask.text= task
//        binding.tvsubject.text = subject.toString()
//        binding.tvduedate.text= due_date
//
//    }
//}