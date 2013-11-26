package miniediteur.ui

import swing._
import miniediteur.memento._
import event._
import javax.swing.plaf.basic.BasicArrowButton
import miniediteur.command._
import miniediteur.Command

/**
 *
 * Class containing the User Interface
 * @author AdelineAlex
 * @todo une belle IHM dans une webapp peut etre
 *
 */
class UserInterface extends SimpleSwingApplication {

	/**
	 * All concrete commands
	 */
	val caretaker = new Caretaker()
	var originator = new Originator(null)
	
	/**
	 * Variable containing user interface
	 */
	val ui = this

	/**
	 * Variable containing the copied value (or pasted) in the text editor
	 */
	var copiedValue: String = ""
		
	/**
	 * Variable containing the value to paste the text editor
	 */
	var pasteValue: String = ""

		
	/**
	 *  Variable containing the value of ending selection
	 */	
	var positionEnd : Int = 0
	
	/**
	 * Variable containing length of selection
	 */
	var lenght : Int = 0
	
	
	/**
	 * Variable test if undo function
	 */
	var undo : Boolean = false
	
	/**
	 * Variable save text in textarea
	 */
	var textSave : String = ""
		
		
	//val newState : Command 
		
	/**
	 * The UI
	 */
	def top = new MainFrame {

		//Title of the frame
		title = "MiniEditeur GL"

		//Object containing the text area (defined size between brackets)
		object textarea extends TextArea { columns = 50; rows = 10 }
		
		//Variable for the cursor
		val caret = textarea.caret
			
		//Variable for the Copy Button
		val buttonCopy = new Button {
			text = "Copy"
		}

		//Variable for the Paste Button
		val buttonPaste = new Button {
			text = "Paste"
		}

		//Variable for the Cut Button
		val buttonCut = new Button {
			text = "Cut"
		}

		//Variable for the UNDO Button
		val buttonUndo = new Button {
			text = "<-"
		}

		//Variable for the REDO Button
		val buttonRedo = new Button {
			text = "->"
		}

		//Components of the Frame
		contents = new FlowPanel {
			contents += new Label(" Editeur de texte ")

			contents += new ScrollPane(textarea)

			contents += buttonCopy
			contents += buttonCut
			contents += buttonPaste
			contents += buttonUndo
			contents += buttonRedo

			border = Swing.EmptyBorder(15, 10, 10, 10)
		}

		//Adding listeners on buttons
		listenTo(buttonCopy, buttonPaste, buttonCut, buttonUndo, buttonRedo)

		//Implementing actions
		reactions += {
			case ButtonClicked(`buttonCopy`) =>
				val commandCopy = new Copy(ui,caretaker,originator)
				if (textarea.selected != null){
					copiedValue = textarea.selected
					positionEnd= caret.position
					lenght = textarea.selected.length()
					textSave = textarea.text
					textarea.copy
					commandCopy.execute
				}

			case ButtonClicked(`buttonPaste`) =>
				val commandPaste = new Paste(ui,caretaker,originator)
				positionEnd= caret.position
				textSave = textarea.text
				println (" Pasteeeee : " + textSave)
				textarea.paste
				commandPaste.execute

			case ButtonClicked(`buttonCut`) =>
				val commandCut = new Cut(ui,caretaker,originator)
				if (textarea.selected != null){
					copiedValue = textarea.selected
					positionEnd= caret.position
					lenght = textarea.selected.length()
					textSave = textarea.text
					textarea.cut
					commandCut.execute
				}
				
				

			case ButtonClicked(`buttonUndo`) =>
				//println(" Undoooo before : " + textSave );
				if (caretaker.savedStates.size()>0){
					var mem = caretaker.getMemento()
					originator.restoreFromMemento(mem)	
					mem.stateMem.undo
					textarea.text = textSave
				//	println(" Undoooo after : " + textSave )
				}
				else 
				{ 
					textarea.text = ""
				}
				
			case ButtonClicked(`buttonRedo`) =>
				//test size of memento stack
				if ( caretaker.savedStates.size > 0){ 
					var mem = caretaker.getMemento()
					caretaker.addMemento(mem)
					textSave = textarea.text
					//impossible to do a switch case with getClass
					//Create new command eq state 
					if (mem.stateMem.getClass()== classOf[Cut]){
							val newState = new Cut(mem.stateMem.ui,mem.stateMem.caretaker, mem.stateMem.originator)
							newState.text = mem.stateMem.text
							newState.redo()
					}
					else if (mem.stateMem.getClass() == classOf[Copy]){
							val newState = new Copy(mem.stateMem.ui,mem.stateMem.caretaker, mem.stateMem.originator)
							newState.text = mem.stateMem.text
							newState.redo()
					} 		
					else if (mem.stateMem.getClass() == classOf[Paste]){
							val newState = new Paste(mem.stateMem.ui,mem.stateMem.caretaker, mem.stateMem.originator)
							newState.text = mem.stateMem.text
							textarea.paste
							newState.redo()
					}
					
				}
		}
	}
	
	


}