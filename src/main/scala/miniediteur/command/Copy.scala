package miniediteur.command

import miniediteur.Command

/**
 *
 * Class containing Copy Command
 * @author AdelineAlex
 *
 */
class Copy extends Command {

	def execute() = {
		//TODO replace by text from UI
		val t = ""

		buffer.copy(t)
	}

}