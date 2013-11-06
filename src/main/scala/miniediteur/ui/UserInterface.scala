package miniediteur.ui

import scala.swing.{ SimpleSwingApplication, MainFrame, Button }

/**
 * 
 * Class containing the User Interface
 * @author AdelineAlex
 * @todo une belle IHM dans une webapp peut être
 * 
 */
object UserInterface extends SimpleSwingApplication {
    
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
        title = "Hello, World!"
        contents = new Button {
            text = "Click Me!"
        }
    }

}