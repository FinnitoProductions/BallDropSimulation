import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

/**
 * Represents a custom JPanel to display the simulation.
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
object Window : JPanel() {
    val backgroundColor : Color = Color.GRAY
    override fun paintComponent (g : Graphics) {
        super.paintComponent(g)
        this.background = backgroundColor
    }
}