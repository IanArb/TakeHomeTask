package com.ianarbuckle.codingproject.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.*
import com.ianarbuckle.codingproject.databinding.HomeListItemBinding

/**
 * Created by Ian Arbuckle on 17/11/2018.
 *
 */
class HomeAdapter(private val results: List<Customer>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: HomeListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.home_list_item, parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if(results.isEmpty()) {
            return 0
        }
        return results.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val items = results[position]
        holder.binding.customer = items
    }

    inner class HomeViewHolder(val binding: HomeListItemBinding) : RecyclerView.ViewHolder(binding.root)
}