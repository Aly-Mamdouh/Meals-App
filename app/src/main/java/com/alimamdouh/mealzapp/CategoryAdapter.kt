package com.alimamdouh.mealzapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alimamdouh.domain.entity.Category
import com.alimamdouh.mealzapp.databinding.CategoryLayoutBinding
import com.bumptech.glide.Glide

class CategoryAdapter() : ListAdapter<Category, CategoryAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: Category) {
            itemBinding.categoryNameTv.text = category.strCategory
            itemBinding.categoryDesTv.text = category.strCategoryDescription
            Glide.with(itemBinding.root.context).load(category.strCategoryThumb).into(itemBinding.categoryIv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem == newItem
        }
    }
}
