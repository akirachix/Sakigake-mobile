package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.AccountSettingsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.LogoutActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.SwitchUserActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.AssignmentView
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectsViewModel

class SubjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubjectBinding
    private lateinit var myDialog: Dialog
    private val subjectViewModel: SubjectsViewModel by viewModels()
    private lateinit var subjectsAdapter: SubjectsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.dots)

        myDialog = Dialog(this)

        subjectsAdapter = SubjectsAdapter(emptyList()) { selectedSubjects ->
            val intent = Intent(this, AssignmentView::class.java)
            intent.putExtra("assignmentDetails", selectedSubjects.subjectName)
            startActivity(intent)
        }

        binding.ivbackset.setOnClickListener {
            val intent = Intent(this@SubjectActivity, TeacherLoginActivity::class.java)
            startActivity(intent)
        }

        binding.ivsettings.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, AccountSettingsActivity::class.java))
        }

        binding.ivswitch.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, SwitchUserActivity::class.java))
        }

        binding.btnassign.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, SubjectAssignmentActivity::class.java))
        }

        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }

        binding.rvsub.adapter = subjectsAdapter

        val layoutManager = GridLayoutManager(this, 2)
        binding.rvsub.layoutManager = layoutManager
    }

    private fun showPopup() {
        myDialog.setContentView(R.layout.logout)
        val btnLogout: Button = myDialog.findViewById(R.id.btnyes)
        btnLogout.text = "Continue"
        val btnStay: Button = myDialog.findViewById(R.id.btnno)
        btnStay.setOnClickListener {
            myDialog.dismiss()
        }
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                val intent = Intent(this, AccountSettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_logout -> {
                val intent = Intent(this, LogoutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        subjectViewModel.fetchSubjects()
        subjectViewModel.subjectsLiveData.observe(
            this,
            Observer { subjectsList ->
                subjectsAdapter.updateSubjects(subjectsList ?: emptyList())
            }
        )
        subjectViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}
