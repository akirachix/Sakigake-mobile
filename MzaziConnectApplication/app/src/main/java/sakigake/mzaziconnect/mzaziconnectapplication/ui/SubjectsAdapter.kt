package sakigake.mzaziconnect.mzaziconnectapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.SubjectBinding


class SubjectsAdapter (private val subjects: List<Subjects>) : RecyclerView.Adapter<SubjectsAdapter.SubjectViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = SubjectBinding.inflate(inflater, parent, false)
            return SubjectViewHolder(binding)
        }

        override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
            val subject = subjects[position]
            holder.bind(subject)
        }


        override fun getItemCount() = subjects.size
        class SubjectViewHolder(private val binding: SubjectBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(subject: Subjects) {
                binding.tvsub.text = subject.subjectName

                binding.tvteacher.text = subject.subjectTeacherName
            }
        }
    }