
package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ShopItemBinding

class ShopsAdapter(var shops: List<Shops>, val onItemClick: (Shops) -> Unit): RecyclerView.Adapter<ShopsViewHolder>() {
    fun updateShops(newShops: List<Shops>) {
        shops=newShops
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ShopItemBinding.inflate(inflater, parent, false)
        return  ShopsViewHolder(binding)
    }

    override fun getItemCount() = shops.size

    override fun onBindViewHolder(holder: ShopsViewHolder, position: Int) {
        val shop = shops[position]
        holder.bind(shop)
        holder.itemView.setOnClickListener {
            onItemClick(shop)
        }
    }
}

class ShopsViewHolder(val binding: ShopItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(shops: Shops) {
        binding.tvSubjectName.text = shops.name
        binding.tvShopLocation.text = shops.location
        Picasso.get()
            .load(shops.shopImgUrl)
            .error(R.drawable.shop)
            .into(binding.imgSubject)

    }
}