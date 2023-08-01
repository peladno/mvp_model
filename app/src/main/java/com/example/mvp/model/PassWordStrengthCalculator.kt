package com.example.mvp.model


object PasswordStrengthCalculator {

    fun calculateStrength(password: String): Int {
        val length = password.length
        var strength = 0

        // Si la contraseña tiene menos de 8 caracteres, considerarla débil
        if (length < 5) {
            strength += 10
        }

        // Si la contraseña tiene 8 o más caracteres, considerarla fuerte
        if (length >= 5) {
            strength += 30
        }

        // Si la contraseña tiene 12 o más caracteres, aumentar la fortaleza
        if (length >= 12) {
            strength += 30
        }

        // Verificar la presencia de letras mayúsculas, minúsculas y dígitos
        var hasUpperCase = false
        var hasLowerCase = false
        var hasDigit = false

        for (char in password) {
            if (char.isUpperCase()) {
                hasUpperCase = true
            } else if (char.isLowerCase()) {
                hasLowerCase = true
            } else if (char.isDigit()) {
                hasDigit = true
            }
        }

        // Si la contraseña tiene al menos un carácter en cada categoría, aumentar la fortaleza
        if (hasUpperCase && hasLowerCase && hasDigit) {
            strength += 30
        }

        return strength
    }
}