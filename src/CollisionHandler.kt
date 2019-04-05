import shapes.Shape

class CollisionHandler (private val shapes : ArrayList<Shape>) {

    fun tick(w : Window) {
        for (s1 in shapes) {
            for (s2 in shapes) {
                if (s1 != s2 && s1.didCollide(s2)) {
                    s1.xVel = 0.0
                    s1.yVel = 0.0

                    s1.xAccel = 0.0
                    s1.yAccel = 0.0
                }
            }
        }
    }
}