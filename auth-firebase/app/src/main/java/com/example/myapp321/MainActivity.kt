package com.example.kacitamapatie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.editTextEmail)
        password= findViewById(R.id.editTextPassword)
        auth = Firebase.auth
        firebaseAuth= FirebaseAuth.getInstance()
    }
    fun inputFunction(view:View){
        val inputEmail = email.text.toString().isNotEmpty() && email.text.toString().contains("@")
                && email.text.toString().substring(email.text.toString().indexOf("@"), email.text.toString().length).contains(".")
        val inputPass = password.text.toString().isNotEmpty()
        if (inputEmail && inputPass){
            firebaseAuth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this, "ახლიდან", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
