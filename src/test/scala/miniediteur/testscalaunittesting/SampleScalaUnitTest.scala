package miniediteur.testscalaunittesting

import junit.framework._
import org.junit.Assert._

class SampleScalaUnitTest extends TestCase {
	override def setUp() = {
	}

	override def tearDown() = {
	}

	def testOne() = {
		assertEquals(1, 1)
	}

	def testTwo() = {
		assertEquals(2, 3)
	}

}