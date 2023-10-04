package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel
import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.Shops
import sakigake.mzaziconnect.mzaziconnectapplication.repository.ShopRepository

class ShopsViewModel:ViewModel() {
    var shopRepo = ShopRepository()
    val shopLiveData = MutableLiveData<List<Shops>>()
    val errorLiveData = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun fetchShops(){
        viewModelScope.launch {
            val response = shopRepo.getShops()
            if (response.isSuccessful){
             val shopLists =response.body()?: emptyList()
                shopLiveData.postValue(shopLists as List<Shops>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}

