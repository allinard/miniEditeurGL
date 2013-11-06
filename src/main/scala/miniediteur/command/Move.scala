package miniediteur.command

import miniediteur.Command

/**
 *
 * Class containing Move Command
 * @author AdelineAlex
 *
 */
class Move extends Command {

	def execute() = {
		buffer.move()
	}

}