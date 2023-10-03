package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectassignmentBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentData

class AssignmentAdapter (val assignments: List<AssignmentData>, val onItemClick: (AssignmentData) -> Unit)
    : RecyclerView.Adapter<SubjectAssignmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SubjectassignmentBinding.inflate(inflater, parent, false)
        return SubjectAssignmentViewHolder(binding)
    }
    override fun getItemCount() = assignments.size

    override fun onBindViewHolder(holder: SubjectAssignmentViewHolder, position: Int) {
        val assignment = assignments[position]
        holder.bind(assignment)

        holder.itemView.setOnClickListener {
            onItemClick(assignment)
        }
    }
}
    class SubjectAssignmentViewHolder(val binding:SubjectassignmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(assignment: AssignmentData) {
            binding.tvTopicName.text = assignment.subjectName
            binding.tvDueDate.text = assignment.dueDate
            binding.tvAssignmentDetails.text = assignment.topicName
            binding.tvResourcesRequirements.text = assignment.resourcesRequirement
            binding.tvPostedAtTime.text = assignment.updatedAt
        }
}