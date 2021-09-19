package com.example.reg_profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val createAccountButton = findViewById<Button>(R.id.etCreate_account)
        val etName = findViewById<TextView>(R.id.etName)
        val etPhoneNumber = findViewById<TextView>(R.id.etPhone_number)
        val etEmail = findViewById<TextView>(R.id.etMail)
        val etSpinner: Spinner = findViewById(R.id.spinner_sex)
        var gender = ""


        createAccountButton.setOnClickListener {

            //Logic to validate the user inputs
            val username = etName.text.toString().trim()
            val phoneNumber = etPhoneNumber.text.toString().trim()
            val email = etEmail.text.toString().trim()








            //Name field validation
            if (!ValidationTestClass.checkForValidUserName(username)) {
                etName.requestFocus()
                etName.error = "Please enter a valid name!"
                return@setOnClickListener
            }


            //Phone Number Field Validation
            if (!ValidationTestClass.checkIfValidPhoneNumber(phoneNumber)) {
                etPhoneNumber.requestFocus()
                etPhoneNumber.error = "Enter a valid Phone Number"
                return@setOnClickListener
            }


            //Validation for email
            if (!ValidationTestClass.checkIfEmailIsValid(email)) {
                etEmail.requestFocus()
                etEmail.error = "Enter A Valid Email Address"
                return@setOnClickListener
            }


            Log.d(TAG, etName.toString())
            val intent = Intent(this, UserProfile::class.java)
            intent.putExtra("name", username)
            intent.putExtra("mobile", phoneNumber)
            intent.putExtra("mail", email)
            intent.putExtra("sex", gender)
            startActivity(intent)
        }


        val genderList: Array<String> = arrayOf("select gender", "Male", "Female", "Other")
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderList)
        etSpinner.adapter = arrayAdapter
        etSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)

                when (position) {
                    0 -> gender = genderList[position]
                    1 -> gender = genderList[position]
                    2 -> gender = genderList[position]
                    3 -> gender = genderList[position]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                etSpinner.onItemSelectedListener = this
            }

        }


    }
}