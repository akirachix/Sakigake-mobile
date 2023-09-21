package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityMyClassesBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects

class MyClassesActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyClassesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyClassesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivbackset.setOnClickListener {
            val intent= Intent(this@MyClassesActivity, SubjectActivity::class.java)
            startActivity(intent)

        }
        binding.ivdotsset.setOnClickListener {
            startActivity(Intent(this@MyClassesActivity, NavActivity::class.java))
        }


        val subjects = listOf(
            Subjects("English","" ,"Ms Kiki" ),
            Subjects("Math","" ,"Ms Kiki"),
            )

        val subjectAdapter = SubjectsAdapter(subjects)
        binding.rvcsub.adapter = subjectAdapter

        val layoutManager = GridLayoutManager(this, 2)
        binding.rvcsub.layoutManager = layoutManager

    }
}