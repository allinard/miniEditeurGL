package miniediteur

import miniediteur.ui.UserInterface

/**
 *
 * Class containing the Buffer
 * @author AdelineAlex
 *
 */
class Buffer {

	val clipBoard = new Clipboard

	val texte = new StringBuffer
	

	/**
	 * Method to copy a text
	 */
	def copy(t: String): Unit = {
		clipBoard.setText(t)
		println(t+" copied into clipboard")
	}

	/**
	 * Method to cut a text
	 */
	def cut(t: String): Unit = {
		clipBoard.setText(t)
		println(t+" cut into clipboard")
	}


	/**
	 * Method to paste a text
	 */
	def paste(): String = {
		println(clipBoard.getText+" read and pasted from clipboard")
		return clipBoard.getText
	}



}


/**
 * Singleton Container
 */
object Buffer {

   val singleton = new Buffer

   def getInstance: Buffer = {
      return singleton;
   }

}
