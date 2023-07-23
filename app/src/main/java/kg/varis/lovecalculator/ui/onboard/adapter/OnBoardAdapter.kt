package kg.varis.lovecalculator.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.varis.lovecalculator.R
import kg.varis.lovecalculator.databinding.ItemOnboardBinding
import kg.varis.lovecalculator.model.OnBoardModel

class OnBoardAdapter(private val finishClick: () -> Unit, private val skip: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {


    private var arrayList = arrayListOf<OnBoardModel>(
        OnBoardModel(R.raw.animation_lkfmisf8),
        OnBoardModel(R.raw.animation_lkfmisf8),
        OnBoardModel(R.raw.animation_lkfmisf8),
        OnBoardModel(R.raw.animation_lkfmisf8)
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: OnBoardModel) {
            with(binding) {
                btnStart.isVisible = adapterPosition == arrayList.lastIndex
                btnStart.setOnClickListener {
                    finishClick()
                }
                btnNext.isVisible = adapterPosition != arrayList.size - 1
                btnNext.setOnClickListener {
                    skip()
                }
            }
        }
    }
}