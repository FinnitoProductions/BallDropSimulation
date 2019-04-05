import shapes.Ball
import shapes.Floor
import shapes.Shape
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame

const val FRAME_WIDTH = 700
const val FRAME_HEIGHT = 700

/**
 * Starts up the simulation and periodically updates the screen.
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
fun main () {
    Simulation.addShape(Ball(10.0, 10.0, 50))
    Simulation.addShape(Floor(0.0, 500.0, FRAME_WIDTH, 10))

    Simulation.start()

    while (true) {
        Simulation.tick()
    }
}
