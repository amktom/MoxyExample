package ru.improvegroup.android.labs.myapplication.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.improvegroup.android.labs.myapplication.R

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = MainPresenter(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    override fun setBackgroundColor() {
        button_nextScreen.setBackgroundColor(Color.GREEN)
    }

    private fun initListeners() {
        button_nextScreen.setOnClickListener {
            mainPresenter.onButtonNextScreenClicked()
        }

        button_toast.setOnClickListener {
            mainPresenter.onButtonToastClicked()
        }

        button_textView.setOnClickListener {
            mainPresenter.onButtonTextViewChangeClicked()
        }
    }

    override fun loadNextScreen() {
        Intent(this, SecondActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeText(text: String) {
        text_simple.run { setText(text) }
    }
}
