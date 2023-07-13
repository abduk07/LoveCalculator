package kg.varis.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.varis.lovecalculator.model.LoveModel
import kg.varis.lovecalculator.repository.Repository
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }
    fun insert (loveModel: LoveModel){
        repository.insert(loveModel)
    }

}