package com.example.appcomparaciontextos
import androidx.test.runner.AndroidJUnit4;
//import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var rule: ActivityScenarioRule <*> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun mainActivity_presionarComparar () {
        Espresso.onView(
            ViewMatchers.withId(R.id.btnComparacion)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.txtComparacion)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son diferentes")
            )
        )
    }

}