package com.lambdaschool.javacountries

data class Country(val name: String, val population: Long, val size: Long, val age: Int) {

    override fun toString(): String
    {
        return "Country(name='$name', population=$population, size=$size, age=$age)"
    }
}