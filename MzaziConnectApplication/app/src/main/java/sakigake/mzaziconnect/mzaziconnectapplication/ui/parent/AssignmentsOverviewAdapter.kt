import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.database.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectOverviewItemBinding

class SubjectAdapter(private val subjects: List<Subjects>,  private val onItemClick: (Subjects) -> Unit) : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SubjectOverviewItemBinding.inflate(inflater, parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjects[position]
        holder.bind(subject)

        holder.itemView.setOnClickListener {
            onItemClick(subject)
        }

    }

    override fun getItemCount() = subjects.size
    class SubjectViewHolder(private val binding: SubjectOverviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: Subjects) {
            binding.tvSubjectName.text = subject.subjectName
            Picasso.get()
                .load(subject.subjectImageUrl)
                .error(R.drawable.english_image)
                .into(binding.imgSubject)
            binding.tvSubjectTeacherName.text = subject.subjectTeacherName
        }
    }
}