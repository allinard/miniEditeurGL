package miniediteur.commands

import junit.framework._
import org.junit.Assert._
import miniediteur.command.Copy
import miniediteur.ui.UserInterface
import miniediteur.memento._

class CopyTest extends TestCase{
	override def setUp() = {
	}

	override def tearDown() = {
	}

	val text = "testCopy"
	
	//UserInterface stub
	var ui = new UserInterface
	val caretaker = new Caretaker()
	val originator = new Originator("")
	
	ui.copiedValue = text
		
	var copyCmd = new Copy(ui, caretaker, originator)
	
	def test1() = {
		copyCmd.execute
		Assert.assertEquals(text, copyCmd.buffer.clipBoard.text)
	}
		
}