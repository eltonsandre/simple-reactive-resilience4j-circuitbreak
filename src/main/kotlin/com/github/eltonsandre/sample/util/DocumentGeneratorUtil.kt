package com.github.eltonsandre.sample.util

import java.util.Random

object DocumentGeneratorUtil {

    private val random = Random()

    @JvmStatic
    fun cnpj(formatted: Boolean = false, valid: Boolean = true): String {
        val cnpj = if (valid) {
            val partial = StringBuilder()
            for (i in 0..7) {
                partial.append((Math.random() * 9).toInt())
            }
            val cnpjP1 = partial.append("0001").toString()
            val d1 = digit(calculateWeight(cnpjP1.substring(4, 12), 9) + calculateWeight(cnpjP1.substring(0, 4), 5))
            val d2 = digit((d1 * 2) + calculateWeight(cnpjP1.substring(5, 12), 9) + calculateWeight(cnpjP1.substring(0, 5), 6))

            cnpjP1 + d1 + d2
        } else {
            (random.nextInt(1000000000) + (random.nextInt(90) + 10) * 1000000000000L).toString()
        }

        return if (formatted) DocumentFormatterUtil.cnpj(cnpj) else cnpj
    }

    @JvmStatic
    fun cpf(formatted: Boolean = false, valid: Boolean = true): String {
        val cpf = if (valid) {
            val partial = StringBuilder()
            for (i in 0..8) {
                partial.append((Math.random() * 10).toInt())
            }
            val cpf = partial.toString()

            val d1 = digit(calculateWeight(cpf, 10))
            val d2 = digit((d1 * 2) + calculateWeight(cpf, 11))

            "$cpf$d1${d2}"
        } else {
            (random.nextInt(1000000000) + (random.nextInt(90) + 10) * 1000000000L).toString()
        }
        return if (formatted) DocumentFormatterUtil.cpf(cpf) else cpf
    }

    private fun calculateWeight(num: String, weight: Int): Int {
        var sum = 0
        var weightAux = weight

        for (index in num.indices) {
            sum += num.substring(index, index + 1).toInt() * weightAux--
        }
        return sum;
    }

    private fun digit(verificatorDigit: Int) = if (verificatorDigit % 11 == 0 || verificatorDigit % 11 == 1) 0 else 11 - verificatorDigit % 11

}
