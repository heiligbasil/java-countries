package com.lambdaschool.javacountries

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.util.ArrayList

@RestController
@RequestMapping("/data")
class CountryController
{
    //localhost:2019/data/allCountries
    @RequestMapping(value = ["/allcountries"], produces = ["application/json"])
    fun getAllCountries(): ResponseEntity<*>
    {
        JavaCountriesApplication.ourCountryList.countryList.sortWith(Comparator { c1, c2 -> c1.name.compareTo(c2.name, true) })

        return ResponseEntity<Any>(JavaCountriesApplication.ourCountryList.countryList, HttpStatus.OK)
    }

    @RequestMapping(value = ["/countries/{letter}"], produces = ["application/json"])
    fun getCountriesByLetter(@PathVariable letter: String): ResponseEntity<*>
    {
        val sortedList: List<Country> = JavaCountriesApplication.ourCountryList.countryList.sortedWith(compareBy { it.name })
        val filterSortedList: List<Country> = sortedList.filter { it.name.substring(0, 1).toLowerCase() == letter.toLowerCase() }

        return ResponseEntity<Any>(filterSortedList, HttpStatus.OK)
    }

/*    //localhost:2019/data/country/2
    @GetMapping(value = ["/country/{id}"], produces = ["application/json"])
    fun getEmpDetail(@PathVariable id: Long): ResponseEntity<*>
    {
        val rtnCnt: Country? = JavaCountriesApplication.ourCountryList.findCountry({ it -> (it.age() == age) })

        return ResponseEntity<Any>(rtnCnt, HttpStatus.OK)
    }*/

/*    // localhost:8080/data/countries/s
    @GetMapping(value = ["/countries/{letter}"], produces = ["application/json"])
    fun getCountries(@PathVariable letter: Char): ResponseEntity<*>
    {
        val rtnCnts: ArrayList<Country> = JavaCountriesApplication.ourCountryList.findCountries( { it -> it.name().toUpperCase().charAt(0) == Character.toUpperCase(letter) })

        return ResponseEntity<ArrayList<Country>>(rtnCnts, HttpStatus.OK)
    }*/
}
