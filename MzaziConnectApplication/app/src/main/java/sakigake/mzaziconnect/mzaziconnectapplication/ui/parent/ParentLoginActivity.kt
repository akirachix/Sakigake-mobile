package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityParentLoginBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.ParentLoginViewModel


class ParentLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParentLoginBinding
    private val parentLoginViewModel: ParentLoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityParentLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setContentView(binding.root)

        binding.btnlogin.setOnClickListener {
            validateLogin()
        }
        parentLoginViewModel.errLiveData.observe(this, Observer { error ->
            binding.pbProgressBar1.visibility = View.GONE
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
        parentLoginViewModel.regLiveData.observe(this, Observer { loginResponse ->
            binding.pbProgressBar1.visibility = View.GONE
            Toast.makeText(this, loginResponse.message, Toast.LENGTH_LONG).show()

            val userPhoneNumber = binding.etPhoneNumber.text.toString()
            intent.putExtra("userPhoneNumber", userPhoneNumber)
            startActivity(intent)

            startActivity(Intent(this, ParentsNavActivity::class.java))
                finish()
        })
    }
    private fun validateLogin() {
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
            val loginRequest = ParentLoginRequest(
                phoneNumber = phoneNumber,
                password = password
            )
            binding.pbProgressBar1.visibility = View.VISIBLE
            parentLoginViewModel.parentLogin(loginRequest)
        }
    }
}