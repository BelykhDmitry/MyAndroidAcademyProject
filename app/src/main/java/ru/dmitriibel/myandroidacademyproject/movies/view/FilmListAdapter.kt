package ru.dmitriibel.myandroidacademyproject.movies.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.dmitriibel.myandroidacademyproject.R

class FilmListAdapter(private val itemClickListener: (Int) -> Unit) : ListAdapter<FilmData, FilmItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
        return FilmItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false))
    }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int) {
        currentList.getOrNull(position)?.let {
            holder.apply {
                tvAgeRestriction.text = it.ageRestriction
                cbLiked.isChecked = it.liked
                tvReviewsCount.text = it.reviewsCount
                tvTitle.text = it.title
                tvLength.text = it.length
                holder.itemView.setOnClickListener {
                    itemClickListener(adapterPosition)
                }
            }
        }
    }

    interface ItemClickListener {

        fun onItemClicked(position: Int)
    }
}

// TODO: image url, move to another package
data class FilmData(
        val title: String,
        val length: String,
        val ageRestriction: String,
        val liked: Boolean,
        val reviewsCount: String
)

class FilmItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvAgeRestriction: AppCompatTextView = itemView.findViewById(R.id.tv_film_restriction)
    val cbLiked: AppCompatCheckBox = itemView.findViewById(R.id.cb_like)
    // TODO: ratingbar
    val tvReviewsCount: AppCompatTextView = itemView.findViewById(R.id.tv_reviews_count)
    val tvTitle: AppCompatTextView = itemView.findViewById(R.id.tv_film_title)
    val tvLength: AppCompatTextView = itemView.findViewById(R.id.tv_film_duration)
}

class DiffCallback : DiffUtil.ItemCallback<FilmData>() {
    override fun areItemsTheSame(oldItem: FilmData, newItem: FilmData): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: FilmData, newItem: FilmData): Boolean {
        return oldItem == newItem
    }
}