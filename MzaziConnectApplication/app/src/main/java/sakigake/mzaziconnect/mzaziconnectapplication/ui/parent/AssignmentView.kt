package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityAssignmentViewBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.CommentsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.ResourcesAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.NavActivity

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
            Resources("Gumboots"),
            Resources("Jembe"),
            Resources("Basket"),
            Resources("Trees")
        )

        resourcesAdapter = ResourcesAdapter(resources) { selectedResource ->
            val intent = Intent(this@AssignmentView, Shops::class.java)
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
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            startActivity(intent)
        }
        binding.ivhome.setOnClickListener {
            val intent =Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
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