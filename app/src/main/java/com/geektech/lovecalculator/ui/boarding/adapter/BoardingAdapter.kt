package com.geektech.lovecalculator.ui.boarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.lovecalculator.data.model.OnBoard
import com.geektech.lovecalculator.databinding.ItemViewPagerBinding

class BoardingAdapter(val onItemClick:() -> Unit): RecyclerView.Adapter<BoardingAdapter.BoardingViewHolder>() {
    private var onBoardingList = arrayListOf(
        OnBoard("https://klike.net/uploads/posts/2022-05/1652775154_5.jpg", "Love calculator", "Вкрации ищи свою любовь и забивай только на англиском"),
        OnBoard("https://i.pinimg.com/736x/8b/56/f4/8b56f4d281a8fa029e3274df285dbd3f.jpg", "Ночной прогресс", "Здесь можешь провести не одну ночь в поиске свой любви"),
        OnBoard("https://www.imagetext.ru/pics_max/images_12815.jpeg", "Уже не знаю даже что здесь написать", "Лучше зови гулять чем сидеть в телфоне"),
        OnBoard("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTziCDEVKWRZKLKaOQ5Fxjx1yoSLsNZXVr-63uBuIRMS-7tw-bAhosZVHHT2sTnqZ7LP4M&usqp=CAU", "Конец", "Давай быстрей заходи")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardingViewHolder {
        return BoardingViewHolder(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    }

    override fun onBindViewHolder(holder: BoardingViewHolder, position: Int) {
        holder.bind(onBoardingList[position])
    }

    override fun getItemCount(): Int = onBoardingList.size
    inner class BoardingViewHolder(private val binding: ItemViewPagerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(onBoard:OnBoard){
            binding.btnStart.isVisible = adapterPosition == onBoardingList.lastIndex
            binding.ivPicture.load(onBoard.image)
            binding.tvTitle.text = onBoard.title
            binding.tvDescription.text = onBoard.description

            binding.btnStart.setOnClickListener{
                onItemClick()
            }
        }
    }
}