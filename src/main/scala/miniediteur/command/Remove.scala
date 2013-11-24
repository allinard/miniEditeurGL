package miniediteur.command

import miniediteur.Command
import miniediteur.memento._
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Remove Command
 * @author AdelineAlex
 *
 */
class Remove(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	def execute() = {
		buffer.remove()
	}
	
	def redo() = {}
	
	def undo() = {}

}