package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.Topics
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectChoosenAssignmentItemBinding

class SubjectChoosenAssignmentsAdapter(val topics: List<Topics>, val onItemClick: (Topics) -> Unit) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
                val binding = SubjectChoosenAssignmentItemBinding.inflate(inflater, parent, false)
                return SubjectChoosenAssignmentViewHolder(binding)
    }
        override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
          val topics = topics[position]

         holder.bind(topics)
        holder.itemView.setOnClickListener {
            onItemClick(topics)
        }
    }

class SubjectChoosenAssignmentViewHolder(val binding: SubjectChoosenAssignmentItemBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(topics: Topics) {
        binding.tvTopicName.text = topics.topicName
        binding.tvAssignmentDetails.text = topics.assignmentDetails
        binding.tvDueDate.text = topics.dueDate
        binding.tvPostedAtTime.text = topics.postedAt

    }

}}

