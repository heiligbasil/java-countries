package com.lambdaschool.javacountries

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/names")
class CountryController
{
    //localhost:2019/data/allCountries
    @RequestMapping(value = ["/all"], produces = ["application/json"])
    fun getAllCountries(): ResponseEntity<*>
    {
        JavaCountriesApplication.ourCountryList.countryList.sortWith(Comparator { c1, c2 -> c1.name.compareTo(c2.name, true) })

        return ResponseEntity<Any>(JavaCountriesApplication.ourCountryList.countryList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/start/{letter}"], produces = ["application/json"])
    fun getCountriesByLetter(@PathVariable letter: String): ResponseEntity<*>
    {
        val sortedList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.sortedWith(compareBy { it.name })
        val filteredSortedList: List<Country> = sortedList.filter { it.name.substring(0, 1).toLowerCase() == letter.toLowerCase() }

        return ResponseEntity<Any>(filteredSortedList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/size/{number}"], produces = ["application/json"])
    fun getCountriesByLength(@PathVariable number: Int): ResponseEntity<*>
    {
        val sortedList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.sortedWith(compareBy { it.name })
        val filteredSortedList: List<Country> = sortedList.filter { it.name.length >= number }

        return ResponseEntity<Any>(filteredSortedList, HttpStatus.OK)
    }
}

@RestController
@RequestMapping("/population")
class CountryController2
{
    @RequestMapping(value = ["/size/{people}"], produces = ["application/json"])
    fun getCountriesByPopulation(@PathVariable people: Long): ResponseEntity<*>
    {
        val filteredList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.filter { it.population >= people }

        return ResponseEntity<Any>(filteredList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/min"], produces = ["application/json"])
    fun getCountryWithSmallestPopulation(): ResponseEntity<*>
    {
        val country: Country? = JavaCountriesApplication.ourCountryList.countryList.minBy { it.population }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }

    @RequestMapping(value = ["/max"], produces = ["application/json"])
    fun getCountryWithLargestPopulation(): ResponseEntity<*>
    {
        val country: Country? = JavaCountriesApplication.ourCountryList.countryList.maxBy { it.population }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }


    @RequestMapping(value = ["/median"], produces = ["application/json"])
    fun getCountryMedianPopulation(): ResponseEntity<*>
    {
        val sortedList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.sortedWith(compareBy { it.population })

        val country: Country;
        val medianIndex: Int = sortedList.size.div(2)

        if (sortedList.size % 2 == 0)
        {
            country = sortedList.get(medianIndex)
        }
        else
        {
            country = sortedList.get(medianIndex - 1)
        }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }
}

@RestController
@RequestMapping("/age")
class CountryController3
{
    @RequestMapping(value = ["/age/{age}"], produces = ["application/json"])
    fun getCountriesByPopulation(@PathVariable age: Long): ResponseEntity<*>
    {
        val filteredList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.filter { it.age >= age }

        return ResponseEntity<Any>(filteredList, HttpStatus.OK)
    }


    @RequestMapping(value = ["/min"], produces = ["application/json"])
    fun getCountryWithSmallestPopulation(): ResponseEntity<*>
    {
        val country: Country? = JavaCountriesApplication.ourCountryList.countryList.minBy { it.age }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }

    @RequestMapping(value = ["/max"], produces = ["application/json"])
    fun getCountryWithLargestPopulation(): ResponseEntity<*>
    {
        val country: Country? = JavaCountriesApplication.ourCountryList.countryList.maxBy { it.age }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }

    @RequestMapping(value = ["/median"], produces = ["application/json"])
    fun getCountryMedianAge(): ResponseEntity<*>
    {
        val sortedList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.sortedWith(compareBy { it.age })

        val country: Country;
        val medianIndex: Int = sortedList.size.div(2)

        if (sortedList.size % 2 == 0)
        {
            country = sortedList.get(medianIndex)
        }
        else
        {
            country = sortedList.get(medianIndex - 1)
        }

        return ResponseEntity<Any>(country, HttpStatus.OK)
    }
}