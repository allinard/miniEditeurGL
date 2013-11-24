package miniediteur

import miniediteur.ui.UserInterface
import miniediteur.memento._

/**
 *
 * Interface for all commands
 * @author AdelineAlex
 *
 */
trait Command {

	var caretaker : Caretaker
	
	var originator : Originator
	
	var ui : UserInterface
	
	var buffer = Buffer.getInstance
	
	var positionStart : Int

	var positionEnd : Int
	
	var text : String

	var textSave : String 
	
	def execute(): Unit
	
	//def cando() : Unit
	
	def redo() : Unit
	
	def undo() : Unit
	
	def setUi(x: UserInterface){
		ui = x
	}
	

}