package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
/**
 *
 * Class containing Move Command
 * @author AdelineAlex
 *
 */
class Move(var ui: UserInterface) extends Command {

	def execute() = {
		buffer.move()
	}

}