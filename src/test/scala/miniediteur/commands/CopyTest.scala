package miniediteur.commands

import junit.framework._
import org.junit.Assert._
import miniediteur.command.Copy
import miniediteur.ui.UserInterface

class CopyTest extends TestCase{
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testCopy"
	
	//UserInterface stub
	var ui = new UserInterface
	ui.copiedValue = text
		
	var copyCmd = new Copy(ui)
	
	def test1() = {
		copyCmd.execute
		Assert.assertEquals(text, copyCmd.buffer.clipBoard.text)
	}
		
}