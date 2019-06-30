package units

import bezier.OLDunits.derived.AngularVelocity
import bezier.OLDunits.derived.feetPerSecond
import bezier.OLDunits.derived.feetPerSecondSquared
import bezier.OLDunits.derived.inchesPerSecond
import bezier.OLDunits.feet
import bezier.OLDunits.radians
import bezier.OLDunits.seconds
import org.junit.jupiter.api.Test

object VelocityTest {
    @Test
    fun conversionTest() {
        val one = 3.inchesPerSecond()

        val two = 1.feetPerSecond()

        assert(one + two.inchesPerSecond() == 15.inchesPerSecond()) { "Velocity type conversion failed" }
    }

    @Test
    fun multiplicationTest() {
        val one = 4.feetPerSecond()

        val two = 3.seconds()

        assert(one * two == 12.feet()) { "$one, $two" }
    }

    @Test
    fun `division by time`() {
        val one = 6.feetPerSecond()

        val two = 3.seconds()

        assert(one / two == 2.feetPerSecondSquared()) { "$one, $two" }
    }

    @Test
    fun `division by acceleration`() {
        val one = 6.feetPerSecond()

        val two = 3.feetPerSecondSquared()

        assert(one / two == 2.seconds()) { "$one, $two" }
    }

    @Test
    fun `to and from angular velocity`() {
        val linear = 6.feetPerSecond()

        val radius = 3.feet()

        val expected = AngularVelocity(2.radians(), 1.seconds())

        assert(linear / radius == expected) { "$linear, $radius,\n${linear / radius},\n$expected\n" }

        assert(expected * radius == linear) { "$linear, $radius,\n${linear / radius},\n$expected\n" }
    }
//    @Test
//    fun `from angular velocity`() {
//        val one = AngularVelocity<Seconds>()
//    }
}