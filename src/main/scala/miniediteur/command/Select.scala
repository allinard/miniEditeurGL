package miniediteur.command

import miniediteur.Command

/**
 *
 * Class containing Select Command
 * @author AdelineAlex
 *
 */
class Select extends Command {

	def execute() = {
		buffer.select()
	}

}