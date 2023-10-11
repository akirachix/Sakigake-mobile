package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginRequest
import sakigake.mzaziconnect.mzaziconnectapplication.model.ParentLoginResponse
import sakigake.mzaziconnect.mzaziconnectapplication.repository.ParentLoginRepository

class ParentLoginViewModel: ViewModel() {
    var parentLoginRepo = ParentLoginRepository()
    val regLiveData = MutableLiveData<ParentLoginResponse>()
    val errLiveData = MutableLiveData<String>()

    fun parentLogin(parentLoginRequest: ParentLoginRequest){
        viewModelScope.launch {
            val response = parentLoginRepo.loginParent(parentLoginRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
