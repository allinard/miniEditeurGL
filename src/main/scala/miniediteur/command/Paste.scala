package miniediteur.command

import miniediteur.Command

/**
 *
 * Class containing Paste Command
 * @author AdelineAlex
 *
 */
class Paste extends Command {

	def execute() = {
		buffer.paste()
	}

}