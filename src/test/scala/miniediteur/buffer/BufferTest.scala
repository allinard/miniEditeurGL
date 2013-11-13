package miniediteur.buffer

import junit.framework._
import org.junit.Assert._
import miniediteur.Buffer

class BufferTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	var buff = Buffer.getInstance
	
	
	def test1() = {
		val text = "testCopy"

		Assert.assertTrue(buff.clipBoard.text.isEmpty())
		
		buff.copy(text)
		
		Assert.assertEquals(text, buff.clipBoard.text)
	}

	def test2() = {
		val text = "testCut"

		Assert.assertFalse(text.equals(buff.clipBoard.text))
		
		buff.cut(text)
		
		Assert.assertEquals(text, buff.clipBoard.text)
	}

	def test3() = {
		val text = "testPaste"

		buff.copy(text)
		
		Assert.assertEquals(text, buff.clipBoard.text)
		
		Assert.assertEquals(text, buff.paste)
	}

}