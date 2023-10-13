package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectChoosenAssignmentItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TopicItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import java.text.SimpleDateFormat
import java.util.Date

class SubjectChoosenAssignmentsAdapter(private val topics: List<TopicsData>, private val context: Context) : RecyclerView.Adapter<SubjectChoosenAssignmentsAdapter.SubjectChoosenAssignmentViewHolder>() {

//    private val CHANNEL_ID = "AssignmentNotificationChannel"
//    private val NOTIFICATION_ID = 1

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
//        binding.tvNewLabel.text = topic.

        if (isNewAssignment(topic)) {
            binding.tvNewLabel.visibility = View.VISIBLE
//            showNotification(topic)
        } else {
            binding.tvNewLabel.visibility = View.GONE
        }



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
    @SuppressLint("SimpleDateFormat")
    fun isNewAssignment(topic: TopicsData): Boolean {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dueDate = dateFormat.parse(topic.due_date)
        return currentDate.before(dueDate)
    }

//    private fun showNotification(topic: TopicsData) {
//        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        val channel = NotificationChannel(
//            CHANNEL_ID,
//            "Assignment Notifications",
//            NotificationManager.IMPORTANCE_DEFAULT
//        )
//        notificationManager.createNotificationChannel(channel)
//
//        val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
//            .setSmallIcon(R.drawable.baseline_calendar_today_24)
//            .setContentTitle("New Assignment")
//            .setContentText("A new assignment has been posted: ${topic.task}")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
//    }


    class SubjectChoosenAssignmentViewHolder(val binding: SubjectChoosenAssignmentItemBinding) : RecyclerView.ViewHolder(binding.root)
}