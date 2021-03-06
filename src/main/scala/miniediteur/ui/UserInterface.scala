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
	 * The caretaker (cf. Memento)
	 */
	val caretaker = new Caretaker()
	
	/**
	 * The originator (cf. Memento)
	 */
	var originator = new Originator(null)
	
	/**
	 * All concrete commands
	 */
	val commandCopy = new Copy(this,caretaker,originator)
	val commandCut = new Cut(this,caretaker,originator)
	val commandPaste = new Paste(this,caretaker,originator)


	/**
	 * Variable containing the copied value (or pasted) in the text editor
	 */
	var copiedValue: String = ""
		
	/**
	 * Variable containing the value to paste the text editor
	 */
	var pasteValue: String = ""

	/**
	 * The UI
	 */
	def top = new MainFrame {

		//Title of the frame
		title = "MiniEditeur GL"

		//Object containing the text area (defined size between brackets)
		object textarea extends TextArea { columns = 50; rows = 10 }

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
					textarea.copy
					commandCopy.execute
				}

			case ButtonClicked(`buttonPaste`) =>
				textarea.paste
				commandPaste.execute

			case ButtonClicked(`buttonCut`) =>
				
				if (textarea.selected != null){
					copiedValue = textarea.selected
					textarea.cut
					commandCut.execute
				}
				
				

			//case ButtonClicked(`buttonUndo`) =>
				//originator.restoreFromMemento(caretaker.getMemento)
				
			case ButtonClicked(`buttonRedo`) =>
				var mem = caretaker.getMemento()
				
				//test si il faut ecrire dans le textarea
				if (mem.state.getClass() == classOf[Paste]){
					textarea.paste 
				}
				mem.state.redo()

		}
	}
	
	


}