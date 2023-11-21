package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import java.text.SimpleDateFormat

class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, private val context: Context) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topic = topics[position]
        val binding = holder.binding
        binding.tvTopicName.text = topic.topic.toString()


        val inputFormat = SimpleDateFormat("yyyy-MM-dd") // Assuming the input format is yyyy-MM-dd
        val outputFormat = SimpleDateFormat("dd/MM/yyyy") // Desired output format: dd/MM/yyyy
        val formattedDate = outputFormat.format(inputFormat.parse(topic.due_date))
        binding.tvDueDate.text = formattedDate
//        binding.tvDueDate.text = topic.due_date




        binding.tvAssignmentDetails.text = topic.task
        holder.binding.cvAssignment.setOnClickListener {
            val intent = Intent(context, AssignmentView::class.java)
            intent.putExtra("selectedAssignmentId", topic.id)
            intent.putExtra("selectedAssignmentTask", topic.task)
            intent.putExtra("selectedAssignmentCategory", topic.category)
            intent.putExtra("selectedAssignmentCompetency", topic.competency)
            intent.putExtra("selectedAssignmentSubject", topic.subject)
            intent.putExtra("selectedAssignmentDueDate", topic.due_date)
            intent.putExtra("selectedAssignmentResources", topic.resources)
            intent.putExtra("selectedAssignmentTopic", topic.topic)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return topics.size
    }

    class SubjectChoosenAssignmentViewHolder(val binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)
}