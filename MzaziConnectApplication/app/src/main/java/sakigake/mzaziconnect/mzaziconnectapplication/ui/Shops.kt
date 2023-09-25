package sakigake.mzaziconnect.mzaziconnectapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.database.ShopsDataclass
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityShopsBinding

class Shops : AppCompatActivity() {
    lateinit var binding: ActivityShopsBinding
    lateinit var shopsAdapter: ShopsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.rvshops
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val shops = listOf(
            ShopsDataclass("Utawala New", "Kinca"),
            ShopsDataclass("Duka Yetu", "Fagilia"),
            ShopsDataclass("Agro Zote", "Astrol")
        )

        shopsAdapter = ShopsAdapter(shops) { selectedShop ->

        }

        recyclerView.adapter = shopsAdapter
    }
}