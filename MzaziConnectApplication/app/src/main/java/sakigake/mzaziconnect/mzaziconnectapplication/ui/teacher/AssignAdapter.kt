import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData

class AssignAdapter (var assignList: List<AssignmentsData>): RecyclerView.Adapter<AssignViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignViewHolder {
        var binding = TopicItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AssignViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return assignList.size

    }

    override fun onBindViewHolder(holder: AssignViewHolder, position: Int) {
        var currentassign=assignList[position]

        holder.binding.apply {
//            topic.text= currentassign.topic.toString()
            tvDueDate.text = currentassign.due_date.toString()
            tvAssignmentDetails.text = currentassign.task.toString()
            tvTopicName.text = currentassign.topic.toList().toString()
//            subject.text = currentassign.subject.toString()
//            resources.text = currentassign.resources.toString()
//            category.text = currentassign.category.toString()
//            tv.text=currentassign.competency



        }
    }
}


class AssignViewHolder(var binding:TopicItemBinding):RecyclerView.ViewHolder(binding.root){

}
