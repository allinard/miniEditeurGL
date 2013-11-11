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
	 * 
	 */
	var copiedValue: String = ""
	
	/**
	 *
	 */
	var debut: Int = 0

	/**
	 *
	 */
	var fin: Int = 0

	/**
	 *
	 */
	def top = new MainFrame {

		title = "MiniEditeur GL"

		object textarea extends TextArea { columns = 50; rows = 10 }

		val buttonCopy = new Button {
			text = "Copy"
		}
		val buttonPaste = new Button {
			text = "Paste"
		}

		val buttonCut = new Button {
			text = "Cut"
		}

		contents = new FlowPanel {
			contents += new Label(" Editeur de texte ")
			contents += buttonCopy
			contents += buttonCut
			contents += buttonPaste
			contents += textarea
			border = Swing.EmptyBorder(15, 10, 10, 10)
		}
		
		listenTo(buttonCopy, buttonPaste, buttonCut)
		
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