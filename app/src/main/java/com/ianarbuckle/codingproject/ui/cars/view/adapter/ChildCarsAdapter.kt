package com.ianarbuckle.codingproject.ui.cars.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.VehAvail
import com.ianarbuckle.codingproject.databinding.CarsChildItemBinding
import kotlinx.android.synthetic.main.cars_child_item.view.*

/**
 * Created by Ian Arbuckle on 17/03/2019.
 *
 */
class ChildCarsAdapter(private val availableVehicles: List<VehAvail>,
                       private val clickListener: (VehAvail) -> Unit) : RecyclerView.Adapter<ChildCarsAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CarsChildItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cars_child_item, parent, false)
        return ChildViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return availableVehicles.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val item = availableVehicles[position]
        holder.binding.vehicleAvail = item
        holder.bindClickListener(item, clickListener)
    }

    inner class ChildViewHolder(val binding: CarsChildItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindClickListener(vehAvail: VehAvail, clickListener: (VehAvail) -> Unit) = binding.root.viewMoreButton.setOnClickListener { clickListener(vehAvail) }
    }
}
