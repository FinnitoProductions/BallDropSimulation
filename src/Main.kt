import shapes.Ball
import shapes.Floor
import java.awt.Color
import java.awt.Dimension
import javax.swing.JFrame

val FRAME_WIDTH = 700
val FRAME_HEIGHT = 700

/**
 * Starts up the simulation and periodically updates the screen.
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
fun main () {
    val frame = JFrame("Simulation")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.size = Dimension(FRAME_WIDTH, FRAME_HEIGHT)
    val w = Window()
    frame.contentPane.add(w)
    frame.isVisible = true

    val b = Ball(10.0, 10.0, 50)
    val f = Floor(0.0, 500.0, FRAME_WIDTH, 10)

    Thread.sleep(1000)
    f.redraw(w)
    b.redraw(w)

    while (true) {
        val startTime = System.nanoTime()

        b.tick(w)
//        println(System.nanoTime())
//        System.out.println(b.didCollide(f))
//        println(System.nanoTime())
        val endTime = System.nanoTime()

        println(endTime - startTime)
        Thread.sleep(Math.max(0, (FRAME_PERIOD_MS - (endTime - startTime) / (Math.pow(10.0, 6.0))).toLong()))
    }
}
