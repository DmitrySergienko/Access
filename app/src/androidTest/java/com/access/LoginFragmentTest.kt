package com.access

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.access.presentation.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun loginButton_EffectiveVisible() {
        Espresso.onView(withId(R.id.loginButton)).check(
            ViewAssertions.matches(
                ViewMatchers.withEffectiveVisibility(
                    ViewMatchers.Visibility.VISIBLE
                )
            )
        )

    }
    @Test
    fun loginButton_IsWorking() {
        Espresso.onView(withId(R.id.loginButton)).perform(ViewActions.click())
    }
    @Test
    fun loginButton_isDisplayed() {
        Espresso.onView(withId(R.id.loginButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }


    @After
    fun close() {
        scenario.close()
    }
}