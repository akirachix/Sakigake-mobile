import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentData
import sakigake.mzaziconnect.mzaziconnectapplication.model.AssignmentsData
import sakigake.mzaziconnect.mzaziconnectapplication.repository.AssignmentRepo

class AssignmentViewModel: ViewModel() {
    var postsRepo = AssignmentRepo()
    val postsLiveData = MutableLiveData<List<AssignmentsData>>()
    val errorLiveData = MutableLiveData<String>()


    fun fetchAssign() {
        viewModelScope.launch {
            val response = postsRepo.getAssignment()

            if (response.isSuccessful) {
                val assignLists = response.body() ?: emptyList()

                postsLiveData.postValue(assignLists as List<AssignmentsData>)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}