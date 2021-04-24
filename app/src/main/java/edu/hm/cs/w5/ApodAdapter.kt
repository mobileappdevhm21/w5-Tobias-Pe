package edu.hm.cs.w5

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.apod_view_holder.view.*

class ApodAdapter(var images: List<ApodImage>) :
    RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {

    class ApodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(image: ApodImage) {
            /* load image */
            Glide.with(itemView.context)
                .load(image.hdurl)
                .into(itemView.imageView)
            itemView.imageView.contentDescription = image.title
            /* set title & date */
            itemView.title_textView.text = image.title
            itemView.date_textView.text = image.date
            /* add onClickListener */
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(image.url))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.apod_view_holder, parent, false)
        return ApodViewHolder(itemView)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) =
        holder.bind(images.get(position))
}