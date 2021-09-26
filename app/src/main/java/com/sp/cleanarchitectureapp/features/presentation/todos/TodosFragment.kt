package com.sp.cleanarchitectureapp.features.presentation.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sp.cleanarchitectureapp.databinding.TodosFragmentBinding

class TodosFragment : Fragment() {

    private lateinit var viewModel: TodosViewModel
    private var _binding: TodosFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(TodosViewModel::class.java)

        _binding = TodosFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.message

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}