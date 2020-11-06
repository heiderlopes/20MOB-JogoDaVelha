package br.com.heiderlopes.jogodavelha.ui.game

import androidx.test.rule.ActivityTestRule
import br.com.heiderlopes.jogodavelha.R
import br.com.heiderlopes.jogodavelha.models.Player
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GameEndDialogTest {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    private fun givenGameEnded() {
        activityRule.activity.onGameWinnerChanged(Player("Heider", "X"))
    }

    @Test
    fun displayWinnerWhenGameEnds() {
        givenGameEnded()
        assertDisplayed(R.id.tvWinner)
    }

    @Test
    fun displayBeginDialogWhenDoneClicked() {
        givenGameEnded()

        clickDialogPositiveButton()
        assertNotExist(R.id.tvWinner)
        assertDisplayed(R.id.et_player1)
    }
}