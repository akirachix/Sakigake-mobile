import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.database.AssignmentDataClass
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.AssignmentItemBinding

class SubjectAssignmentsAdapter(val assignments: List<AssignmentDataClass>, val onItemClick: (AssignmentDataClass) -> Unit) : RecyclerView.Adapter<SubjectAssignmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AssignmentItemBinding.inflate(inflater, parent, false)
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
class SubjectAssignmentViewHolder(val binding:AssignmentItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
   fun bind(assignment: AssignmentDataClass) {
      binding.tvTopicName.text = assignment.subjectName
      binding.tvDueDate.text = assignment.dueDate
       binding.tvAssignmentDetails.text = assignment.topicName
      binding.tvResourcesRequirements.text = assignment.resourcesRequirement
      binding.tvPostedAtTime.text = assignment.updatedAt
  }
}