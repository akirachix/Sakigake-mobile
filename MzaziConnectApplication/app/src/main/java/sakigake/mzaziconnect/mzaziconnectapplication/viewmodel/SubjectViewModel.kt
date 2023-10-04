package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.SubjectData
import sakigake.mzaziconnect.mzaziconnectapplication.repository.SubjectRepo

class SubjectViewModel : ViewModel() {
    var subjectsRepo = SubjectRepo()
    val subjectsLiveData = MutableLiveData<List<SubjectData>>()
    val errorLiveData = MutableLiveData<String>()
    val subjects = mutableListOf<SubjectData>()

    init {
        fetchSubjects()
    }

    fun fetchSubjects() {
        viewModelScope.launch {
            val response = subjectsRepo.getSubjects()

            if (response.isSuccessful) {
                val assignLists = response.body() ?: emptyList()

                subjectsLiveData.postValue(assignLists as List<SubjectData>)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}