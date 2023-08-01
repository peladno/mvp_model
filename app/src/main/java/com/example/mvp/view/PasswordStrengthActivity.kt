package com.example.mvp.view

import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.mvp.interfaces.PasswordStrengthView
import com.example.mvp.presenter.PasswordStrengthPresenter
import com.example.mvp.R
import com.example.mvp.databinding.ActivityPasswordStrengthBinding

class PasswordStrengthActivity : AppCompatActivity(), PasswordStrengthView {

    private lateinit var presenter: PasswordStrengthPresenter
    private lateinit var binding: ActivityPasswordStrengthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordStrengthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        presenter = PasswordStrengthPresenter(this)

        binding.passwordEditText.addTextChangedListener {
            val password = it?.toString() ?: ""
            presenter.onPasswordChanged(password)
        }

    }

    override fun updatePasswordStrength(strength: Int) {
        when {
            strength < 30 -> setStrengthTextColors(Color.RED, Color.BLACK, Color.BLACK)
            strength < 70 -> setStrengthTextColors(
                Color.BLACK,
                Color.rgb(255, 165, 0),
                Color.BLACK
            ) // Orange
            else -> setStrengthTextColors(Color.BLACK, Color.BLACK, Color.GREEN)
        }
    }

    private fun setStrengthTextColors(weakColor: Int, mediumColor: Int, strongColor: Int) {
        binding.weakTextView.setTextColor(weakColor)
        binding.mediumTextView.setTextColor(mediumColor)
        binding.strongTextView.setTextColor(strongColor)
    }


}