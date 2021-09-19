package com.example.reg_profile

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    lateinit var name : String
    lateinit var phone : String
    lateinit var mail : String
    lateinit var sex : String



    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun validInput() {
        name = "samuel"
        phone = "08091185347"
        mail= "samuel.onum1@gmail.com"
        sex = "Male"
    }



    @Test
    fun registrationComplete () {
        // Type text and then press the button.
        onView(withId(R.id.etName))
            .perform(ViewActions.typeText(name), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.etPhone_number))
            .perform(ViewActions.typeText(phone), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etMail))
            .perform(ViewActions.typeText(mail),ViewActions.closeSoftKeyboard() )

        onView(withId(R.id.spinner_sex)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(sex))).perform(click())


        onView(withId(R.id.etCreate_account)).perform(ViewActions.click())

        onView(withId(R.id.text_name))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))

        onView(withId(R.id.text_phone))
            .check(ViewAssertions.matches(ViewMatchers.withText(phone)))

        onView(withId(R.id.text_mail))
            .check(ViewAssertions.matches(ViewMatchers.withText(mail)))
    }
}