package com.viniciusaraujo.routemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.viniciusaraujo.routemy.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var editTextUser: EditText
    private lateinit var buttonEnter:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        editTextUser = findViewById<EditText>(R.id.edit_text_user_id)
        buttonEnter= findViewById(R.id.button_enter)
        setListeners()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_enter) {
            handleSave()
        }
    }
    private fun setListeners(){
        buttonEnter.setOnClickListener(this)
    }

    private fun handleSave() {
        val name = editTextUser.text.toString()
        if (name != "") {
            var security =
                Security(this)// instancia a classe security que salva o usuario no shared
            security.storeString("user_name", name)//salva o nome do usuario
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }


}