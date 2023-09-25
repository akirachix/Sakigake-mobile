package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityLoginBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onResume()
    }

    override fun onResume() {
        super.onResume()
      clearErrorOnType()
//        clearErrors()
        binding.btnlogin.setOnClickListener {
            validateLoginUser()

        }
    }

    fun clearErrorOnType() {
        binding.etname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilname.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.etpassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilpassword.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

//    fun clearErrors() {
//        binding.tilname.error = null
//        binding.tilpassword.error = null
//
//    }

    fun validateLoginUser() {
        val name = binding.etname.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.etname.error = "user name is required"
            error = true
        }else {
            binding.tilname.error = null
        }

        if (password.isBlank()) {
            binding.etpassword.error = "Password is required"
            error = true

        }
        else {
            binding.tilpassword.error = null
        }

        if (!error) {
            Toast.makeText(this, "Successfully logged in", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@LoginActivity, SubjectActivity::class.java))

        }



    }
}