package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.api.ApiInterface
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentData
import sakigake.mzaziconnect.mzaziconnectapplication.model.StudentsData

class ParentViewModel(private val apiInterface: ApiInterface) : ViewModel() {
    private val _parentData = MutableLiveData<ParentData?>(null)
    val parentData: LiveData<ParentData?> get() = _parentData

    private val _studentData = MutableLiveData<StudentsData?>(null)
    val studentData: LiveData<StudentsData?> get() = _studentData

    fun fetchParentData(schoolId: Int) {
        viewModelScope.launch {
            val response = apiInterface.getParentData(schoolId)
            if (response.isSuccessful) {
                val data = response.body()
                _parentData.value = data
            } else {
                // Handle API error
            }
        }
    }

    fun fetchStudentData(studentId: String) {
        viewModelScope.launch {
            val response = apiInterface.getStudentData(studentId)
            if (response.isSuccessful) {
                val data = response.body()
                _studentData.value = data
            } else {
                // Handle API error
            }
        }
    }
}