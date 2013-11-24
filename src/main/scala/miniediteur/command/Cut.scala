package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
import miniediteur.memento._

/**
 *
 * Class containing Cut Command
 * @author AdelineAlex
 *
 */
class Cut(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	var position : Int = 0
	
	def execute() = {
		val t = ui.copiedValue

		buffer.cut(t)
		originator.set(ui.commandCut)
		caretaker.addMemento(originator.saveToMemento);
		
	}
	
	def redo() = {
		execute()
	}
	
	def undo() = {
		ui.commandPaste
	}

}