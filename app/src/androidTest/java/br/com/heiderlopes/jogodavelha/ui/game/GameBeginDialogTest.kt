package br.com.heiderlopes.jogodavelha.ui.game

import androidx.test.rule.ActivityTestRule
import br.com.heiderlopes.jogodavelha.R
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GameBeginDialogTest {


    @Rule
    @JvmField
    val activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    @Test
    fun displaySameMessageIfNamesSame() {

        writeTo(R.id.et_player1, "Heider")
        writeTo(R.id.et_player2, "Heider")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_same_names)

    }

    @Test
    fun displayEmptyMessageIfOneNameEmpty() {

        writeTo(R.id.et_player1, "Heider")
        writeTo(R.id.et_player2, "")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)

    }


    @Test
    fun closeDialogAfterNamesValid() {

        writeTo(R.id.et_player1, "Heider")
        writeTo(R.id.et_player2, "Android")

        clickDialogPositiveButton()

       assertNotExist(R.id.player1Layout)

    }



}