package com.ianarbuckle.codingproject.parser

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.ianarbuckle.codingproject.data.Customer

/**
 * Created by Ian Arbuckle on 10/01/2019.
 *
 */
class GsonParserImpl : GsonParser {

    override fun parseJson(jsonString: String): List<Customer> {
        val gson = GsonBuilder().create()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)
        val type = object : TypeToken<ArrayList<Customer>>(){}.type
        return gson.fromJson(jsonObject.get("customers"), type)
    }

}