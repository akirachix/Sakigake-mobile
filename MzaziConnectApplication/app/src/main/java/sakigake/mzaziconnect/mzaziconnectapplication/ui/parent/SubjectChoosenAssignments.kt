package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent
import TopicViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivitySubjectChoosenAssignmentsBinding

class SubjectChoosenAssignments : AppCompatActivity() {
    lateinit var binding: ActivitySubjectChoosenAssignmentsBinding
    private val assignViewModel: TopicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectChoosenAssignmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.rvAssignmentTopics

        binding.imgBack.setOnClickListener {
            val intent = Intent(this, ParentsNavActivity::class.java)
            startActivity(intent)
        }
        binding.imgHome.setOnClickListener {
            startActivity(Intent(this@SubjectChoosenAssignments, ChildGrade::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        assignViewModel.fetchAssign()

        assignViewModel.errorLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        })
        assignViewModel.assignLiveData.observe(this, Observer { productsList ->
            binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(this)
            binding.rvAssignmentTopics.adapter = SubjectChoosenAssignmentsAdapter(productsList, this)
        })
    }
}










//        override fun onResume() {
//        super.onResume()
//        assignViewModel.fetchAssign()
//        assignViewModel.assignLiveData.observe(
//            this,
//            Observer { assignmentList ->
//                val assignmentsAdapter = SubjectChoosenAssignmentsAdapter(assignmentList?: emptyList()){ selectedAssignment ->
//                    val intent = Intent(this, AssignmentView::class.java)
//                    val selectedId = selectedAssignment.id
//                    intent.putExtra("selectedAssignmentid", selectedId)
//                    startActivity(intent)
//                }
//                binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(this)
//                binding.rvAssignmentTopics.adapter = assignmentsAdapter
//            })
//        assignViewModel.errorLiveData.observe(this, Observer{ error ->
//            Toast.makeText( baseContext, error, Toast.LENGTH_LONG).show()
//        })
//
//    }
//override fun onResume() {
//    super.onResume()
//    assignViewModel.fetchAssign()
//
//    assignViewModel.assignLiveData.observe(
//        this,
//        Observer { assignmentList ->
//            val assignmentsAdapter = SubjectChoosenAssignmentsAdapter(assignmentList ?: emptyList()) { selectedAssignment ->
//                val intent = Intent(this, AssignmentView::class.java)
//                val selectedId = selectedAssignment.id
//                intent.putExtra("selectedAssignmentid", selectedId)
//                startActivity(intent)
//            }


//        this,
//        Observer { err ->Toast.makeText(baseContext,err->,)
////            val assignmentsAdapter = SubjectChoosenAssignmentsAdapter(assignmentList ?: emptyList()) { selectedAssignment ->
//                val intent = Intent(this, AssignmentView::class.java)
////                val selectedId = selectedAssignment.id
////                intent.putExtra("selectedAssignmentid", selectedId)
//                startActivity(intent)
////            }
//            binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(this)
//            binding.rvAssignmentTopics.adapter = assignmentsAdapter
//        })
//    assignViewModel.errorLiveData.observe(this, Observer { error ->
//        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//    })
//}


//    override fun onResume() {
//    super.onResume()
//    productsViewModel.fetchProducts()
//
//    productsViewModel.errLiveData.observe(this, Observer { err->
//        Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
//    })
//
//    productsViewModel.productsLiveData.observe(this, Observer { productsList->
//        binding.rvProduct.layoutManager = GridLayoutManager(this@MainActivity,
//            2)
//        binding.rvProduct.adapter = ProductAdapter(productsList,this)
//    })
//}