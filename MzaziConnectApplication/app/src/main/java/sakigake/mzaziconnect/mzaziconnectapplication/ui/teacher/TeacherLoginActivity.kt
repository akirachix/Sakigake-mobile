package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import org.jetbrains.exposed.sql.transactions.transaction
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityTeacherLoginBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.TeacherLoginViewModel
class TeacherLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityTeacherLoginBinding
    val teacherLoginViewModel: TeacherLoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener {
            validateLogin()
        }
        teacherLoginViewModel.errLiveData.observe(this, Observer { error ->
            binding.pbProgressBar.visibility = View.VISIBLE
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
        teacherLoginViewModel.regLiveData.observe(this, Observer { loginResponse ->
            binding.pbProgressBar.visibility = View.VISIBLE
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, NavActivity::class.java))
            finish()
        })

    }
    fun validateLogin() {
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false

        if (password.isBlank()) {
            binding.etpassword.error = "Password is required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.etPhoneNumber.error = "Phone Number is required"
            error = true
        }
        if (!error) {
            val loginUser = TeacherLoginRequest(phoneNumber, password)
            teacherLoginViewModel.teacherLogin(loginUser)
            binding.pbProgressBar.visibility = View.VISIBLE
        }
    }

}