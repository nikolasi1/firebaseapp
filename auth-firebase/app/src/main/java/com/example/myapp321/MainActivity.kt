package com.example.myapp321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.myapp321.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var email: EditText
    private lateinit var password : EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        email= findViewById(R.id.editTextEmail)
        password= findViewById(R.id.editTextPassword)
        firebaseAuth = FirebaseAuth.getInstance()
    }
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
        }
    }
    fun authFun(view:View){
        if (password.text.toString().isNotEmpty() && email.text.toString().isNotEmpty()  && email.text.toString().contains("@") && email.text.toString().substring(email.text.toString().indexOf("@"), email.text.toString().length).contains(".")){ firebaseAuth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}