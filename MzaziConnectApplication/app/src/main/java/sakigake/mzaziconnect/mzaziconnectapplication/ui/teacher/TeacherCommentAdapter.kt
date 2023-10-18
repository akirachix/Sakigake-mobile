package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.TeachersCommentListBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.MessageDetails

class TeacherCommentAdapter (var messages: List<Comments>) : RecyclerView.Adapter<TeacherCommentAdapter.MessageViewHolder>() {
    fun updateMessages(newMessages: List<Comments>) {
        messages = newMessages
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TeachersCommentListBinding.inflate(inflater, parent, false)
        return MessageViewHolder(binding)
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val messages = messages[position]
        holder.bind(messages)
        holder.itemView.setOnClickListener {

        }

    }

    class MessageViewHolder(val binding: TeachersCommentListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Comments) {
            binding.tvmessengerName.text = message.assignment
            binding.tvmessage.text = message.content
            binding.tvmessengerName.text = message.commentor


        }

    }
}