import shapes.Shape

/**
 * Handles collisions, stopping any moving shapes when they collide.
 *
 * @author Finn Frankis
 * @version 4/5/19
 */
class CollisionHandler (private val shapes : ArrayList<Shape>) {

    fun tick() {
        for (s1 in shapes) {
            for (s2 in shapes) {
                if (s1 != s2 && s1.didCollide(s2)) {
                    for (s in arrayOf(s1, s2)) {
                        s.apply {
                            xVel = 0.0
                            yVel = 0.0

                            xAccel = 0.0
                            yAccel = 0.0

                            xJerk = 0.0
                            yJerk = 0.0
                        }
                    }
                }
            }
        }
    }
}