package org.tage.sample.robot

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/**
 *
 */
class RobotPositionTest {
    @ParameterizedTest
    @MethodSource("samples")
    fun testPosition(exp: Pos, moves: String) {
        assertEquals(exp, finalPosition(moves))
    }

    companion object {
        @JvmStatic fun samples() : Stream<Arguments> = Stream.of(
        Arguments.of(Pos(2, 3),"UDDLLRUUUDUURUDDUULLDRRRR" ),
        Arguments.of(Pos(-2, 1), "DLLRRULUURLLDDU"),
        Arguments.of(Pos(3, 10),"UURRDDLLLLLUUaUUUUxRbRRRRRUUUU"),
        Arguments.of(Pos(-1,1),"LU"))
    }
}
