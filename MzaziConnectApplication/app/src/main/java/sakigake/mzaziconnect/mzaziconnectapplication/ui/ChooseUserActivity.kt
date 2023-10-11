package sakigake.mzaziconnect.mzaziconnectapplication.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityChooseUserBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.ParentLoginActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.TeacherLoginActivity

class ChooseUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityChooseUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnparent.setOnClickListener {
            val intent = Intent(this@ChooseUserActivity, ParentLoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnteacher.setOnClickListener {
            val intent = Intent(this@ChooseUserActivity, TeacherLoginActivity::class.java)
            startActivity(intent)
        }
    }
}