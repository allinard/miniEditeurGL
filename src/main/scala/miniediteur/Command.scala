package miniediteur

/**
 * 
 * Interface for all commands
 * @author AdelineAlex
 * 
 */
trait Command {

    var buffer = new Buffer
    
    def execute() : Unit
    
}