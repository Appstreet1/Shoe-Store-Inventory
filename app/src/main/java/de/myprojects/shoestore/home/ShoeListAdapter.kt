package de.myprojects.shoestore.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.myprojects.shoestore.R
import de.myprojects.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListAdapter(private val shoeList: ArrayList<Shoe> = ArrayList()
) : RecyclerView.Adapter<ShoeListAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shoe_list_item, parent, false)
        return ShoeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.update(shoeList[position])
    }

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun update(shoe: Shoe) = with(itemView) {

            shoe_list_name.text = shoe._name
            shoe_list_company.text = shoe._company
            shoe_list_size.text = shoe._price

        }
    }

    fun setData(list: List<Shoe>) {
        shoeList.clear()
        shoeList.addAll(list)
        notifyDataSetChanged()
    }
}