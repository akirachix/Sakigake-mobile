package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.Comments
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.repository.CommentsRepository
import sakigake.mzaziconnect.mzaziconnectapplication.repository.SubjectRepository

class CommentsViewModel :ViewModel() {

    var commentsRepo = CommentsRepository()
    val commentsLiveData = MutableLiveData<List<Comments>>()
    val errorLiveData = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun fetchComments():LiveData<List<Comments>>{
        return commentsRepo.fetchComments()
    }


    fun saveComments(comment :Comments){
        viewModelScope.launch {
            commentsRepo.saveComment(comment)
        }


    }

}