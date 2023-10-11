package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import AssignAdapter
import AssignmentViewModel
import TopicViewModel
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectAssignmentBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.TopicsAdapter

class SubjectAssignmentActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubjectAssignmentBinding
    val assignViewModel: AssignmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnadd.setOnClickListener {
            val intent = Intent(this, EditAssignmentActivity::class.java)
            startActivity(intent)
        }
        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        fetchingAssign()

    }
    fun fetchingAssign() {
        assignViewModel.fetchAssign()
        assignViewModel.postsLiveData.observe(
            this,
            Observer { assignmentList ->
//                val postsAdapter = AssignAdapter(assignmentList?: emptyList(), this)
                val sortedList = assignmentList.sortedByDescending { it.due_date }
                val postsAdapter = AssignAdapter(sortedList?: emptyList(), this)
                binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(this@SubjectAssignmentActivity)
                binding.rvAssignmentTopics.adapter=postsAdapter
            })

        assignViewModel.errorLiveData.observe(this, Observer{ error ->
            Toast.makeText( baseContext, error, Toast.LENGTH_LONG).show()
        })

    }

}