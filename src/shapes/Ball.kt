package shapes

import FRAME_PERIOD_S
import Window
import java.awt.Color
import java.awt.Graphics
import java.awt.Point

class Ball : Shape {
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

    var radius : Int
    var color : Color

    var oldXPos = 0.0
    var oldYPos = 0.0

    var xVel = 0.0
    var xAccel = 0.0
    var xJerk = 0.0

    var yVel = 50.0 // units per second
    var yAccel = 50.0 // units per second per second
    var yJerk = 0.0


    constructor (xPos : Double, yPos: Double, radius : Int, color : Color = Color.RED) {
        this.xPos = xPos
        this.yPos = yPos
        this.radius = radius
        this.color = color

        this.oldXPos = xPos
        this.oldYPos = yPos
    }

    fun redrawBall (w : Window) {
        var g : Graphics = w.graphics

        g.color = color
        g.fillOval(xPos.toInt(), yPos.toInt(), radius, radius)

        g.color = w.backgroundColor
        g.fillOval(oldXPos.toInt(), oldYPos.toInt(), radius, radius)

        println("OLD: ($oldXPos, $oldYPos); NEW: ($xPos, $yPos)")
    }

    fun tick (w : Window) {
        xPos += xVel * FRAME_PERIOD_S
        yPos += yVel * FRAME_PERIOD_S

        xVel += xAccel * FRAME_PERIOD_S
        yVel += yAccel * FRAME_PERIOD_S

        redrawBall(w)
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