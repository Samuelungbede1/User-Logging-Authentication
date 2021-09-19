package com.example.reg_profile

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ValidationTestClassTest {


    @Test
    fun check_For_Valid_UserName() {
        var result= ValidationTestClass.checkForValidUserName("samuel")
        assertEquals(true,result)
    }



    @Test
    fun check_For_Valid_PhoneNumber() {
        var result= ValidationTestClass.checkIfValidPhoneNumber("08011185347")
        assertEquals(true, result)
    }


    @Test
    fun check_For_Valid_Email() {
        var result= ValidationTestClass.checkIfEmailIsValid("")
        assertEquals(true,result)
    }

}