package shapes

import java.awt.Color
import java.awt.Graphics
import java.awt.Point
import Window

class Floor (val xPos : Double, val yPos : Double , val width : Int, val height : Int, val color : Color = Color.BLACK) : Shape() {
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

    fun drawFloor (w : Window) {
        var g : Graphics = w.graphics

        g.color = this.color
        g.fillRect(xPos.toInt(), yPos.toInt(), width, height)
    }
}