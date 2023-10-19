package com.daz.footballknowledge.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.daz.footballknowledge.R
import com.daz.footballknowledge.databinding.FragmentQuestionBinding
import com.daz.footballknowledge.presentation.model.QuestionCategory
import com.daz.footballknowledge.presentation.model.Questions

class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private lateinit var currentQuestion: Questions
    private lateinit var categoryModel: QuestionCategory
    private var correctAnswers: Int = 0
    private var gameEnded = false

    private val currentQuestionIndex = MutableLiveData(0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryModel =
            (requireArguments().getSerializable(ARG_CATEGORY_MODEL) as? QuestionCategory)!!

        currentQuestionIndex.observe(viewLifecycleOwner) { newIndex ->
            currentQuestion = categoryModel.list[newIndex]
            updateQuestion()
        }

        currentQuestion = categoryModel.list[currentQuestionIndex.value ?: 0]
        updateQuestion()

        if (!gameEnded) {
            binding.answerOption1.setOnClickListener { checkAnswer(currentQuestion.answers[0]) }
            binding.answerOption2.setOnClickListener { checkAnswer(currentQuestion.answers[1]) }
            binding.answerOption3.setOnClickListener { checkAnswer(currentQuestion.answers[2]) }
            binding.answerOption4.setOnClickListener { checkAnswer(currentQuestion.answers[3]) }
        }
    }

    private fun checkAnswer(selectedAnswer: String) {
        if (selectedAnswer == currentQuestion.correctAnswer) {
            correctAnswers++
        }

        val newIndex = currentQuestionIndex.value ?: 0
        if (newIndex < categoryModel.list.size - 1) {
            currentQuestionIndex.value = newIndex + 1
        } else {
            gameEnded = true
            showGameResultDialog(correctAnswers, categoryModel.list.size)
        }
    }

    private fun updateQuestion() {
        binding.questionTextView.text = currentQuestion.questions
        val answerOptions = currentQuestion.answers
        binding.answerOption1.text = answerOptions[0]
        binding.answerOption2.text = answerOptions[1]
        binding.answerOption3.text = answerOptions[2]
        binding.answerOption4.text = answerOptions[3]
    }

    private fun showGameResultDialog(correctAnswers: Int, totalQuestions: Int) {
        val resultMessage =
            getString(R.string.correct_answers) + " $correctAnswers" + getString(R.string.from) + " $totalQuestions"

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder
            .setTitle(getString(R.string.game_results))
            .setMessage(resultMessage)
            .setPositiveButton(getString(R.string.restart)) { dialog, _ ->
                dialog.dismiss()
                val gameFragment = GameFragment.newInstance()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerGame, gameFragment)
                    .commit()
            }
            .setCancelable(false)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    companion object {
        private const val ARG_CATEGORY_MODEL = "category_model"

        fun newInstance(categoryModel: QuestionCategory): QuestionFragment {
            val fragment = QuestionFragment()
            val args = Bundle()
            args.putSerializable(ARG_CATEGORY_MODEL, categoryModel)
            fragment.arguments = args
            return fragment
        }
    }
}