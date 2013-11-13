package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
/**
 *
 * Class containing Write Command
 * @author AdelineAlex
 *
 */
class Write(var ui: UserInterface) extends Command {

	def execute() = {
		//TODO replace by text from UI
		val t = ""
		buffer.write(t)
	}

}