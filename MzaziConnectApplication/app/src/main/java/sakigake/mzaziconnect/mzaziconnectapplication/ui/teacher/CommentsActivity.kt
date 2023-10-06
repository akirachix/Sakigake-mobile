package sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.ActivityCommentsBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.MessageDetails
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.AssignmentView
import sakigake.mzaziconnect.mzaziconnectapplication.ui.parent.MessageAdapter

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerview: RecyclerView =binding.recyclerView
        val messages = listOf(
            MessageDetails("Karina ", "https://res.cloudinary.com/dtu8pkzkp/image/upload/v1695649064/fulqzp1eplyg08ho0vkm.png", "good work" ),
            MessageDetails("Maria ", "https://res.cloudinary.com/dtu8pkzkp/image/upload/v1695649064/fulqzp1eplyg08ho0vkm.png", "good work" ),
            MessageDetails("Vandar ", "https://res.cloudinary.com/dtu8pkzkp/image/upload/v1695649064/fulqzp1eplyg08ho0vkm.png", "good work" ),
            MessageDetails("Nicky  ", "https://res.cloudinary.com/dtu8pkzkp/image/upload/v1695649064/fulqzp1eplyg08ho0vkm.png", "good work" ),
        )
        val adapter= MessageAdapter(messages)
        recyclerview.adapter=adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        binding.ivbackmssg.setOnClickListener {
            startActivity(Intent(this, AssignmentView::class.java))
        }
        binding.ivsend.setOnClickListener {
            startActivity(Intent(this@CommentsActivity, CommentsActivity::class.java ))
        }
        binding.ivhome.setOnClickListener {
            startActivity(Intent(this, NavActivity::class.java))
        }
    }
}