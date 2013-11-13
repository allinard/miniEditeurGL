package miniediteur

/**
 *
 * Class containing the Clipboard
 * @author AdelineAlex
 *
 */
class Clipboard {

	/**
	 * Variable containing copied or cut text from buffer
	 */
	//TODO VERSION 2 : REMPLACER par LIST or MAP pour pouvoir sauvegarder les textes copies
	var text: String = ""

	/**
	 * Method adding text to clipboard
	 * @param Text from Buffer to put into clipboard
	 */
	def setText(t: String): Unit = {
		text = t
		println(text+" copied into clipboard")
	}

	/**
	 * Method returning clipboard contained text
	 */
	def getText(): String = {
		return text
	}

}