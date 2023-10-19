package com.daz.footballknowledge.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.daz.footballknowledge.R
import com.daz.footballknowledge.databinding.FragmentGameBinding
import com.daz.footballknowledge.presentation.model.QuestionCategory
import com.daz.footballknowledge.presentation.viewmodel.QuestionViewModel
import com.daz.footballknowledge.presentation.viewmodel.QuestionViewModelFactory

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var categories: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        categories = arrayOf(
            getString(R.string.easy),
            getString(R.string.medium),
            getString(R.string.hard)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategoryViews()
    }

    private fun initCategoryViews() {
        for (i in 0 until 3) {
            val categoryView = binding.categoryLayout.getChildAt(i) as AppCompatButton
            categoryView.text = categories[i]
            categoryView.setOnClickListener {
                val category = categories[i]
                openCategoryFragment(category)
            }
        }
    }

    private fun openCategoryFragment(category: String) {
        val factory = QuestionViewModelFactory(requireContext())
        val questionViewModel = ViewModelProvider(this, factory)[QuestionViewModel::class.java]

        questionViewModel.loadQuestions(category)

        questionViewModel.questionsLiveData.observe(viewLifecycleOwner) { questions ->
            val categoryModel = QuestionCategory(category, questions)
            val questionFragment = QuestionFragment.newInstance(categoryModel)

            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.add(
                R.id.fragmentContainerGame,
                questionFragment
            )
            fragmentTransaction.commit()
        }
    }


    companion object {
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }
}
