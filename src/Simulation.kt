import shapes.Ball
import shapes.Floor
import shapes.Shape
import java.awt.Dimension
import java.lang.Exception
import javax.swing.JFrame

/**
 * Handles the overarching process of beginning and operating the simulation.
 *
 * @author Finn Frankis
 * @version 4/5/19
 */
object Simulation {
    lateinit var handler : CollisionHandler
    val shapes : ArrayList<Shape>
    var hasStarted : Boolean

    init {
        val frame = JFrame("Simulation")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(FRAME_WIDTH, FRAME_HEIGHT)
        frame.contentPane.add(Window)
        frame.isVisible = true

        shapes = ArrayList<Shape>()
        hasStarted = false
    }

    fun addShape(vararg shapes : Shape) {
        if (!hasStarted) {
            for (s in shapes) {
                this.shapes.add(s)
            }
        } else {
            throw Exception("You cannot add a shape after the simulation has begun.")
        }
    }

    fun start() {
        if (!hasStarted) {
            handler = CollisionHandler(shapes)

            for (s in shapes) {
                s.redraw()
            }

            hasStarted = true
        } else {
            throw Exception("The simulation has already started.")
        }
    }

    fun tick() {
        val startTime = System.nanoTime()

        for (s in shapes) {
            s.tick()
        }

        handler.tick()

        val endTime = System.nanoTime()

        Thread.sleep(Math.max(0, (FRAME_PERIOD_MS - (endTime - startTime) / (Math.pow(10.0, 6.0))).toLong()))
    }
}