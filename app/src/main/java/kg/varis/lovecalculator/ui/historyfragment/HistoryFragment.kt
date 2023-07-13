package kg.varis.lovecalculator.ui.historyfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.varis.lovecalculator.R
import kg.varis.lovecalculator.databinding.FragmentHistoryBinding
import kg.varis.lovecalculator.ui.historyfragment.adapter.HistoryAdapter
import kg.varis.lovecalculator.ui.historyfragment.viewmodel.HistoryViewModel

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {
    private val binding: FragmentHistoryBinding by viewBinding(FragmentHistoryBinding::bind)
    private val viewModel: HistoryViewModel by viewModels()
    private var adapter = HistoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addList()
    }

    private fun addList() {
        val list = viewModel.getData()
        binding.recyclerView.adapter = adapter
        adapter.getList(list)
    }
}