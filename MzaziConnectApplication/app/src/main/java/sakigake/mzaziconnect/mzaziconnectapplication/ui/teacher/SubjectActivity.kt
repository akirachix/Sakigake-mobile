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
import androidx.recyclerview.widget.GridLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.ui.AccountSettingsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.LogoutActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.SwitchUserActivity

class SubjectActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubjectBinding
    private lateinit var myDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val fragment = HomeFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.home_frag, fragment)
//        transaction.commit()


        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.dots)

        myDialog = Dialog(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        onResume()

        binding.ivbackset.setOnClickListener {
            val intent= Intent(this@SubjectActivity, TeacherLoginActivity::class.java)
            startActivity(intent)
        }
//        binding.ivdotsset.setOnClickListener {
//            startActivity(Intent(this@SubjectActivity, AccountSettingsActivity::class.java))
//        }

        binding.ivsettings.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, AccountSettingsActivity::class.java))
        }

        binding.ivswitch.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, SwitchUserActivity::class.java))
            }


        binding.btnassign.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, SingleSubjectActivity::class.java))

        }

        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }




        val subjects = listOf (
            Subjects("Agriculture","https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_180_1_kjclpx.jpg" ,"Ms Kiki" ),
            Subjects("Math","https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_181_rfkkvo.jpg" ,"Ms Kiki"),
            Subjects("Science", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_186_1_ldcvij.jpg","Mr Kiki"),
            Subjects("Art", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_180_1_kjclpx.jpg", "Ms Kiki"),
            Subjects("CRE", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151509/Frame_182_hgbhpy.jpg","Mr Kiki"),
            Subjects("Islam", "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695151508/Frame_183_1_pdflt4.jpg","Mr Kiki"),
            )

        val subjectsAdapter = SubjectsAdapter(subjects) { selectedSubject ->
            val intent = Intent(this, SubjectAssignmentActivity::class.java)
            intent.putExtra("TopicName", selectedSubject.subjectName)
            intent.putExtra("AssignmentDetails", selectedSubject.subjectTeacherName)
            intent.putExtra("DueDate", selectedSubject.subjectImageUrl)
            startActivity(intent)
        }

        binding.rvsub.adapter = subjectsAdapter

        val layoutManager = GridLayoutManager(this, 2)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.nav_menu, menu)
//        return true
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
        binding.rvsub.layoutManager=GridLayoutManager(this@SubjectActivity,2)

    }}





