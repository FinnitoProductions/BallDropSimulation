package shapes

import java.awt.Color
import java.awt.Point


/**
 * Represents a general circle.
 *
 * @author Finn Frankis
 * @version 4/6/19
 */
abstract class Circle (xPos : Double, yPos : Double , val radius : Int, color : Color = Color.BLACK, xVel : Double = 0.0, yVel : Double = 0.0, xAccel : Double = 0.0, yAccel : Double = 0.0, xJerk : Double = 0.0, yJerk : Double = 0.0) : Shape (xPos, yPos, xVel, yVel, xAccel, yAccel, xJerk, yJerk, color=color) {

    val center : Point
        get() = Point((xPos + radius.toDouble() / Math.sqrt(2.0)).toInt(), (yPos + radius.toDouble() / Math.sqrt(2.0)).toInt())

    override fun contains (point : Point) = (point.x - center.x) * (point.x - center.x)  + (point.y - center.y) * (point.y - center.y) <= radius * radius
}