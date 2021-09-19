package com.example.reg_profile

object ValidationTestClass {


    //Check for empty UserName field
    //Check if UserName field Contains only Alphabets
    //Check if User inputs Numbers
    fun checkForValidUserName(username: String): Boolean {
        return (!username.isEmpty() && username.matches("^[a-zA-Z]*$".toRegex())
                && !username.matches("^[0-9]*$".toRegex()))

    }


    //Check for Empty Phone Number Input
    //Check if User inputs Alphabets
    //Checks that users only inputs numbers
    fun checkIfValidPhoneNumber(phoneNumber: String): Boolean {
        return (!phoneNumber.isEmpty() && !phoneNumber.matches("^[a-zA-Z]*$".toRegex())
                && phoneNumber.matches("^[0-9]*$".toRegex())
                && !"(234|0)[0-9]{11}".toRegex().containsMatchIn(phoneNumber))
    }


    //Check for valid Email
    //Check if the inputs matches an Email Input
    fun checkIfEmailIsValid(email: String): Boolean {
        return (!email.isEmpty() && email.matches("^[a-zA-Z0-9]+\\.?[a-zA-Z0-9]+@[a-z]+\\.[a-z]+".toRegex()))
    }
}
