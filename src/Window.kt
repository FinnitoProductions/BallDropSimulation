import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class Window (val backgroundColor : Color = Color.GRAY) : JPanel() {
    override fun paintComponent (g : Graphics) {
        super.paintComponent(g)
        this.background = backgroundColor
    }
}