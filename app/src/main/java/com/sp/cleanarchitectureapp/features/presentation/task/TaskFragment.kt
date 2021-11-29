package com.sp.cleanarchitectureapp.features.presentation.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sp.cleanarchitectureapp.databinding.TaskFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment : Fragment() {
    private val viewModel by viewModels<TaskViewModel>()

    private var _binding: TaskFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TaskFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.message

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}