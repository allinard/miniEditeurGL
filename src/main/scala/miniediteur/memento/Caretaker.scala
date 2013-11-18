package miniediteur.memento

import scala.collection.immutable.List
import scala.collection.mutable.ArrayBuffer

/**
 *
 * Class containing anotherr part of the memento
 * @author AdelineAlex
 */
class Caretaker {

	/**
	 * The variable containing the differents states of the editor
	 */
	var savedStates = ArrayBuffer[String]()

	/**
	 * Adding a state to the memento
	 * @param the text of the editor in the current state
	 */
	def addMemento(m: String) {
		savedStates += m
	}

	/**
	 * getting the last recorded state of the memento
	 */
	def getMemento(): String =
		{
			return savedStates.last
		}

}