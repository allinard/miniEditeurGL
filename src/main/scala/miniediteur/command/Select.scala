package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Select Command
 * @author AdelineAlex
 *
 */
class Select(var ui: UserInterface) extends Command {

	def execute() = {
		buffer.select()
	}

}