package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.Shops

class AssignmentView : AppCompatActivity() {
    lateinit var  binding: ActivityAssignmentViewBinding
    lateinit var resourcesAdapter: ResourcesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.rvresources.setOnClickListener {
//            val intent = Intent(this@AssignmentView, Shops::class.java)
//            startActivity(intent)
//        }

        val recyclerView: RecyclerView = binding.rvresources
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val resources = listOf(
            Resources("Panga"),
            Resources("Dustcoat"),
            Resources("Rabbit"),
            Resources("Seedlings"),
            Resources("Gumboots")
        )

        resourcesAdapter = ResourcesAdapter(resources) { selectedResource ->
            val intent = Intent(this@AssignmentView, Shops::class.java)
            intent.putExtra("Name", selectedResource.name)
            startActivity(intent)
        }
//        resourcesAdapter.onItemClick = { selectedResource ->
//            val intent = Intent(this@AssignmentView, Shops::class.java)
//            intent.putExtra("Name", selectedResource.name)
//            startActivity(intent)
//        }
//        recyclerView.adapter = resourcesAdapter

//        resourcesAdapter = ResourcesAdapter(resources) { selectedResource ->
//            val intent = Intent(this@AssignmentView, Shops::class.java)
//            intent.putExtra("Name", selectedResource.name)
//            startActivity(intent)
//        }
        recyclerView.adapter = resourcesAdapter
    }
    override fun onResume() {
        super.onResume()
        binding.ivarrow2.setOnClickListener {
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            startActivity(intent)
        }


    }
}