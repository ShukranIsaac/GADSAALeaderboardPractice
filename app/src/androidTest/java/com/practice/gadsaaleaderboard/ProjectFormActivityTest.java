package com.practice.gadsaaleaderboard;

import android.content.Context;
import android.util.Patterns;

import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectActivity;
import com.practice.gadsaaleaderboard.ui.projectsubmission.models.LeaderPayloadAttr;
import com.practice.gadsaaleaderboard.ui.projectsubmission.models.ProjectViewModel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static org.hamcrest.Matchers.*;
import static androidx.test.espresso.Espresso.pressBack;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ProjectFormActivityTest {
    static Context appContext;
    static ProjectViewModel sProjectViewModel;

    @BeforeClass
    public static void getAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        sProjectViewModel = new ProjectViewModel();
    }

    @Rule
    public ActivityScenarioRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public ActivityScenarioRule<ProjectActivity> mNoteActivityActivityTestRule =
            new ActivityScenarioRule<>(ProjectActivity.class);

    @AfterClass
    public static void removeAppContext() {
        appContext = null;
    }

    @Test
    public void shouldAssertExpectedContext() {
        assertEquals("com.practice.gadsaaleaderboard", appContext.getPackageName());
    }

    @Test
    public void shouldOpenSubmitFormFromMainActivity() {
        onView(withId(R.id.submit)).perform(click());

        pressBack();
    }

    private boolean isEmailValid(String email) {
        if (email.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Test
    public void shouldValidateEmailAddress() {
        final String firstname = "John";
        final String lastname = "Doe";
        final String email = "imwakabira@cc.ac.mw";

        onView(withId(R.id.submit)).perform(click());

        onView(withId(R.id.first_name)).perform(typeText(firstname))
                .check(matches(withText(containsString(firstname))));

        onView(withId(R.id.last_name)).perform(typeText(lastname))
                .check(matches(withText(containsString(lastname))));

        assertTrue(isEmailValid(email));

        pressBack();
    }

    @Test
    public void shouldSubmitProjectSubmitFormData() {
        final String firstname = "John";
        final String lastname = "Doe";
        final String email = "johndoe@gmail.com";
        final String github = "https://github.com/ShukranIsaac/GADSAALeaderboardPractice";

        onView(withId(R.id.submit)).perform(click());

        onView(withId(R.id.first_name)).perform(typeText(firstname))
                .check(matches(withText(containsString(firstname))));

        onView(withId(R.id.last_name)).perform(typeText(lastname))
                .check(matches(withText(containsString(lastname))));

        onView(withId(R.id.email_address)).perform(typeText(email)).perform(closeSoftKeyboard())
                .check(matches(withText(containsString(email))));

        onView(withId(R.id.github_link)).perform(replaceText(github)).perform(closeSoftKeyboard())
                .check(matches(withText(containsString(github))));

        onView(withId(R.id.button)).check(matches(isEnabled())).perform(click());

        LeaderPayloadAttr leaderPayloadAttr = LeaderPayloadAttr.builder()
                .email(email).lastName(lastname)
                .firstName(firstname).githubLink(github)
                .build();

//        onData(allOf(instanceOf(LeaderPayloadAttr.class), equalTo(leaderPayloadAttr)))
//                .perform(click());
//        pressBack();
    }
}
