package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityCommentsBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.AssignmentView
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.MessageAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.CommentsViewModel
import java.lang.Exception

class CommentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentsBinding
    private val commentsViewModel: CommentsViewModel by viewModels()
    private lateinit var commentsAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        commentsAdapter = MessageAdapter(emptyList())
        recyclerView.adapter = commentsAdapter

        binding.ivbackmssg.setOnClickListener {
            startActivity(Intent(this, AssignmentView::class.java))
        }

        binding.ivsend.setOnClickListener {
            saveComments()
            binding.etMessage.setText("")
//            startActivity(Intent(this@CommentsActivity, CommentsActivity::class.java))
        }

        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        try{


        commentsViewModel.fetchComments().observe(this) { commentsList ->
            commentsAdapter.updateMessages(commentsList)
            Toast.makeText(
                baseContext,
                "Found ${commentsList.size} comments",
                Toast.LENGTH_LONG
            ).show()
        }

        commentsViewModel.errorLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        }
        }catch (e : Exception){
            Log.e("TAG", "onResume: ", e)
        }
    }


    fun saveComments(){
        val commentContent = binding.etMessage.text.toString()
        val createdAt = System.currentTimeMillis().toString()
        val updatedAt = System.currentTimeMillis().toString()
        val username = "Bridget"

        val comments = Comments(
            0, commentContent ,createdAt ,updatedAt,"", username,commentContent,""
        )
        commentsViewModel.saveComments(comments)
    }


}