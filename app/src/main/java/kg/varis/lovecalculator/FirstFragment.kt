package kg.varis.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kg.varis.lovecalculator.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendData()
    }

    private fun sendData() {
        with(binding) {
            btnCalculate.setOnClickListener {

                viewModel.getLiveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(
                        this@FirstFragment,
                        { loveModel ->
                            Log.e("shalala", "sendData:$loveModel ")
                            findNavController().navigate(
                                R.id.secondFragment,
                                bundleOf(BODY to loveModel)
                            )
                        }
                    )

//                RetrofitService.api.getPercentAge(
//                    etFirstName.text.toString(),
//                    etSecondName.text.toString()
//                ).enqueue(object : Callback<LoveModel> {
//
//                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                        Log.e("shalala", "onResponse: ${response.body()}")
//                        findNavController().navigate(
//                            R.id.secondFragment,
//                            bundleOf(BODY to response.body())
//                        )
//                    }
//
//                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                        Log.e("shalala", "onFailure: ${t.message}")
//                        Toast.makeText(requireContext(), "Not Complete", Toast.LENGTH_SHORT).show()
//                    }
//                })
            }
        }
    }

    companion object {
        const val BODY = "body.response.key"
    }
}
