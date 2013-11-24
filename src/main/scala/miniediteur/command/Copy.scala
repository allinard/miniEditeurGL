package miniediteur.command

import miniediteur.Command
import miniediteur.memento._
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Copy Command
 * @author AdelineAlex
 *
 */
class Copy(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	
	
	def execute() = {
		val t = ui.copiedValue

		buffer.copy(t)
		
		originator.set(ui.commandCopy)
		caretaker.addMemento(originator.saveToMemento);
	}
	
	def redo() = {
		
		execute()
	}
	
	def undo() = {
		
		// inverse de copier 
	}

}