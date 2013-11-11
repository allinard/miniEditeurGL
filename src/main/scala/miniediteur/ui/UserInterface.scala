package miniediteur.ui

import swing._
import event._

/**
 *
 * Class containing the User Interface
 * @author AdelineAlex
 * @todo une belle IHM dans une webapp peut �tre
 *
 */
object UserInterface extends SimpleSwingApplication {

	/**
	 * Variable containing the copied value in the text editor
	 */
	var copiedValue: String = ""
	
	/**
	 * @TODO For Saved Actions
	 */
	var debut: Int = 0

	/**
	 * @TODO For Saved Actions
	 */
	var fin: Int = 0

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

		//Components of the Frame
		contents = new FlowPanel {
			contents += new Label(" Editeur de texte ")
			contents += buttonCopy
			contents += buttonCut
			contents += buttonPaste
			contents += textarea
			border = Swing.EmptyBorder(15, 10, 10, 10)
		}
		
		//Adding listeners on buttons
		listenTo(buttonCopy, buttonPaste, buttonCut)
		
		//Implementing actions
		reactions += {
			case ButtonClicked(`buttonCopy`) =>
		      copiedValue = textarea.selected
		      textarea.copy
		      println("copying: "+copiedValue)
		      
			case ButtonClicked(`buttonPaste`) =>
		      textarea.paste
		      println("pasting: "+copiedValue)

		    case ButtonClicked(`buttonCut`) =>
			  copiedValue = textarea.selected
			  textarea.cut
		      println("cutting: "+copiedValue)

		}
		
	}

}