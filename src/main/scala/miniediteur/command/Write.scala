package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
import miniediteur.memento._

/**
 *
 * Class containing Write Command
 * @author AdelineAlex
 *
 */
class Write(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	var positionStart = 0
	var positionEnd = 0
	var text : String = ""
	var textSave = ""
	
	def execute() = {
		//TODO replace by text from UI
		
		buffer.write(text)
	}
	
	def redo() = {}
	
	def undo() = {}

}