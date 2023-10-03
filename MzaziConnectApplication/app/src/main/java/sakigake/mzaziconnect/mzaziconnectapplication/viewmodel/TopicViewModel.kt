import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.TopicsData
import sakigake.mzaziconnect.mzaziconnectapplication.repository.TopicRepository

class TopicViewModel: ViewModel()  {
    var topicRepo = TopicRepository()
    val assignLiveData = MutableLiveData<List<TopicsData>>()
    val errorLiveData = MutableLiveData<String>()

    fun fetchAssign() {
        viewModelScope.launch {
            val response = topicRepo.getAssignments()

            if (response.isSuccessful) {
                val assignLists = response.body() ?: emptyList()

                assignLiveData.postValue(assignLists as List<TopicsData>)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }


}
