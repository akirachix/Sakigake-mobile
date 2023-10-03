package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import android.annotation.SuppressLint
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
    fun fetchComments(){
        viewModelScope.launch {
            val response = commentsRepo.getComments()
            if (response.isSuccessful){
                val commentsLists =response.body()?: emptyList()
                commentsLiveData.postValue(commentsLists as List<Comments>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}