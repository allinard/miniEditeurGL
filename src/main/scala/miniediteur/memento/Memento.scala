package miniediteur.memento

import miniediteur.Command

/**
	 * The memento
	 * @author root
	 */
class Memento(var stateMem: Command) {
		/**
		 * get the state
		 */
		def getSavedState(): Command = {
			return stateMem
		}
}