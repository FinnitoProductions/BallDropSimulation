package shapes

import Window
import java.awt.Color
import java.awt.Graphics
import java.awt.Point

class Ball (xPos : Double, yPos: Double, val radius : Int, color : Color = Color.RED) : Shape(xPos, yPos, color=color, yVel=50.0, yAccel = 50.0, xVel = 50.0, xAccel = 50.0) {
    override fun redraw (w : Window) {
        var g : Graphics = w.graphics

        g.color = w.backgroundColor
        g.fillOval(oldXPos.toInt(), oldYPos.toInt(), radius, radius)

        g.color = color
        g.fillOval(xPos.toInt(), yPos.toInt(), radius, radius)


        println("OLD: ($oldXPos, $oldYPos); NEW: ($xPos, $yPos)")
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
}