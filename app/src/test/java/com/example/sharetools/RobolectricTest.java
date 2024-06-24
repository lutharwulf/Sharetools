package com.example.sharetools;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLooper;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;


@RunWith(RobolectricTestRunner.class)
@Config(qualifiers = "fr-rFR-ldpi")
public class RobolectricTest {

    @Test
    public void testFragmentHomeToSearchTransitions() {

        FragmentScenario<HomeFragment> scenarioA = FragmentScenario.launchInContainer(HomeFragment.class, null, R.style.Base_Theme_ShareTools);
        scenarioA.onFragment(fragmentA -> {

            fragmentA.getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, new SearchFragment())
                    .addToBackStack(null)
                    .commit();
        });

        FragmentScenario<SearchFragment> scenarioB = FragmentScenario.launchInContainer(SearchFragment.class, null, R.style.Base_Theme_ShareTools);
        scenarioB.onFragment(fragment -> {
            assertTrue(fragment.isVisible());
        });
    }
}
