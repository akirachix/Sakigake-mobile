package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Resources
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ResourceItemBinding

class ResourcesAdapter(val resources: List<Resources>, var onItemClick: (Resources) -> Unit): RecyclerView.Adapter<ResourceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResourceItemBinding.inflate(inflater,parent, false)
        return ResourceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val resources = resources[position]
        holder.bind(resources)

        holder.binding.btnResources.setOnClickListener{
            onItemClick(resources)
        }
    }

    override fun getItemCount() = resources.size

}

class ResourceViewHolder(val binding: ResourceItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(resources: Resources){
        binding.btnResources.text = resources.name
    }
}