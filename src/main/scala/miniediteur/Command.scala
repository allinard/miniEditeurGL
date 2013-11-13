package miniediteur

import miniediteur.ui.UserInterface

/**
 *
 * Interface for all commands
 * @author AdelineAlex
 *
 */
trait Command {

	var ui : UserInterface
	
	var buffer = Buffer.getInstance

	def execute(): Unit
	
	def setUi(x: UserInterface){
		ui = x
	}
	

}