import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.AssignmentView
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.AssignDetails2Activity
import java.text.SimpleDateFormat

class AssignAdapter (var assignList: List<AssignmentsData>, private val context: Context): RecyclerView.Adapter<AssignViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignViewHolder {
        var binding = TopicItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AssignViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return assignList.size

    }

    override fun onBindViewHolder(holder: AssignViewHolder, position: Int) {
        var currentassign=assignList[position]
        val binding = holder.binding
        binding.tvTopicName.text= currentassign.topic
        val inputFormat = SimpleDateFormat("yyyy-MM-dd") // Assuming the input format is yyyy-MM-dd
        val outputFormat = SimpleDateFormat("dd/MM/yyyy") // Desired output format: dd/MM/yyyy
        val formattedDate = outputFormat.format(inputFormat.parse(currentassign.due_date))
        binding.tvDueDate.text = formattedDate


//        binding.tvDueDate.text = currentassign.due_date.toString()
        binding.tvAssignmentDetails.text = currentassign.task.toString()
        holder.binding.cvAssignment.setOnClickListener {
            val intent = Intent(context, AssignDetails2Activity::class.java)
            intent.putExtra("selectedAssignmentTask", currentassign.task.toString())
            intent.putExtra("selectedAssignmentCategory", currentassign.category)
            intent.putExtra("selectedAssignmentCompetency", currentassign.competency)
            intent.putExtra("selectedAssignmentSubject", currentassign.subject)
            intent.putExtra("selectedAssignmentDueDate", currentassign.due_date)
            intent.putExtra("selectedAssignmentResources", currentassign.resources)
            intent.putExtra("selectedAssignmentTopic", currentassign.topic)
            context.startActivity(intent)
        }
    }
}

class AssignViewHolder(var binding:TopicItemBinding):RecyclerView.ViewHolder(binding.root)







