package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
/**
 *
 * Class containing Paste Command
 * @author AdelineAlex
 *
 */
class Paste(var ui: UserInterface) extends Command {

	def execute() = {
		val pastedText = buffer.paste()
	}

}