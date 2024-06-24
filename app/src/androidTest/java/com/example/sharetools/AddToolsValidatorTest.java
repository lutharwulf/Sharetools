package com.example.sharetools;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.google.firebase.auth.FirebaseAuth;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddToolsValidatorTest {
    private FirebaseAuth mAuth;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        mAuth = FirebaseAuth.getInstance();
        // Connect the test user before each test
        mAuth.signInWithEmailAndPassword("test0@test.local", "1230456")
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        throw new AssertionError("Test user login failed.");
                    }
                });
    }

    @After
    public void tearDown() {
        // Sign out after each test
        mAuth.signOut();
    }

    @Test
    public void testAddToolSuccess() {
        FragmentScenario.launchInContainer(AddTools.class);
        onView(withId(R.id.editTextGroupName)).perform(replaceText("Marteau"));
        onView(withId(R.id.editTextDescription)).perform(replaceText("Permet d'enfoncer ou de retirer des clous."));

        onView(withId(R.id.buttonCreate)).perform(click());

        //onView(withText("Données ajoutées avec succès.")).check(matches(isDisplayed()));
    }

    @Test
    public void testAddToolFailure() {
        FragmentScenario.launchInContainer(AddTools.class);
        onView(withId(R.id.editTextGroupName)).perform(replaceText(""));
        onView(withId(R.id.editTextDescription)).perform(replaceText(""));

        onView(withId(R.id.buttonCreate)).perform(click());

        //onView(withText("Veuillez ajouter des données.")).check(matches(isDisplayed()));
    }
}