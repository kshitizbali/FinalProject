package com.udacity.gradle.builditbigger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/*@RunWith(AndroidJUnit4.class)*/
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testVerifyEchoResponseNotNull() {

        /*assertNotNull(MainActivity.EndPointAsyncTask1);*/
        /*assertEquals("hello", Echo.echo("hello"));*/
        /*assertNotNull(Echo.echo("hello"));*/



        onView((withId(R.id.btTellJoke))).perform(click());
        onView(withId(R.id.instructions_text_view)).check(matches(not(withText(""))));


    }


}
