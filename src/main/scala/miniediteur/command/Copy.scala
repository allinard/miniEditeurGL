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

	var positionStart = 0
	var positionEnd = 0
	var text = ""
	var textSave = ""
	
	def execute() = {
		val t = ui.copiedValue
		positionStart = ui.positionEnd - ui.lenght
		positionEnd = ui.positionEnd
		textSave = ui.textSave
		buffer.copy(t)
		originator.set(ui.commandCopy)
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