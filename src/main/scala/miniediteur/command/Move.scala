package miniediteur.command

import miniediteur.Command
import miniediteur.memento._
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Move Command
 * @author AdelineAlex
 *
 */
class Move(var ui: UserInterface, var caretaker : Caretaker, var originator : Originator) extends Command {

	def execute() = {
		buffer.move()
	}

}