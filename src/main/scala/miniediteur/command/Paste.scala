package miniediteur.command

import miniediteur.Command
import miniediteur.memento._
import miniediteur.ui.UserInterface
import miniediteur.Buffer

/**
 *
 * Class containing Paste Command
 * @author AdelineAlex
 *
 */
class Paste(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	var positionStart = 0
	var positionEnd = 0
	
	def execute() = {
		//ui.pasteValue= buffer.paste();
		originator.set(ui.commandPaste);
		caretaker.addMemento(originator.saveToMemento);
		
	}
	
	def redo() = {
		execute()
	}
	
	def undo() = {
		ui.commandCut
	}

}