package ru.improvegroup.android.labs.myapplication.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun loadNextScreen()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(message : String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun changeText(text: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setBackgroundColor()
}