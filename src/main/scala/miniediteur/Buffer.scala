package miniediteur

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
    }

    /**
     * Method to cut a text
     */
    def cut(t: String): Unit = {
    		clipBoard.setText(t)
    }

    /**
     * Method to move a text
     */
    def move(): Unit = {
    		//TODO
    }

    /**
     * Method to paste a text
     */
    def paste(): String = {
    		return clipBoard.getText
    }

    /**
     * Method to remove a text
     */
    def remove(): Unit = {
    		//TODO on efface donc mettre dans le buffer quand meme pour etape 2
    }

    /**
     * Method to select a text
     */
    def select(): Unit = {

    }

    /**
     * Method to write a text
     */
    def write(lastChar: String): Unit = {
    		texte.append(lastChar)
    }
    
}