package shapes

import FRAME_PERIOD_S
import Window
import java.awt.Color
import java.awt.Point

/**
 * Represents a general shape with given position, velocity, acceleration, and jerk.
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
abstract class Shape {
    var xPos : Double
        set (value) {
            oldXPos = xPos
            field = value
        }
    var yPos : Double
        set (value) {
            oldYPos = yPos
            field = value
        }

    var oldXPos : Double
    var oldYPos : Double

    var xVel : Double
    var xAccel : Double
    var xJerk : Double

    var yVel : Double
    var yAccel : Double
    var yJerk : Double

    var color : Color

    abstract fun getPoints() : ArrayList<Point>
    abstract fun getBoundingPoints() : ArrayList<Point>
    abstract fun redraw(w : Window)

    constructor (xPos : Double, yPos: Double, xVel : Double = 0.0, yVel : Double = 0.0, xAccel : Double = 0.0, yAccel : Double = 0.0, xJerk : Double = 0.0, yJerk : Double = 0.0, color : Color = Color.RED)  {
        this.xPos = xPos
        this.yPos = yPos
        this.color = color

        this.oldXPos = xPos
        this.oldYPos = yPos
        this.color = color

        this.xVel = xVel
        this.yVel = yVel

        this.xAccel = xAccel
        this.yAccel = yAccel

        this.xJerk = xJerk
        this.yJerk = yJerk
    }

    fun didCollide (s: Shape) : Boolean {
        val sPoints = s.getBoundingPoints()
        val points = getBoundingPoints()

        for (p1 in sPoints) {
            for (p2 in points) {
                if (p1 == p2) { return true }
            }
        }

        return false
    }

    fun tick (w : Window) {
        xPos += xVel * FRAME_PERIOD_S
        yPos += yVel * FRAME_PERIOD_S

        xVel += xAccel * FRAME_PERIOD_S
        yVel += yAccel * FRAME_PERIOD_S

        xAccel += xJerk * FRAME_PERIOD_S
        yAccel += yJerk * FRAME_PERIOD_S

        redraw(w)
    }
}