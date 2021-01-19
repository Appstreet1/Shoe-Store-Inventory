package de.myprojects.shoestore.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.myprojects.shoestore.R
import de.myprojects.shoestore.models.Shoe

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

        }
    }

    fun setData(list: List<Shoe>) {
        shoeList.clear()
        shoeList.addAll(list)
        notifyDataSetChanged()
    }
}