package de.myprojects.shoestore.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.myprojects.shoestore.R
import de.myprojects.shoestore.models.Shoe
import kotlinx.android.synthetic.main.list_item.view.*

class ShoeListAdapter(
    private val shoeList: ArrayList<Shoe> = ArrayList()
) : RecyclerView.Adapter<ShoeListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.update(shoeList[position])
    }

    class TaskViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(shoe: Shoe) = with(itemView) {
            shoe_name.text = shoe.getName()
            shoe_company.text = shoe.getCompany()
            shoe_size.text = shoe.getSize().toString()
        }
    }

    fun setData(list: MutableList<Shoe>) {
        shoeList.clear()
        shoeList.addAll(list)
        notifyDataSetChanged()
    }
}