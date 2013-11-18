package miniediteur.memento

import scala.reflect.api.TypeTags

/**
 * Class containing the memento in order to save the different states of the editor
 * @author AdelineAlex
 */
class Originator(var state: String) {

	/**
	 * setting a state to the memento
	 * @param the state
	 */
	def set(state: String) {
		println("Originator: etat affecte a: " + state);
		this.state = state;
	}

	/**
	 * saving the memento
	 */
	def saveToMemento(): String = {
		println("Originator: sauvegarde dans le memento.");
		return state;
	}

	/**
	 * Restoring from a given memento
	 * @param the given memento
	 */
	def restoreFromMemento(state: String) {
		//val memento = m;
		//state = memento.getSavedState();
		println("Originator: Etat après restauration: " + state);
	}

	/**
	 * The memento
	 * @author root
	 */
	class Memento(var state: String) {
		/**
		 * get the state
		 */
		def getSavedState(): String = {
			return state
		}
	}

}