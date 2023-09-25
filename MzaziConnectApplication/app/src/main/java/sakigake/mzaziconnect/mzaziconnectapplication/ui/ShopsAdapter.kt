package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.ShopsDataclass
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ShopItemBinding

class ShopsAdapter(val shops: List<ShopsDataclass>, val onItemClick: (ShopsDataclass) -> Unit): RecyclerView.Adapter<ShopsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ShopItemBinding.inflate(inflater, parent, false)
        return  ShopsViewHolder(binding)
    }
    override fun getItemCount() = shops.size

    override fun onBindViewHolder(holder: ShopsViewHolder, position: Int) {
        val shops  = shops[position]
        holder.bind(shops)
        holder.itemView.setOnClickListener{

        }
    }
}
class ShopsViewHolder(val binding: ShopItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(shops: ShopsDataclass){
        binding.tvShopName.text = shops.shopName
        binding.tvLocation.text = shops.shoplocation
    }
}

