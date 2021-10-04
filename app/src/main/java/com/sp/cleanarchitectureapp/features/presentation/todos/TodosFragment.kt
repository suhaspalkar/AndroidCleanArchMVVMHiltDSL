package com.sp.cleanarchitectureapp.features.presentation.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sp.cleanarchitectureapp.databinding.TodosFragmentBinding
import com.sp.cleanarchitectureapp.features.domain.model.Todo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodosFragment : Fragment() {
    private val viewModel by viewModels<TodosViewModel>()

//    private val viewModel: TodosViewModel by viewModels()
    private var _binding: TodosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var _todoAdapter = TodoAdapter(object : TodoAdapter.OnTodItemOnClickListener {
        override fun onItemClick(todo: Todo) {
            todo.title?.let {
                _binding?.todoTextInputEditText?.setText(it)
            }
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TodosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initializeUI()
        return root
    }

    private fun initializeUI() {

        _binding?.todosRecyclerView?.adapter = _todoAdapter

        viewModel.todos.observe(viewLifecycleOwner) {
            _todoAdapter.todoList = it
        }

        _binding?.addFloatingActionButton?.setOnClickListener {
            viewModel.addTodo(_binding?.todoTextInputEditText?.text?.toString())
        }

        viewModel.getTodos()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}