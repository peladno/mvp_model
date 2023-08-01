package com.example.mvp.presenter

import com.example.mvp.interfaces.PasswordStrengthView
import com.example.mvp.model.PasswordStrengthCalculator

class PasswordStrengthPresenter(private val view: PasswordStrengthView) {

    fun onPasswordChanged(password: String) {
        val strength = PasswordStrengthCalculator.calculateStrength(password)
        view.updatePasswordStrength(strength)
    }
}