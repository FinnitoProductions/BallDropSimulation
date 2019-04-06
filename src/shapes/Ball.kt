package shapes

import Window
import java.awt.Color
import java.awt.Graphics
import java.awt.Point

/**
 * Represents a ball, or a circular, mobile shape.
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
class Ball (xPos : Double, yPos: Double, radius : Int, color : Color = Color.RED) : Circle(xPos, yPos, radius, color=color, yVel=50.0, yAccel = 50.0) {
    override fun redraw () {
        var g : Graphics = Window.graphics

        g.color = Window.backgroundColor
        g.fillOval(oldXPos.toInt(), oldYPos.toInt(), radius, radius)

        g.color = color
        g.fillOval(xPos.toInt(), yPos.toInt(), radius, radius)
    }

    override fun getPoints () : ArrayList<Point> {
        val arr = ArrayList<Point>()

        val centerX = (xPos + radius.toDouble() / Math.sqrt(2.0))
        val centerY = (yPos + radius.toDouble() / Math.sqrt(2.0))

        for (xVal in -radius..radius) {
            for (yVal in -radius..radius) {
                if (xVal * xVal + yVal * yVal <= radius * radius) { // point is in the circle
                    arr.add(Point((xVal + centerX).toInt(), (yVal + centerY).toInt()))
                }
            }
        }

        return arr
    }

    override fun getBoundingPoints() : ArrayList<Point> {
        val arr = ArrayList<Point>()

        val centerX = (xPos + radius.toDouble() / Math.sqrt(2.0))
        val centerY = (yPos + radius.toDouble() / Math.sqrt(2.0))

        for (xVal in -radius..radius) {
            for (yVal in -radius..radius) {
                if (xVal * xVal + yVal * yVal == radius * radius) { // point is on the circle
                    arr.add(Point((xVal + centerX).toInt(), (yVal + centerY).toInt()))
                }
            }
        }

        return arr
    }

    override fun didCollide(s : Shape) : Boolean {
        if (s is Floor) {

        }
        else if (s is Ball) {

        }
        return false
    }

}