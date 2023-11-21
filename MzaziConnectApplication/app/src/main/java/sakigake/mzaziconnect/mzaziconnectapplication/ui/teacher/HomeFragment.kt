package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentHomeBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.ui.AccountSettingsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.LogoutActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.SubjectChoosenAssignments
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectsViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var myDialog: Dialog
    val subjectViewModel: SubjectsViewModel by viewModels()
    lateinit var subjectsAdapter: SubjectsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        myDialog = Dialog(requireContext())


        val recyclerView: RecyclerView = binding.rvsub
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager

        val subjects = listOf(
            Subjects(
                "Agriculture",
                "Farming",
                1,
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_185_1_c2jysn.jpg",
            ),
            Subjects(
                "English",
                "Grammar",
                2,
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_180_1_kjclpx.jpg",
            ),
            Subjects(
                "Math",
                "Calculations",
                3,
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_181_rfkkvo.jpg",
            ),
            Subjects(
                "Science",
                "Human body",
                4,
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_186_1_ldcvij.jpg",
        ),
        )


//        val subjectAdapter = SubjectAdapter(subjects) { selectedSubject ->
//            val intent = Intent(this, SubjectChoosenAssignments::class.java)
//            intent.putExtra("TopicName", selectedSubject.subjectName)
//            intent.putExtra("AssignmentDetails", selectedSubject.subjectTeacherName)
//            intent.putExtra("DueDate", selectedSubject.subjectImageUrl)
//            startActivity(intent)
//        }

        subjectsAdapter = SubjectsAdapter(subjects) {selectedSubject ->
            val intent = Intent(requireContext(), SubjectAssignmentActivity::class.java)
            intent.putExtra("Subject Name", selectedSubject.subjectName)
            intent.putExtra("SubjectTeacherName", selectedSubject.teacher)
            intent.putExtra("DueDate", selectedSubject.subjectImageUrl)
            startActivity(intent)
        }
        recyclerView.adapter = subjectsAdapter
//        fetchSubject()


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnassign.setOnClickListener {
            startActivity(Intent(requireContext(), SubjectAssignmentActivity::class.java))
        }
        
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvsub.layoutManager = layoutManager
    }

    fun ShowPopup() {
        var btnstay:Button
        var btnlogout: Button
        myDialog.setContentView(R.layout.logout)
        btnlogout = myDialog.findViewById(R.id.btnyes)
        btnlogout.text = "Continue"
        btnstay = myDialog.findViewById(R.id.btnno)
        btnstay.setOnClickListener {
            myDialog.dismiss()
        }
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                val intent = Intent(requireContext(), AccountSettingsActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.nav_logout -> {
                val intent = Intent(requireContext(), LogoutActivity::class.java)
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    fun fetchSubject() {
//        subjectViewModel.fetchSubjects()
//
//        subjectViewModel.subjectsLiveData.observe(viewLifecycleOwner, Observer { subjectsList ->
//            subjectsAdapter.updateSubjects(subjectsList ?: emptyList())
//
//        })
//        subjectViewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
//            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
//        })
//
//    }


}