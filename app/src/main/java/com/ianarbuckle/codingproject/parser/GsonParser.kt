package com.ianarbuckle.codingproject.parser

import com.ianarbuckle.codingproject.data.Customer

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */
interface GsonParser {
    fun parseJson(jsonString: String): List<Customer>
}