package com.sp.cleanarchitectureapp.features.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sp.cleanarchitectureapp.databinding.HolderTodoItemBinding
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import kotlin.properties.Delegates


class ListAdapter(val onTodItemOnClickListener: OnTodItemOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var taskListList: List<TaskList> by Delegates.observable(emptyList()) { _, _, _ ->

        notifyItemRangeChanged(0, taskListList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPostBinding =
            HolderTodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PostViewHolder(holderPostBinding)
    }

    override fun getItemCount(): Int = taskListList.size

    private fun getItem(position: Int) = taskListList[position]


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).onBind(getItem(position))
    }

    inner class PostViewHolder(private val holderPostBinding: HolderTodoItemBinding) :
        RecyclerView.ViewHolder(holderPostBinding.root) {

        fun onBind(taskList: TaskList) {
            with(holderPostBinding) {
                todoTitleTextView.text = taskList.title
            }
            
            itemView.setOnClickListener {
                onTodItemOnClickListener.onItemClick(taskList)
            }
        }
    }

    interface OnTodItemOnClickListener {
        fun onItemClick(taskList: TaskList)
    }

}