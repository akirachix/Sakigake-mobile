package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.model.ShopData

class ShopAdapter(private val context: Context, private var shopList:List<ShopData>)
    : ArrayAdapter<ShopData>(context, R.layout.shops_item, shopList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.shops_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.tvvshop)
        textView.text =shopList[position].name
        return view
    }

    override fun getCount(): Int {
        return shopList.size
    }
    override fun getItem(position: Int): ShopData {
        return shopList[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }



}