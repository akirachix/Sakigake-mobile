package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

class TopicsAdapter (val topics: List<TopicsData>, val onItemClick:(TopicsData)-> Unit)
    : RecyclerView.Adapter<TopicsAdapter.SubjectChoosenAssignmentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }
    override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topics = topics[position]


    }



    class SubjectChoosenAssignmentViewHolder(val binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)
    {


    }


}