package kg.varis.lovecalculator

import android.os.Bundle
import android.provider.Telephony.TextBasedSmsColumns.BODY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.varis.lovecalculator.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAccept()
    }

    private fun dataAccept() {
        with(binding){
            val body = arguments?.getSerializable(FirstFragment.BODY) as LoveModel
            body.let {
                tvFirstName.text = it.firstName
                tvSecondName.text = it.secondName
                percent.text = it.percentage
                tvResult.text = it.result
            }
        }
    }
}