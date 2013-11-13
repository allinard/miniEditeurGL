package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface

/**
 *
 * Class containing Cut Command
 * @author AdelineAlex
 *
 */
class Cut(var ui: UserInterface) extends Command {

	def execute() = {
		//TODO replace by text from UI
		val t = ""

		buffer.cut(t)

	}

}