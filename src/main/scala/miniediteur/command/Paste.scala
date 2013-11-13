package miniediteur.command

import miniediteur.Command
import miniediteur.ui.UserInterface
import miniediteur.Buffer
/**
 *
 * Class containing Paste Command
 * @author AdelineAlex
 *
 */
class Paste(var ui: UserInterface) extends Command {

	def execute() = {
		ui.pasteValue = buffer.paste()
	}

}