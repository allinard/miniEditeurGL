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
	
	val commandCopy = new Copy(this,caretaker,originator)
	val commandCut = new Cut(this,caretaker,originator)
	val commandMove = new Move(this,caretaker,originator)
	val commandPaste = new Paste(this,caretaker,originator)
	val commandRemove = new Remove(this,caretaker,originator)
	val commandSelect = new Select(this,caretaker,originator)
	val commandWrite = new Write(this,caretaker,originator)


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
	 * The UI
	 */
	def top = new MainFrame {

		//Title of the frame
		title = "MiniEditeur GL"

		//Object containing the text area (defined size between brackets)
		object textarea extends TextArea { columns = 50; rows = 10 }
		
		//Variable for the cursor
		val c = textarea.caret
			
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
				if (textarea.selected != null){
					copiedValue = textarea.selected
					positionEnd= c.position
					lenght = textarea.selected.length()
					textarea.copy
					commandCopy.execute
				}

			case ButtonClicked(`buttonPaste`) =>
				positionEnd= c.position
				textarea.paste
				commandPaste.execute

			case ButtonClicked(`buttonCut`) =>
				
				if (textarea.selected != null){
					copiedValue = textarea.selected
					positionEnd= c.position
					lenght = textarea.selected.length()
					textarea.cut
					commandCut.execute
				}
				
				

			case ButtonClicked(`buttonUndo`) =>
				if (caretaker.savedStates.size()>1){
					var state = caretaker.getMemento()
					originator.restoreFromMemento(state)
					state.undo
				}
				
			case ButtonClicked(`buttonRedo`) =>
				var state = caretaker.getMemento()
				caretaker.addMemento(state)
				//test si il faut ecrire dans le textarea
				if (state.getClass() == classOf[Paste]){
					textarea.paste 
				}
				state.redo()

		}
	}
	
	


}