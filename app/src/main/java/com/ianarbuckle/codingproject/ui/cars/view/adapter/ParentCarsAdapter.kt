package com.ianarbuckle.codingproject.ui.cars.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ianarbuckle.codingproject.R
import com.ianarbuckle.codingproject.data.VehAvail
import com.ianarbuckle.codingproject.data.VehVendorAvail
import com.ianarbuckle.codingproject.databinding.CarsListItemBinding
import com.ianarbuckle.codingproject.ui.carsdetail.CarsDetailActivity

/**
 * Created by Ian Arbuckle on 16/03/2019.
 *
 */
class ParentCarsAdapter(private val context: Context, private val results: List<VehVendorAvail>)
    : RecyclerView.Adapter<ParentCarsAdapter.CarsViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    private val clickListener = { vehAvail: VehAvail -> vehicleItemClicked(vehAvail)}

    private fun vehicleItemClicked(vehAvail: VehAvail) {
        val intent = Intent(context, CarsDetailActivity::class.java)
        intent.putExtra("vehicle", vehAvail)
        context.startActivity(intent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CarsListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.cars_list_item, parent, false)
        return CarsViewHolder(binding)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val item = results[position]
        holder.binding.car = item

        val childLayoutManager = LinearLayoutManager(holder.binding.childRecyclerView.context, RecyclerView.VERTICAL, false)

        childLayoutManager.initialPrefetchItemCount = 4

        holder.binding.childRecyclerView.apply {
            layoutManager = childLayoutManager
            val sortVehiclesByPrice = item.vehAvails.sortedBy { it.totalCharge.rateTotalAmount.toDouble() }
            adapter = ChildCarsAdapter(sortVehiclesByPrice, clickListener)
            setRecycledViewPool(viewPool)
            val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    inner class CarsViewHolder(val binding: CarsListItemBinding) : RecyclerView.ViewHolder(binding.root)


}