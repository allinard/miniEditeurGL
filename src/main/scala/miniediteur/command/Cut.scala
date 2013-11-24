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

	var positionStart = 0
	var positionEnd = 0
	var text = ""
	var textSave = ""
		
	def execute() = {
		val text = ui.copiedValue
		positionStart = ui.positionEnd - ui.lenght
		positionEnd = ui.positionEnd
		textSave = ui.textSave
		buffer.cut(text)
		
		//Save this state in Memento
		originator.set(ui.commandCut)
		caretaker.addMemento(originator.saveToMemento)
		
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