package miniediteur.commands

import junit.framework._
import org.junit.Assert._
import miniediteur.command.Cut
import miniediteur.ui.UserInterface

class CutTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testCut"
	
	//UserInterface stub
	var ui = new UserInterface
	ui.copiedValue = text
		
	var cutCmd = new Cut(ui)
	
	def test1() = {
		cutCmd.execute
		Assert.assertEquals(text, cutCmd.buffer.clipBoard.text)
	}

}