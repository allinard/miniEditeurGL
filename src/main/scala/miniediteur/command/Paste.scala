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
	var text : String = ""
	var textSave = ""
	
	
	def execute() = {
		ui.pasteValue= buffer.paste();
		positionStart = ui.positionEnd - ui.lenght
		positionEnd = ui.positionEnd
		textSave = ui.textSave
		originator.set(ui.commandPaste);
		caretaker.addMemento(originator.saveToMemento);
	}
	
	def redo() = {
		execute()
	}
	
	def undo() = {
		ui.textSave = textSave
		ui.positionEnd = positionEnd
		ui.lenght = positionEnd - positionStart
	}

}