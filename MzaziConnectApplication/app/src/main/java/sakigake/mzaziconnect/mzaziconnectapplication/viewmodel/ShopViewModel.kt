package sakigake.mzaziconnect.mzaziconnectapplication.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sakigake.mzaziconnect.mzaziconnectapplication.model.ShopData
import sakigake.mzaziconnect.mzaziconnectapplication.repository.ShopRepo

class ShopViewModel:ViewModel() {
    var shopRepo = ShopRepo()
    val shopLiveData = MutableLiveData<List<ShopData>>()
    val errorLiveData = MutableLiveData<String>()

    init {
        fetchShops()
    }

    fun fetchShops() {
        viewModelScope.launch {
            val response = shopRepo.getShop()

            if (response.isSuccessful) {
                val shopLists = response.body() ?: emptyList()

                shopLiveData.postValue(shopLists as List<ShopData>)
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }



}