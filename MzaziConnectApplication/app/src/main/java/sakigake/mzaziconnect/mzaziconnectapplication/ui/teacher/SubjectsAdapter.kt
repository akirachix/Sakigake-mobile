package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectBinding


class SubjectsAdapter (private val subjects: List<Subjects>,val onItemClick: (Subjects) -> Unit) : RecyclerView.Adapter<SubjectsAdapter.SubjectViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = SubjectBinding.inflate(inflater, parent, false)
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
        class SubjectViewHolder(private val binding: SubjectBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(subject: Subjects) {
                binding.tvSubjectName.text = subject.subjectName
                binding.tvSubjectTeacherName.text = subject.subjectTeacherName
                Picasso.get()
                    .load(subject.subjectImageUrl)
                    .error(R.drawable.farm)
                    .into(binding.imgSubject)
                binding.tvSubjectTeacherName.text = subject.subjectTeacherName
            }
        }
    }