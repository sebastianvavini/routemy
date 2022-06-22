package com.viniciusaraujo.routemy

import android.content.Context
import android.content.SharedPreferences

class Security(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("RouteMy", Context.MODE_PRIVATE)

    fun storeString(key:String, string: String){
        security.edit().putString(key,string).apply()
    }
    fun getString(key: String):String{
        return security.getString(key,"") ?: ""
    }

}