package sakigake.mzaziconnect.mzaziconnectapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityChildGradeBinding

class ChildGradeActivity : AppCompatActivity() {
    lateinit var binding: ActivityChildGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_grade)
    }
}