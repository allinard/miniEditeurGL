package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
import miniediteur.memento._


/**
 *
 * Class containing Select Command
 * @author AdelineAlex
 *
 */
class Select(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	var positionStart = 0
	var positionEnd = 0
	var text : String = ""
	var textSave = ""

	def execute() = {
		buffer.select()
	}
	
	def redo() = {}
	
	def undo() = {}

}