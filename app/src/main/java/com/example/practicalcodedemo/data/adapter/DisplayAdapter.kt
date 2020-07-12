package com.example.practicalcodedemo.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalcodedemo.R
import com.example.practicalcodedemo.data.model.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout_display.view.*

class DisplayAdapter(var mContext:Context):RecyclerView.Adapter<DisplayAdapter.ViewHolder>() {
    var mList:List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_layout_display, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = mList[position]
        holder.bindView(item)
    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindView(item:Post) {
            Picasso.get()
                .load(item.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imageView)

            itemView.text_view_name.text = item.name
            itemView.text_view_stars.text = item.stars.toString()
            itemView.text_view_branch.text = item.forks.toString()

        }

    }

    fun setData(list:List<Post>) {
        mList = list
        notifyDataSetChanged()
    }


}