package com.lambdaschool.javacountries

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaCountriesApplication

    val ourCountryList: CountryList= CountryList()

    fun main(args: Array<String>)
    {
        runApplication<JavaCountriesApplication>(*args)
    }

