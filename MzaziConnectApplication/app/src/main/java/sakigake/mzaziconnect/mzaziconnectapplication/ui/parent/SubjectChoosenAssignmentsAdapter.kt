package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectChoosenAssignmentItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import java.text.SimpleDateFormat
import java.util.Date

class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, private val context: Context) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SubjectChoosenAssignmentItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topic = topics[position]
        val binding = holder.binding
        binding.tvTopicName.text = topic.topic.toString()
        binding.tvTopicName.text = topic.topic
        binding.tvDueDate.text = topic.due_date
        binding.tvAssignmentDetails.text = topic.task

        if (isNewAssignment(topic)) {
            binding.tvNewLabel.visibility = View.VISIBLE
        } else {
            binding.tvNewLabel.visibility = View.GONE
        }

        holder.binding.cvAssignment.setOnClickListener {
            val intent = Intent(context, AssignmentView::class.java)
            intent.putExtra("selectedAssignmentId", topic.topic)
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
    @SuppressLint("SimpleDateFormat")
    fun isNewAssignment(topic: TopicsData): Boolean {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dueDate = dateFormat.parse(topic.due_date)
        return currentDate.before(dueDate)
    }
    class SubjectChoosenAssignmentViewHolder(val binding: SubjectChoosenAssignmentItemBinding) : RecyclerView.ViewHolder(binding.root)
}