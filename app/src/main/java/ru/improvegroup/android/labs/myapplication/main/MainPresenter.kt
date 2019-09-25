package ru.improvegroup.android.labs.myapplication.main

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter constructor(
    val id: Int
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setBackgroundColor()
    }

    fun onButtonNextScreenClicked(){
        viewState.loadNextScreen()
    }

    fun onButtonToastClicked() {
        viewState.showToast("lol kek chebureck")
    }

    fun onButtonTextViewChangeClicked() {
        viewState.changeText("New Text")
    }

}