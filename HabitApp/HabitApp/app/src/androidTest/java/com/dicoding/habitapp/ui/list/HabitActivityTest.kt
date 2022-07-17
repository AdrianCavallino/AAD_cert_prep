package com.dicoding.habitapp.ui.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.habitapp.R
import org.junit.Rule
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
class HabitActivityTest {
    @get:Rule
    var rule = ActivityScenarioRule(HabitListActivity::class.java)

    @Test
    fun openAddHabit(){
        onView(withId(R.id.fab)).perform(ViewActions.click())
        onView(withId(R.id.add_ed_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.add_ed_minutes_focus)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.sp_priority_level)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.add_tv_start_time)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}