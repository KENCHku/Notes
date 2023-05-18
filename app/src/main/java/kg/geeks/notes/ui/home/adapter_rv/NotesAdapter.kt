package kg.geeks.notes.ui.home.adapter_rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geeks.notes.data.model.Notes
import kg.geeks.notes.databinding.ItemNotesRvBinding

class NotesAdapter(
    val list: ArrayList<Notes>,
    /*val onItemClicked: (position: Int) -> Unit*/
) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.onBind()
        holder.itemView.setOnClickListener{
           // onItemClicked(position)
        }
    }

    override fun getItemCount() = list.size

    inner class NotesViewHolder(val binding: ItemNotesRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            with(binding) {
                val item = list[adapterPosition]
                tvTitleItem.text = item.title
                tvSubtitleItem.text = item.subtitle
            }
        }
    }
}