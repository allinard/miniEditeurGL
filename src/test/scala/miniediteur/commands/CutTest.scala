package miniediteur.commands

import junit.framework._
import org.junit.Assert._
import miniediteur.command.Cut
import miniediteur.ui.UserInterface
import miniediteur.memento._

class CutTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testCut"
	
	//UserInterface stub
	var ui = new UserInterface
	val caretaker = new Caretaker()
	val originator = new Originator("")
	
	ui.copiedValue = text
		
	var cutCmd = new Cut(ui, caretaker, originator)
	
	def test1() = {
		cutCmd.execute
		Assert.assertEquals(text, cutCmd.buffer.clipBoard.text)
	}

}