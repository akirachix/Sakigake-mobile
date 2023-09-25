package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.adservices.topics.Topic
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectAssignmentBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

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
            val intent = Intent(this, SubjectAssignmentActivity::class.java)
            intent.putExtra("TopicName", selectedTopic.topicName)
            intent.putExtra("AssignmentDetails", selectedTopic.topicName)
            intent.putExtra("DueDate", selectedTopic.dueDate)
            intent.putExtra("postedAt", selectedTopic.postedAt)
            startActivity(intent)
        }

        val recyclerView = binding.rvAssignmentTopics
        recyclerView.adapter=TopicsAdapter

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, SubjectActivity::class.java)
            startActivity(intent)
        }
        }

}