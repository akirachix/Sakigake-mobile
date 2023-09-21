package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityMainBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects

class SubjectActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onResume()

        binding.ivbackset.setOnClickListener {
            val intent= Intent(this@SubjectActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnvclass.setOnClickListener {
            val intent = Intent(this@SubjectActivity,MyClassesActivity::class.java)
            startActivity(intent)
        }
        binding.ivdotsset.setOnClickListener {
            startActivity(Intent(this@SubjectActivity, NavActivity::class.java))
        }


        val subjects = listOf(
            Subjects("English","" ,"Ms Kiki" ),
            Subjects("Math","" ,"Ms Wesleyina"),
            Subjects("Science", "","Mr Kamau"),
            Subjects("Agriculture", "","Mr p"),
            Subjects("Kiswahili","", "Ms Kelly"),
            Subjects("Art", "", "Ms Nessie"),
            Subjects("English","" ,"Ms Janie" ),
            Subjects("Math","" ,"Ms Puri "),

            )

        val subjectAdapter = SubjectsAdapter(subjects)
        binding.rvsub.adapter = subjectAdapter

        val layoutManager = GridLayoutManager(this, 2)
        binding.rvsub.layoutManager = layoutManager




    }
    }

//    override fun onResume() {
//        super.onResume()
//        binding.rvsub.layoutManager=GridLayoutManager(this@SubjectActivity,2)
//
//
//
//    }
