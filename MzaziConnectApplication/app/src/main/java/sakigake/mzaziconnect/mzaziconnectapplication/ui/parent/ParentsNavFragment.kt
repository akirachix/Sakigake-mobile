package sakigake.mzaziconnect.mzaziconnectapplication.ui.parent

import TopicViewModel
import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sakigake.mzaziconnect.mzaziconnectapplication.R
import sakigake.mzaziconnect.mzaziconnectapplication.databinding.FragmentParentsNavBinding
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import sakigake.mzaziconnect.mzaziconnectapplication.ui.AccountSettingsActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.LogoutActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectAssignmentActivity
import sakigake.mzaziconnect.mzaziconnectapplication.ui.teacher.SubjectsAdapter
import sakigake.mzaziconnect.mzaziconnectapplication.viewmodel.SubjectsViewModel
import java.util.Locale

class ParentsNavFragment : Fragment() {
    private var _binding: FragmentParentsNavBinding? = null
    private val binding get() = _binding!!
    lateinit var myDialog: Dialog
    private val subjectsViewModel: SubjectsViewModel by viewModels()
    private lateinit var subjectsAdapter: SubjectsAdapter
    private val assignViewModel: TopicViewModel by viewModels()
    private var previousAssignList = emptyList<TopicsData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParentsNavBinding.inflate(inflater, container, false)
        val view = binding.root
        myDialog = Dialog(requireContext())

        // Initialize RecyclerView and Adapter
        val recyclerView = binding.rvAssignmentTopics
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager
        subjectsAdapter = SubjectsAdapter(emptyList()) { selectedSubject ->
            val intent = Intent(requireContext(), SubjectAssignmentActivity::class.java)
            intent.putExtra("Subject Name", selectedSubject.subjectName)
            intent.putExtra("SubjectTeacherName", selectedSubject.teacher)
            startActivity(intent)
        }
        recyclerView.adapter = subjectsAdapter

        fetchingAssign()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnassign.setOnClickListener {
//            startActivity(Intent(requireContext(), SubjectAssignmentActivity::class.java))
//        }

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvAssignmentTopics.layoutManager = layoutManager

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                val intent = Intent(requireContext(), AccountSettingsActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.nav_logout -> {
                val intent = Intent(requireContext(), LogoutActivity::class.java)
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun fetchingAssign() {
        assignViewModel.fetchAssign()
        assignViewModel.assignLiveData.observe(
            viewLifecycleOwner,
            Observer { assignmentList ->
                val sortedList = assignmentList.sortedByDescending { it.due_date }
                val newAssignments =
                    assignmentList.filter { assignment -> !previousAssignList.contains(assignment) }

                if (newAssignments.isNotEmpty()) {
                    createNotification(newAssignments)
                }

                previousAssignList = assignmentList

                val postsAdapter =
                    SubjectChoosenAssignmentsAdapter(sortedList ?: emptyList(), requireContext())
                binding.rvAssignmentTopics.layoutManager = LinearLayoutManager(requireContext())
                binding.rvAssignmentTopics.adapter = postsAdapter
            })

        assignViewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
        })
    }

    private fun createNotification(newAssignments: List<TopicsData>) {
        if (newAssignments.isNotEmpty()) {
            val mostRecentAssignment = newAssignments.last()

            val sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + requireContext().packageName + "/raw/quite_impressed.mp3")

            val mBuilder = NotificationCompat.Builder(requireContext(), "10001")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("MzaziConnect")
                .setSound(sound)
                .setContentText("New Assignment: ${mostRecentAssignment.topic.capitalize(Locale.ROOT)}")



            val mNotificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()

                val importance = NotificationManager.IMPORTANCE_HIGH
                val notificationChannel = NotificationChannel(
                    NotificationActivity.NOTIFICATION_CHANNEL_ID,
                    "NOTIFICATION_CHANNEL_NAME",
                    importance
                )
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.RED
                notificationChannel.enableVibration(true)
                notificationChannel.vibrationPattern =
                    longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
                notificationChannel.setSound(sound, audioAttributes)
                mBuilder.setChannelId(NotificationActivity.NOTIFICATION_CHANNEL_ID)
                mNotificationManager.createNotificationChannel(notificationChannel)
            }

            mNotificationManager.notify(mostRecentAssignment.subject.hashCode(), mBuilder.build())
        }

    }

}

