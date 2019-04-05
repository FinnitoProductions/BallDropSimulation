package shapes

import java.awt.Color
import java.awt.Graphics
import java.awt.Point
import Window

/**
 * Represents a floor shape (any kind of immobile, physical barrier).
 *
 * @author Finn Frankis
 * @since 4/4/19
 */
class Floor (xPos : Double, yPos : Double , val width : Int, val height : Int, color : Color = Color.BLACK) : Shape(xPos, yPos, color=color) {
    override fun getPoints() : ArrayList<Point> {
        val arr = ArrayList<Point>()
        for (yVal in yPos.toInt()..(yPos + height).toInt()) {
            for (xVal in xPos.toInt()..(xPos + width).toInt()) {
                arr.add (Point(xVal, yVal))
            }
        }
        return arr
    }

    override fun getBoundingPoints() : ArrayList<Point> {
        val arr = ArrayList<Point>()

        for (xVal in xPos.toInt()..(xPos + width).toInt()) {
            arr.add(Point(xVal, yPos.toInt()))
            arr.add(Point(xVal, (yPos + width).toInt()))
        }

        for (yVal in yPos.toInt()..(yPos + width).toInt()) {
            arr.add(Point(xPos.toInt(), xPos.toInt()))
            arr.add(Point(xPos.toInt(), (xPos + width).toInt()))
        }

        return arr
    }

    override fun redraw () {
        var g : Graphics = Window.graphics

        g.color = Window.backgroundColor
        g.fillRect(oldXPos.toInt(), oldYPos.toInt(), width, height)

        g.color = this.color
        g.fillRect(xPos.toInt(), yPos.toInt(), width, height)
    }
}