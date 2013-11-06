package miniediteur.command

import miniediteur.Command

/**
 * 
 * Class containing Remove Command
 * @author AdelineAlex
 * 
 */
class Remove extends Command {

    def execute() = {
    	buffer.remove()
    }

}