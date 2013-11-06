package miniediteur.command

import miniediteur.Command

/**
 * 
 * Class containing Write Command
 * @author AdelineAlex
 * 
 */
class Write extends Command {

    def execute() = {
        //TODO replace by text from UI
        val t =""
    	buffer.write(t)
    }

}