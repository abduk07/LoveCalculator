package kg.varis.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.varis.lovecalculator.remote.LoveModel

class LoveViewModel : ViewModel() {

    var repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }

}