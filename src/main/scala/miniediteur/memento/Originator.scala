package miniediteur.memento

import scala.reflect.api.TypeTags
import miniediteur.memento.Memento
import miniediteur.Command


/**
 * Class containing the memento in order to save the different states of the editor
 * @author AdelineAlex
 */
class Originator(var state: Command) {

	
	/**
	 * setting a state to the memento
	 * @param the state
	 */
	def set(state: Command) {
		println("Originator: etat affecte a: " + state);
		this.state = state;
	}

	/**
	 * saving the memento
	 */
	def saveToMemento(): Command = {
		println("Originator: sauvegarde dans le memento de --> " + state);
		return state;
	}

	/**
	 * Restoring from a given memento
	 * @param the given memento
	 */
	/*def restoreFromMemento(m: Memento) {
		
			
			state = m.getSavedState();
			println("Originator: Etat après restauration: " + state); }
			
		}
		
	}*/

	

}