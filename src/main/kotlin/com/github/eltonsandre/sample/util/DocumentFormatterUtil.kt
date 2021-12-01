package com.github.eltonsandre.sample.util

object DocumentFormatterUtil {

    @JvmStatic
    private val PATTERN_CPF = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})"

    @JvmStatic
    private val PATTERN_CNPJ = "([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})"

    @JvmStatic
    fun cnpj(cnpj: String = "") = cnpj.replace(PATTERN_CNPJ.toRegex(), "$1\\.$2\\.$3/$4-$5")

    @JvmStatic
    fun cpf(cpf: String = "") = cpf.replace(PATTERN_CPF.toRegex(), "$1\\.$2\\.$3-$4")

    @JvmStatic
    fun unformat(doc: String = "") = doc.replace("\\D+".toRegex(), "")

}
