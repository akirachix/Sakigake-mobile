package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.currentCoroutineContext
import sakigake.mzaziconnect.mzaziconnectapplication.database.Topics
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData

class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, val onItemClick: (TopicsData) -> Unit) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectChoosenAssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemBinding.inflate(inflater, parent, false)
        return SubjectChoosenAssignmentViewHolder(binding)
    }
    override fun getItemCount() = topics.size
    override fun onBindViewHolder(holder: SubjectChoosenAssignmentViewHolder, position: Int) {
        val topics = topics[position]
        holder.binding.apply {
            val topicText = topics.topic.joinToString(", ")
            tvTopicName.text= topicText
            tvDueDate.text = topics.due_date
            tvAssignmentDetails.text = topics.task

            root.setOnClickListener {
                onItemClick(topics)
            }
        }


    }
    class SubjectChoosenAssignmentViewHolder(val binding: TopicItemBinding) : RecyclerView.ViewHolder(binding.root)
    
}







