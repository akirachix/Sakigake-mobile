package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.CommentsListItemBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.MessageDetails

class MessageAdapter (var messages: List<Comments>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    fun updateMessages(newMessages: List<Comments>) {
        messages = newMessages
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CommentsListItemBinding.inflate(inflater, parent, false)
        return MessageViewHolder(binding)
    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val messages = messages[position]
        holder.bind(messages)
        holder.itemView.setOnClickListener {

        }

    }

    class MessageViewHolder(val binding: CommentsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Comments) {
            binding.tvmessengerName.text = message.assignment
            binding.tvmessage.text = message.content
            binding.tvmessengerName.text = message.assignment

//            Picasso.get()
//                .load(message.nameImageUrl)
//                .error(R.drawable.greenbg)
//                .transform(CropCircleTransformation())
//                .into(binding.imgMessagerImage)
        }

    }
}