package com.lambdaschool.javacountries

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaCountriesApplication
{
    companion object
    {
        lateinit var ourCountryList: CountryList

        @JvmStatic
        fun main(args: Array<String>)
        {
            ourCountryList = CountryList()
            runApplication<JavaCountriesApplication>(*args)
        }
    }
}

