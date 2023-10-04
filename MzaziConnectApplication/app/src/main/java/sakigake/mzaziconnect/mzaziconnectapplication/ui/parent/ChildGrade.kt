package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import SubjectAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityChildGradeBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectAssignmentActivity
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectsViewModel

class ChildGrade : AppCompatActivity() {
    private lateinit var binding: ActivityChildGradeBinding
    private val subjectsViewModel: SubjectsViewModel by viewModels()
    private lateinit var subjectsAdapter: SubjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.RvSubjectCards
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        subjectsAdapter = SubjectAdapter(emptyList() ) {selectedSubject ->
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            intent.putExtra("Subject Name", selectedSubject.subjectName)
            intent.putExtra("SubjectTeacherName", selectedSubject.teacher)
            startActivity(intent)
        }
        recyclerView.adapter = subjectsAdapter
        binding.btnViewAssignments.setOnClickListener {
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        fetchSubject()

    }

    fun fetchSubject() {
        subjectsViewModel.fetchSubjects()
        subjectsViewModel.subjectsLiveData.observe(this, Observer { subjectsList ->
            subjectsAdapter.updateSubjects(subjectsList ?: emptyList())
            Toast.makeText(
                baseContext,
                "Found ${subjectsList?.size} subjects",
                Toast.LENGTH_LONG
            ).show()
        })
        subjectsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

    }



}
