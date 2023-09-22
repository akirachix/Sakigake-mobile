package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.database.Topics
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectChoosenAssignmentsBinding

class SubjectChoosenAssignments : AppCompatActivity() {
    lateinit var binding: ActivitySubjectChoosenAssignmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectChoosenAssignmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.rvAssignmentTopics
        val topics = listOf(
            Topics("Plants - ", "25/12/2023", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023"),
            Topics("Animals - ", "25/12/2023", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023"),
            Topics("Farm Tools - ", "25/12/2023", "In this assignment, you will explore the world of plants and learn about their basic needs for growth", "Posted at 25/12/2023"),
            Topics("Weeds - ", "25/12/2023", "In this assignment, you will explore the world of plants and learn about their basic needs for growth.", "Posted at 25/12/2023")
        )

        val adapter = SubjectChoosenAssignmentsAdapter(topics)
        recyclerView.adapter = adapter

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, ChildGrade::class.java)
            startActivity(intent)
        }
    }
}


