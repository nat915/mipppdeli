package com.apsel.mipppdeli.activities.client.home

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.apsel.mipppdeli.R
import com.apsel.mipppdeli.models.User
import com.apsel.mipppdeli.utils.SharedPref
import com.google.gson.Gson

class ClientHomeActivity : AppCompatActivity() {

    private val TAG = "ClientHomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_client_home)

        getUserFromSession()
    }
    private fun getUserFromSession() {

        val sharedPref = SharedPref(this)
        val gson = Gson()

        if(!sharedPref.getData("user").isNullOrBlank()){
            //si el usuario existe en session
            val user = gson.fromJson(sharedPref.getData("user"), User::class.java)
            Log.d(TAG, "Usuario: $user")
        }
    }
}