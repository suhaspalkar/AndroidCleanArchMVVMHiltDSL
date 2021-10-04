package com.sp.cleanarchitectureapp.features.presentation.todos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sp.cleanarchitectureapp.databinding.HolderTodoItemBinding
import com.sp.cleanarchitectureapp.features.domain.model.Todo
import kotlin.properties.Delegates


class TodoAdapter(val onTodItemOnClickListener: OnTodItemOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var todoList: List<Todo> by Delegates.observable(emptyList()) { _, _, _ ->

        notifyItemRangeChanged(0, todoList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPostBinding =
            HolderTodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(holderPostBinding)
    }

    override fun getItemCount(): Int = todoList.size

    private fun getItem(position: Int) = todoList[position]


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).onBind(getItem(position))
    }

    inner class PostViewHolder(private val holderPostBinding: HolderTodoItemBinding) :
        RecyclerView.ViewHolder(holderPostBinding.root) {

        fun onBind(todo: Todo) {
            with(holderPostBinding) {
                todoTitleTextView.text = todo.title
            }
            
            itemView.setOnClickListener {
                onTodItemOnClickListener.onItemClick(todo)
            }
        }
    }

    interface OnTodItemOnClickListener {
        fun onItemClick(todo: Todo)
    }

}