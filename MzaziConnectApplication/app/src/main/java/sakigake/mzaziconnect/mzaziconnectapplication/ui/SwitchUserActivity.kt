package sakigake.mzaziconnect.mzaziconnectapplication.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySwitchUserBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.ParentLoginActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.TeacherLoginActivity

class SwitchUserActivity : AppCompatActivity() {
    lateinit var binding: ActivitySwitchUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySwitchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivbacksswitch.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, SubjectActivity::class.java)
            startActivity(intent)
        }
        binding.btnparent.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, ParentLoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnteacher.setOnClickListener {
            val intent= Intent(this@SwitchUserActivity, TeacherLoginActivity::class.java)
            startActivity(intent)
        }

    }
}