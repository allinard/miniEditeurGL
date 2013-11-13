package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
/**
 *
 * Class containing Remove Command
 * @author AdelineAlex
 *
 */
class Remove(var ui: UserInterface) extends Command {

	def execute() = {
		buffer.remove()
	}

}