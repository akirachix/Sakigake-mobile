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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentHomeBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.ui.AccountSettingsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.LogoutActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var myDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        myDialog = Dialog(requireContext())

        // Set up your UI components and listeners here

        // ...

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val subjects = listOf(
//            Subjects("Agriculture","https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_180_1_kjclpx.jpg" ,"Ms Kiki" ),
//            Subjects("Math","https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_181_rfkkvo.jpg" ,"Ms Kiki"),
//            Subjects("Science", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_186_1_ldcvij.jpg","Mr Kiki"),
//            Subjects("Art", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_180_1_kjclpx.jpg", "Ms Kiki"),
//            Subjects("CRE", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_182_hgbhpy.jpg","Mr Kiki"),
//            Subjects("Islam", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_183_1_pdflt4.jpg","Mr Kiki"),
//        )
//
//        val subjectsAdapter = SubjectsAdapter(subjects) { selectedSubject ->
//            val intent = Intent(requireContext(), SubjectAssignmentActivity::class.java)
//            intent.putExtra("TopicName", selectedSubject.subjectName)
//            intent.putExtra("AssignmentDetails", selectedSubject.subjectTeacherName)
//            intent.putExtra("DueDate", selectedSubject.subjectImageUrl)
//            startActivity(intent)
//        }

//        binding.rvsub.adapter = subjectsAdapter


         binding.btnassign.setOnClickListener {
         startActivity(Intent(requireContext(), SingleSubjectActivity::class.java))
         }

        binding.ivbackset.setOnClickListener {
            startActivity(Intent(requireContext(), TeacherLoginActivity::class.java))
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


}
