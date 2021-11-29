package com.sp.cleanarchitectureapp.features.presentation.list

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sp.cleanarchitectureapp.databinding.ListFragmentBinding
import com.sp.cleanarchitectureapp.features.domain.model.TaskList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private val viewModel by viewModels<ListViewModel>()
    private var _binding: ListFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _listAdapter = ListAdapter(object : ListAdapter.OnTodItemOnClickListener {
        override fun onItemClick(taskList: TaskList) {
            taskList.title?.let {
                _binding?.todoTextInputEditText?.setText(it)
                _binding?.todoTextInputEditText?.tag = taskList.taskListId
            }
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initializeUI()
        return root
    }

    private fun initializeUI() {

        _binding?.todosRecyclerView?.adapter = _listAdapter

        viewModel.todos.observe(viewLifecycleOwner) {
            _listAdapter.taskListList = it
        }

        _binding?.addFloatingActionButton?.setOnClickListener {
           val id = _binding?.todoTextInputEditText?.tag as Int?

            viewModel.addTodo(id, _binding?.todoTextInputEditText?.text?.toString(), Color.WHITE)
        }

        viewModel.getTodos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}