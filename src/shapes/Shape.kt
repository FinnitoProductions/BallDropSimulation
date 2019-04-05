package shapes

import java.awt.Point

abstract class Shape  {
    abstract fun getPoints() : ArrayList<Point>
    abstract fun getBoundingPoints() : ArrayList<Point>

    fun didCollide (s: Shape) : Boolean {
        val sPoints = s.getBoundingPoints()
        val points = getBoundingPoints()

        for (p1 in sPoints) {
            for (p2 in points) {
                if (p1 == p2 ) { return true }
            }
        }

        return false
    }
}