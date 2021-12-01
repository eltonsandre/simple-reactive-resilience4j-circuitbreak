package com.github.eltonsandre.sample

import java.util.function.Predicate

class Specification<E> private constructor(var rules: Predicate<E>) {

    fun and(rule: Predicate<E>?): Specification<E> {
        rules = rules.and(rule)
        return this
    }

    fun or(rule: Predicate<E>?): Specification<E> {
        rules = rules.or(rule)
        return this
    }

    fun orNot(rule: Predicate<E>?): Specification<E> {
        rules = rules.or(rule).negate()
        return this
    }

    fun andNot(rule: Predicate<E>?): Specification<E> {
        rules = rules.and(rule).negate()
        return this
    }

    fun isSatisfiedBy(`object`: E): Boolean {
        return rules.test(`object`)
    }

    companion object {

        @JvmStatic
        fun <E> `when`(): Specification<E> {
            return Specification { rule: E -> true }
        }

        @JvmStatic
        fun <E> `when`(rule: Predicate<E>): Specification<E> {
            return Specification(rule)
        }

        @JvmStatic
        fun <E> whenNot(rule: Predicate<E>): Specification<E> {
            return Specification(rule.negate())
        }

    }
}
