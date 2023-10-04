package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.model.TeacherLoginResponse
import sakigake.mzaziconnect.mzaziconnectapplication.repository.TeacherLoginRepository

class TeacherLoginViewModel: ViewModel() {
    val teacherLoginRepo = TeacherLoginRepository()
    val regLiveData = MutableLiveData<TeacherLoginResponse>()
    val errLiveData = MutableLiveData<String>()

    fun teacherLogin(teacherLoginRequest: TeacherLoginRequest){
        viewModelScope.launch {
            val response = teacherLoginRepo.login(teacherLoginRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}