package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import TopicViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectChoosenAssignmentsBinding

class SubjectChoosenAssignments : AppCompatActivity() {
    lateinit var binding: ActivitySubjectChoosenAssignmentsBinding
    private val assignViewModel: TopicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectChoosenAssignmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val recyclerView = binding.rvAssignmentTopics

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, ParentsNavActivity::class.java)
            startActivity(intent)
        }
        binding.imgHome.setOnClickListener {
            startActivity(Intent(this@SubjectChoosenAssignments, ChildGrade::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        assignViewModel.fetchAssign()

        assignViewModel.errorLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        })
        assignViewModel.assignLiveData.observe(this, Observer { topicsList ->
            val sortedList = topicsList.sortedByDescending { it.due_date }
            binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(this, )
            binding.rvAssignmentTopics.adapter = SubjectChoosenAssignmentsAdapter(sortedList, this)

        })
    }
}