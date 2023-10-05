package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityShopsBinding
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.NavActivity
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.ShopsViewModel
class ShopsActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopsBinding
    private val shopsViewModel: ShopsViewModel by viewModels()
    private lateinit var shopsAdapter: ShopsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.rvshops
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        shopsAdapter = ShopsAdapter(emptyList()) {

        }
        recyclerView.adapter = shopsAdapter

        binding.imgBack.setOnClickListener {
            val intent = Intent(this@ShopsActivity, SubjectChoosenAssignments::class.java)
            startActivity(intent)
        }
        binding.ivHome.setOnClickListener {
            val intent = Intent(this@ShopsActivity, ChildGrade::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
        shopsViewModel.fetchShops()
        shopsViewModel.shopLiveData.observe(this, Observer { shopsList ->
            if (shopsList != null) {
                shopsAdapter.updateShops(shopsList)
            }
            Toast.makeText(
                baseContext,
                "Found ${shopsList?.size} shops",
                Toast.LENGTH_LONG
            ).show()

        })
        shopsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

}
