package br.com.heiderlopes.jogodavelha.ui.game

import androidx.test.rule.ActivityTestRule
import br.com.heiderlopes.jogodavelha.R
import br.com.heiderlopes.jogodavelha.models.Player
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GameActivityTest {


    @Rule
    @JvmField
    val activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    private val player1 = Player("Heider", "X")
    private val player2 = Player("Android", "O")
    @Test
    fun endGameWhenOnePlayerWins() {

        writeTo(R.id.et_player1, player1.name)
        writeTo(R.id.et_player2, player2.name)

        clickDialogPositiveButton()

        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)

        assertDisplayed(R.id.tvWinner)
        assertDisplayed(player1.name)

    }

}