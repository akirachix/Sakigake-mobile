package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import SubjectAdapter
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentHomeBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentParentsNavBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectAssignmentActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectsAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectsViewModel

class ParentsNavFragment : Fragment() {
    private var _binding: FragmentParentsNavBinding? = null
    private val binding get() = _binding!!
    lateinit var myDialog: Dialog
    private val subjectsViewModel: SubjectsViewModel by viewModels()
    private lateinit var subjectsAdapter: SubjectAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParentsNavBinding.inflate(inflater, container, false)
        val view = binding.root
        myDialog = Dialog(requireContext())

        val recyclerView: RecyclerView = binding.RvSubjectCards
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager


        subjectsAdapter = SubjectAdapter(emptyList() ) {selectedSubject ->
            val intent = Intent(requireContext(), SubjectChoosenAssignments::class.java)
            intent.putExtra("Subject Name", selectedSubject.subjectName)
            intent.putExtra("SubjectTeacherName", selectedSubject.teacher)
            startActivity(intent)
        }

        recyclerView.adapter = subjectsAdapter
        binding.btnViewAssignments.setOnClickListener {
            val intent = Intent(requireContext(), SubjectChoosenAssignments::class.java)
            startActivity(intent)
        }
        fetchParentSubject()

        return view

    }


    fun fetchParentSubject(){
        subjectsViewModel.fetchSubjects()
        subjectsViewModel.subjectsLiveData.observe(this, Observer { subjectsList ->
            subjectsAdapter.updateSubjects(subjectsList ?: emptyList())
//            Toast.makeText(
//                baseContext,
//                "Found ${subjectsList?.size} subjects",
//                Toast.LENGTH_LONG
//            ).show()
        })
        subjectsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
        })
    }


}