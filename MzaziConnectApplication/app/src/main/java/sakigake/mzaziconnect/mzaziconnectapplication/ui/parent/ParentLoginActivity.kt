package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityParentLoginBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectActivity

class ParentLoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityParentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityParentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        clearErrorOnType()
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

        binding.etnum.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilphonenum.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    fun validateLoginUser() {
        val name = binding.etname.text.toString()
        val phonenum = binding.etnum.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.etname.error = "user name is required"
            error = true
        }else {
            binding.tilname.error = null
        }

        if (phonenum.isBlank() ) {
            binding.etnum.error = "Phone Number is required"
            error = true

        }
        else {
            binding.tilphonenum.error = null
        }

        if (!error) {
            Toast.makeText(this, "Successfully logged in", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@ParentLoginActivity, SubjectActivity::class.java))

        }



    }
}