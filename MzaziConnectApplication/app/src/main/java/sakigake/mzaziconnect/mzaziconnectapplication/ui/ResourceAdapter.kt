package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ResourceBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Resource

class ResourceAdapter (val resources:List<Resource>, var onItemClick: (Resource) -> Unit): RecyclerView.Adapter<ResourceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResourceBinding.inflate(inflater,parent, false)
        return ResourceViewHolder(binding)



    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val resources = resources[position]
        holder.bind(resources)
        holder.itemView.setOnClickListener{
            onItemClick(resources)
        }
    }

    override fun getItemCount() = resources.size

}

class ResourceViewHolder(val binding: ResourceBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(resources: Resource){
        binding.btnResources.text = resources.name
    }
}
