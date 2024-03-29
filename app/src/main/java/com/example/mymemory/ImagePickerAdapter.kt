package com.example.mymemory

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymemory.models.BoardSize
import kotlin.math.min

class ImagePickerAdapter(
    private val context: Context,
    private val imageUris: List<Uri>,
    private val boardSize: BoardSize,
    private val imageClickListener: ImageClickListener
) : RecyclerView.Adapter<ImagePickerAdapter.ViewHolder>() {

    interface ImageClickListener {
        fun onPlaceHolderClicked()
    }

    companion object {
        private const val MARGIN_SIZE = 10
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImagePickerAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_image, parent, false)
        val cardWidth = parent.width / boardSize.getWidth() - 2 * MARGIN_SIZE
        val cardHeight = parent.height / boardSize.getHeight() - 2 * MARGIN_SIZE
        val cardSideLength = min(cardWidth, cardHeight)

        val layoutParams = view.findViewById<ImageView>(R.id.ivCustonImage).layoutParams
        layoutParams.height = cardSideLength
        layoutParams.width = cardSideLength
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = boardSize.getNumPairs()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position < imageUris.size) {
            holder.bind(imageUris[position])
        } else {
            holder.bind()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivCustomImage = itemView.findViewById<ImageView>(R.id.ivCustonImage)

        fun bind(uri: Uri) {
            ivCustomImage.setImageURI(uri)
            ivCustomImage.setOnClickListener(null)
        }

        fun bind() {
            ivCustomImage.setOnClickListener {
                imageClickListener.onPlaceHolderClicked()
            }
        }

    }
}
