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
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
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

        val shops = listOf(
            Shops(
                1,
                "Kevine's Shop",
                "Nakuru",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695639596/Frame_208_tdmxjf.png"
            ),
            Shops(
                2,
                "Bridget's Shop",
                "Karen",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695633304/Frame_190_nd6hf5.jpg"
            ),
            Shops(
                3,
                "Mariana's",
                "Karen",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695631340/Frame_188_kj62wu.jpg"
            ),
            Shops(
                4,
                "Michael's",
                "Kangemi",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695636631/Frame_197_nzwloo.jpg"
            ),
            Shops(
                5,
                "Duka",
                "Kinca",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695633304/Frame_190_nd6hf5.jpg"
            ),
            Shops(
                6,
                "Hardware",
                "Nakuru",
                "07288989087",
                "Stationery",
                "https://res.cloudinary.com/dyxt6pqtx/image/upload/v1695639596/Frame_208_tdmxjf.png"
            ),
        )

        val recyclerView: RecyclerView = binding.rvshops
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        val shopsAdapter = ShopsAdapter(shops) { selectedSubject ->
            val intent = Intent(this, SubjectChoosenAssignments::class.java)
            intent.putExtra("TopicName", selectedSubject.name)
            intent.putExtra("AssignmentDetails", selectedSubject.location)
            intent.putExtra("DueDate", selectedSubject.shopImgUrl)
            startActivity(intent)
        }
//        shopsAdapter = ShopsAdapter(emptyList()) {
//
//        }
        recyclerView.adapter = shopsAdapter

        binding.imgBack.setOnClickListener {
            val intent = Intent(this@ShopsActivity, ParentsNavActivity::class.java)
            startActivity(intent)
        }
        binding.ivHome.setOnClickListener {
            val intent = Intent(this@ShopsActivity, ParentsNavActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
//        shopsViewModel.fetchShops()
//        shopsViewModel.shopLiveData.observe(this, Observer { shopsList ->
//            if (shopsList != null) {
//                shopsAdapter.updateShops(shopsList)
//            }
//
//        })
        shopsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

}
