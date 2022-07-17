package com.dicoding.courseschedule.ui.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.courseschedule.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    @get:Rule
    var rule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun openAddCourse(){
        onView(withId(R.id.action_add)).perform(ViewActions.click())
        onView(withId(R.id.tv_course_name_add)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_startTime)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.btn_endTime)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_lecturer_add)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_note_add)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}