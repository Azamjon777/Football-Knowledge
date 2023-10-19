package com.daz.footballknowledge.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daz.footballknowledge.R
import com.daz.footballknowledge.presentation.model.Questions

class QuestionViewModel(private val context: Context) : ViewModel() {
    private val _questionsLiveData = MutableLiveData<List<Questions>>()
    val questionsLiveData: LiveData<List<Questions>> = _questionsLiveData

    fun loadQuestions(category: String) {
        val questions: List<Questions> = when (category) {
            context.getString(R.string.easy) -> createEasyFootballQuestions()
            context.getString(R.string.medium) -> createMediumFootballQuestions()
            context.getString(R.string.hard) -> createHardFootballQuestions()
            else -> createEasyFootballQuestions()
        }
        _questionsLiveData.postValue(questions)
    }

    private fun createEasyFootballQuestions(): List<Questions> {
        val footballQuestions = mutableListOf<Questions>()

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy1),
                listOf(
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.neymar),
                    context.getString(R.string.sergio_ramos)
                ),
                context.getString(R.string.lionel_messi)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy2),
                listOf(
                    context.getString(R.string._2006),
                    context.getString(R.string._2010),
                    context.getString(R.string._2014),
                    context.getString(R.string._2018)
                ),
                context.getString(R.string._2018)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy3),
                listOf(
                    context.getString(R.string.brazil),
                    context.getString(R.string.spain),
                    context.getString(R.string.portugal),
                    context.getString(R.string.argentina)
                ),
                context.getString(R.string.brazil)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy4),
                listOf(
                    context.getString(R.string._80_minutes),
                    context.getString(R.string._90_minutes),
                    context.getString(R.string._100_minutes),
                    context.getString(R.string._120_minutes)
                ),
                context.getString(R.string._90_minutes)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy5),
                listOf(
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.pel),
                    context.getString(R.string.diego_maradona)
                ),
                context.getString(R.string.pel)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy6),
                listOf(
                    context.getString(R.string.barcelona),
                    context.getString(R.string.liverpool),
                    context.getString(R.string.manchester_city),
                    context.getString(R.string.chelsea)
                ),
                context.getString(R.string.chelsea)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy7),
                listOf(
                    context.getString(R.string.spain),
                    context.getString(R.string.italy),
                    context.getString(R.string.france),
                    context.getString(R.string.germany)
                ),
                context.getString(R.string.spain)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy8),
                listOf(
                    context.getString(R.string.manchester_united),
                    context.getString(R.string.liverpool),
                    context.getString(R.string.arsenal),
                    context.getString(R.string.chelsea)
                ),
                context.getString(R.string.manchester_united)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy9),
                listOf(
                    context.getString(R.string.david_beckham),
                    context.getString(R.string.thierry_henry),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.ronaldinho)
                ),
                context.getString(R.string.david_beckham)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.easy10),
                listOf(
                    context.getString(R.string._1904),
                    context.getString(R.string._1926),
                    context.getString(R.string._1930),
                    context.getString(R.string._1950)
                ),
                context.getString(R.string._1904)
            )
        )

        return footballQuestions
    }

    private fun createMediumFootballQuestions(): List<Questions> {
        val footballQuestions = mutableListOf<Questions>()

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium1),
                listOf(
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.luka_modri),
                    context.getString(R.string.neymar)
                ),
                context.getString(R.string.lionel_messi)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium2),
                listOf(
                    context.getString(R.string.france),
                    context.getString(R.string.germany),
                    context.getString(R.string.italy),
                    context.getString(R.string.portugal)
                ),
                context.getString(R.string.italy)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium3),
                listOf(
                    context.getString(R.string.thierry_henry),
                    context.getString(R.string.alan_shearer),
                    context.getString(R.string.andy_cole),
                    context.getString(R.string.harry_kane)
                ),
                context.getString(R.string.alan_shearer)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium4),
                listOf(
                    context.getString(R.string.fc_barcelona),
                    context.getString(R.string.real_madrid_cf),
                    context.getString(R.string.manchester_united),
                    context.getString(R.string.ac_milan)
                ),
                context.getString(R.string.real_madrid_cf)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium5),
                listOf(
                    context.getString(R.string._1930),
                    context.getString(R.string._1950),
                    context.getString(R.string._1966),
                    context.getString(R.string._1978)
                ),
                context.getString(R.string._1930)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium6),
                listOf(
                    context.getString(R.string.neymar),
                    context.getString(R.string.kylian_mbapp),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.paul_pogba)
                ),
                context.getString(R.string.neymar)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium7),
                listOf(
                    context.getString(R.string.juninho_paulista),
                    context.getString(R.string.george_best),
                    context.getString(R.string.ronaldinho),
                    context.getString(R.string.roberto_baggio)
                ),
                context.getString(R.string.juninho_paulista)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium8),
                listOf(
                    context.getString(R.string.fc_barcelona),
                    context.getString(R.string.liverpool_fc),
                    context.getString(R.string.manchester_city),
                    context.getString(R.string.bayern_munich)
                ),
                context.getString(R.string.liverpool_fc)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.medium9),
                listOf(
                    context.getString(R.string.fifa_confederations_cup),
                    context.getString(R.string.fifa_world_cup),
                    context.getString(R.string.uefa_european_championship),
                    context.getString(R.string.fifa_club_world_cup)
                ),
                context.getString(R.string.fifa_club_world_cup)
            )
        )
        footballQuestions.add(
            Questions(
                context.getString(R.string.medium10),
                listOf(
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.robert_lewandowski),
                    context.getString(R.string.neymar)
                ),
                context.getString(R.string.lionel_messi)
            )
        )
        return footballQuestions
    }

    private fun createHardFootballQuestions(): List<Questions> {
        val footballQuestions = mutableListOf<Questions>()

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard1),
                listOf(
                    context.getString(R.string.real_madrid),
                    context.getString(R.string.fc_barcelona),
                    context.getString(R.string.bayern_munich),
                    context.getString(
                        R.string.ac_milan
                    )
                ),
                context.getString(R.string.real_madrid)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard2),
                listOf(
                    context.getString(R.string._24),
                    context.getString(R.string._28),
                    context.getString(R.string._32),
                    context.getString(R.string._48)
                ),
                context.getString(R.string._32)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard3),
                listOf(
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.robert_lewandowski),
                    context.getString(R.string.neymar)
                ),
                context.getString(R.string.robert_lewandowski)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard4),
                listOf(
                    context.getString(R.string._1878),
                    context.getString(R.string._1902),
                    context.getString(R.string._1920),
                    context.getString(R.string._1945)
                ),
                context.getString(R.string._1878)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard5),
                listOf(
                    context.getString(R.string.miroslav_klose),
                    context.getString(R.string.pel),
                    context.getString(R.string.gerd_m_ller),
                    context.getString(R.string.ronaldo)
                ),
                context.getString(R.string.miroslav_klose)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard6),
                listOf(
                    context.getString(R.string.argentina),
                    context.getString(R.string.brazil),
                    context.getString(R.string.france),
                    context.getString(R.string.germany)
                ),
                context.getString(R.string.france)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard7),
                listOf(
                    context.getString(R.string.lionel_messi),
                    context.getString(R.string.cristiano_ronaldo),
                    context.getString(R.string.kylian_mbapp),
                    context.getString(R.string.gianluigi_donnarumma)
                ),
                context.getString(R.string.gianluigi_donnarumma)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard8),
                listOf(
                    context.getString(R.string._3),
                    context.getString(R.string._4),
                    context.getString(R.string._5),
                    context.getString(R.string._6)
                ),
                context.getString(R.string._4)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard9),
                listOf(
                    context.getString(R.string.manchester_city),
                    context.getString(R.string.liverpool),
                    context.getString(R.string.chelsea),
                    context.getString(R.string.arsenal)
                ),
                context.getString(R.string.manchester_city)
            )
        )

        footballQuestions.add(
            Questions(
                context.getString(R.string.hard10),
                listOf(
                    context.getString(R.string._1st),
                    context.getString(R.string._2nd),
                    context.getString(R.string._3rd),
                    context.getString(R.string._4th)
                ),
                context.getString(R.string._1st)
            )
        )

        return footballQuestions
    }
}

