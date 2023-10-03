package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.model.Subjects
import sakigake.mzaziconnect.mzaziconnectapplication.repository.ShopRepository
import sakigake.mzaziconnect.mzaziconnectapplication.repository.SubjectRepository

class SubjectsViewModel:ViewModel() {
    var subjectRepo = SubjectRepository()
    val subjectsLiveData = MutableLiveData<List<Subjects>>()
    val errorLiveData = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun fetchSubjects(){
        viewModelScope.launch {
            val response = subjectRepo.getSubjects()
            if (response.isSuccessful){
                val subjectsLists =response.body()?: emptyList()
                subjectsLiveData.postValue(subjectsLists as List<Subjects>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}