package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignDetailsBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Resource

class Assign_detailsActivity : AppCompatActivity() {
    lateinit var  binding: ActivityAssignDetailsBinding
    lateinit var resourcesAdapter:ResourceAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val recyclerView: RecyclerView = binding.rvresources
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val resources = listOf(
            Resource("Panga"),
            Resource("Dustcoat"),
            Resource("Rabbit"),
            Resource("Seedlings"),
            Resource("Gumboots")
        )
        resourcesAdapter = ResourceAdapter(resources) { selectedResource ->
            val intent = Intent(this, ActivityAssignDetailsBinding::class.java)
            intent.putExtra("Name", selectedResource.name)
            startActivity(intent)
        }
        recyclerView.adapter = resourcesAdapter
    }
    override fun onResume() {
        super.onResume()
        binding.ivback.setOnClickListener {
            val intent = Intent(this, SubjectAssignmentActivity::class.java)
            startActivity(intent)
        }
        binding.ivsend.setOnClickListener {
            startActivity(Intent(this,CommentsActivity::class.java))
        }


    }
}