package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.model.SubjectData

class SubjectAdapter(private val context: Context, private var subjectList:List<SubjectData>)
    : ArrayAdapter<SubjectData>(context, R.layout.subject_item, subjectList)

{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.subject_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.tvvsubject)
        textView.text =subjectList[position].subject_name
        return view
    }

    override fun getCount(): Int {
        return subjectList.size
    }
    override fun getItem(position: Int): SubjectData {
        return subjectList[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


}