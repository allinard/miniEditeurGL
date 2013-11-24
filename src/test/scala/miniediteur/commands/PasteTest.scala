package miniediteur.commands

import junit.framework._

import org.junit.Assert._

import miniediteur.command.Cut;
import miniediteur.command.Paste
import miniediteur.ui.UserInterface
import miniediteur.memento._


class PasteTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testPaste"
	
	//UserInterface stub
	var ui = new UserInterface
	val caretaker = new Caretaker()
	val originator = new Originator(null)
	
	ui.copiedValue = text
		
	var cutCmd = new Cut(ui, caretaker, originator)
	var pasteCmd = new Paste(ui, caretaker, originator)

	def test1() = {
		cutCmd.execute
		pasteCmd.execute
		Assert.assertEquals(text, pasteCmd.ui.pasteValue)
	}

}