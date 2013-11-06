package miniediteur.command

import miniediteur.Command

/**
 * 
 * Class containing Cut Command
 * @author AdelineAlex
 * 
 */
class Cut extends Command {

    def execute() = {
        //TODO replace by text from UI
        val t = ""
            
    	buffer.cut(t)
    	
    }

}