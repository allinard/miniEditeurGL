package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Copy Command
 * @author AdelineAlex
 *
 */
class Copy(var ui: UserInterface) extends Command {

	def execute() = {
		val t = ui.copiedValue

		buffer.copy(t)
	}

}