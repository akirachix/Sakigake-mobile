//package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.coroutines.currentCoroutineContext
//import sakigake.mzaziconnect.mzaziconnectapplication.database.Topics
//import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
//import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
//
//class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, val context :Context) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = TopicItemBinding.inflate(inflater, parent, false)
//        return SubjectChoosenAssignmentViewHolder(binding)
//    }
//
//
//    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
//        val topics = topics[position]
//        val binding = holder.binding
//
////            binding.tvAssignmentDetails = topics.joinToString(", ")
//            binding.tvTopicName.text =topics.toString()
//           binding. tvDueDate.text = topics.due_date
//           binding. tvAssignmentDetails.text = topics.task
//
//           holder.binding. cvAssignment.setOnClickListener {
//                val intent = Intent(context, AssignmentView::class.java)
//                intent.putExtra("ASSIGNMENT_ID", topics.id)
//                intent.putExtra("ASSIGNMENT_TASK", topics.task)
//                intent.putExtra("ASSIGNMENT_CATEGORY", topics.category)
//                intent.putExtra("ASSIGNMENT_COMPETENCY", topics.competency)
//                intent.putExtra("ASSIGNMENT_SUBJECT", topics.subject)
//                intent.putExtra("ASSIGNMENT_DUE_DATE", topics.due_date)
//                intent.putExtra("ASSIGNMENT_RESOURCES", topics.resources)
//                intent.putExtra("ASSIGNMENT_TOPIC", topics.topic)
//                Context.startActivity(intent)
//
//            }
//
//
//        }
//
//    }
//        override fun getItemCount(): Int {
//            return topics.size
//
//        }
//
//        class SubjectChoosenAssignmentViewHolder(var binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)
//
//}
//
//
//
//
//
//
//
//
package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, private val context: Context) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topic = topics[position]
        val binding = holder.binding

//        binding.tvTopicName.text = topic.toString()
        binding.tvDueDate.text = topic.due_date
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
