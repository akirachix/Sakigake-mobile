package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

class TopicsAdapter (val topics: List<TopicsData>)
    : RecyclerView.Adapter<TopicsAdapter.SubjectChoosenAssignmentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }
    override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topics = topics[position]
//        holder.bind(topics)
////        val image = holder.binding.ivassigndots
//        holder.itemView.setOnClickListener {
//        onItemClick(topics)
//        }

    }



    class SubjectChoosenAssignmentViewHolder(val binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
//        fun bind(topics: TopicsData) {
//            binding.tvTopicName.text = topics.topicName
//            binding.tvAssignmentDetails.text = topics.assignmentDetails
//            binding.tvDueDate.text = topics.dueDate
//            binding.tvPostedAtTime.text = topics.postedAt
//
//        }

    }


}