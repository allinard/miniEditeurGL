package miniediteur.commands

import junit.framework._

import org.junit.Assert._

import miniediteur.command.Cut;
import miniediteur.command.Paste
import miniediteur.ui.UserInterface

class PasteTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testPaste"
	
	//UserInterface stub
	var ui = new UserInterface
	ui.copiedValue = text
		
	var cutCmd = new Cut(ui)
	var pasteCmd = new Paste(ui)

	def test1() = {
		cutCmd.execute
		pasteCmd.execute
		Assert.assertEquals(text, pasteCmd.ui.pasteValue)
	}

}