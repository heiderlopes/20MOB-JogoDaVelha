package br.com.heiderlopes.jogodavelha.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest {

    private lateinit var game: Game
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Rule @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        game = Game("Heider", "Android")
        player = game.player1
        anotherPlayer = game.player2
    }

    @Test
    fun `return true if has three same horizontal cell at row 1`() {

        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {

        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {

        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }


    @Test
    fun `return false if does not have three same horizontal cells`() {

        val cell = Cell(player)
        val another = Cell(anotherPlayer)

        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = another

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertFalse(hasThreeSameHorizontalCells)

    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
        val cell = Cell(player)
        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }


    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn3() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }


    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    fun returnTrueIfChangePlayerSwitchPlayerIsWorking() {

        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)

        game.switchPlayer()

        assertEquals(anotherPlayer, game.currentPlayer)
    }


    @Test
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameVerticalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameDiagonalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }


    @Test
    fun endGameIfBoardIsFull() {
        val cell1 = Cell(player)
        val cell2 = Cell(player)
        val cell3 = Cell(anotherPlayer)
        val cell4 = Cell(anotherPlayer)
        val cell5 = Cell(player)
        val cell6 = Cell(player)
        val cell7 = Cell(player)
        val cell8 = Cell(anotherPlayer)
        val cell9 = Cell(anotherPlayer)

        game.cells[0][0] = cell1
        game.cells[0][1] = cell2
        game.cells[0][2] = cell3
        game.cells[1][0] = cell4
        game.cells[1][1] = cell5
        game.cells[1][2] = cell6
        game.cells[2][0] = cell7
        game.cells[2][1] = cell8
        game.cells[2][2] = cell9

        val hasGameEnded = game.hasGameEnded()

        assertTrue(hasGameEnded)
    }

}