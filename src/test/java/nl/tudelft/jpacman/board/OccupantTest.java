package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // สร้างช่องตารางจำลองขึ้นมา 1 ช่อง
        Square square = new BasicSquare();

        // สั่งให้ Unit เข้าไปจองพื้นที่ตาราง
        unit.occupy(square);

        // ตรวจสอบว่า Unit จำได้ว่าตัวเองอยู่ช่องนี้
        assertThat(unit.getSquare()).isEqualTo(square);

        // ตรวจสอบว่าตารางช่องนั้น ก็รู้ว่ามี Unit นี้อยู่ข้างใน
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // สร้างช่องตาราง 2 ช่องที่ต่างกัน
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();

        // ให้ Unit ไปอยู่ช่องที่ 1 ก่อน
        unit.occupy(square1);

        // แล้วสั่งให้ย้ายไปช่องที่ 2 ซ้ำอีกครั้ง
        unit.occupy(square2);

        // ตรวจสอบว่า Unit ต้องไปอยู่ช่องที่ 2 แล้ว
        assertThat(unit.getSquare()).isEqualTo(square2);

        // ตรวจสอบว่า Unit ต้องไม่อยู่ในช่องที่ 1 แล้ว (เพราะย้ายออกไปแล้ว)
        assertThat(square1.getOccupants()).doesNotContain(unit);
    }
}
