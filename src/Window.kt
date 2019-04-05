import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class Window (val backgroundColor : Color = Color.GRAY) : JPanel() {
    lateinit var g : Graphics

    override fun paintComponent (g : Graphics) {
        super.paintComponent(g)
        this.g = g
        this.background = backgroundColor
    }
}