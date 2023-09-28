package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectAssignmentBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.TopicsAdapter

class SubjectAssignmentActivity : AppCompatActivity() {
    lateinit var binding:ActivitySubjectAssignmentBinding
    private lateinit var myDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDialog = Dialog(this)

        binding.btnadd.setOnClickListener {
            val intent = Intent(this, EditAssignmentActivity::class.java)
            startActivity(intent)
        }


    val topics = listOf(
        TopicsData("Plants - ", "Due: 10th Nov", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023"),
        TopicsData("Animals - ", "Due: 10th Nov", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023"),
        TopicsData("Farm Tools - ", "Due: 10th Nov", "In this assignment, you will explore the world of plants and learn about their basic needs for growth", "Posted at 25/12/2023"),
        TopicsData("Weeds - ", "Due: 10th Nov", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023")
    )

        val TopicsAdapter = TopicsAdapter(topics) { selectedTopic ->
            val intent = Intent(this, AssignDetails2Activity::class.java)
            intent.putExtra("TopicName", selectedTopic.topicName)
            intent.putExtra("AssignmentDetails", selectedTopic.topicName)
            intent.putExtra("DueDate", selectedTopic.dueDate)
            intent.putExtra("postedAt", selectedTopic.postedAt)
            startActivity(intent)
        }

        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }

        val recyclerView = binding.rvAssignmentTopics
        recyclerView.adapter=TopicsAdapter

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
        binding.ivhome.setOnClickListener {
            val intent = Intent(this, NavActivity::class.java)
            startActivity(intent)
        }
    }

}