package shapes

import java.awt.Color
import java.awt.Point

/**
 * Represents a general, unrotated rectangle.
 *
 * @author Finn Frankis
 * @version 4/6/19
 */
abstract class Rectangle (xPos : Double, yPos : Double , val width : Int, val height : Int, color : Color = Color.BLACK) : Shape (xPos, yPos, color=color) {

    val topLeftVertex : Point
        get () {
            return Point(xPos.toInt(), yPos.toInt())
        }
    val topRightVertex : Point
        get() {
            return Point((xPos + width).toInt(), yPos.toInt())
        }
    val bottomLeftVertex : Point
        get() {
            return Point(xPos.toInt(), (yPos + height).toInt())
        }
    val bottomRightVertex : Point
        get() {
            return Point((xPos + width).toInt(), (yPos + height).toInt())
        }

    override fun contains (point : Point) : Boolean = point.x > topLeftVertex.x && point.x < topRightVertex.x && point.y > topLeftVertex.y && point.y < bottomLeftVertex.y
}