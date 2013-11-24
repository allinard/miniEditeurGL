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
	
	
	def execute() = {
		//TODO replace by text from UI
		val t = ""
		buffer.write(t)
	}
	
	def redo() = {}
	
	def undo() = {}

}