package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
// There should be a button to return to the HomeScreen
// There should be text indicating that it's the DriversScreen (i.e., "FormulaZero Drivers")
// There should be a text field and a button to add drivers, where drivers added will be displayed in a list format
// There should be a button to clear all drivers displayed


// Create a test that verifies the following:
//Verify that you can properly go from the HomeScreen to the DriversScreen
//Verify that you can properly add at least one driver, and if that driver is properly displayed
//Verify that you can properly clear the driver(s) from the list
//Verify that the back button takes you back to the HomeScreen



@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("New Driver")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("New Driver")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("New Driver")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("backButtonDrivers")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}