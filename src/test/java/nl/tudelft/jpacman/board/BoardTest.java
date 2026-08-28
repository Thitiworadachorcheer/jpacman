package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    /**
     * ข้อ 4: ทดสอบสร้างบอร์ดขนาด 1x1 ที่มี Square ปกติ
     */
    @Test
    void testValidBoard() {
        // สร้างกระดาน 2 มิติ ขนาด 1x1
        Square[][] grid = new Square[1][1];
        // ใส่ตารางปกติ (BasicSquare) ลงไปในช่องแรก (0,0)
        grid[0][0] = new BasicSquare();

        // ประกอบร่างเป็น Board
        Board board = new Board(grid);

        // ตรวจสอบว่า Board นี้สร้างสำเร็จและสมบูรณ์แบบ
        assertThat(board.invariant()).isTrue();
    }
    @Test
    void testNullSquareBoard() {
        // สร้างกระดาน 2 มิติ ขนาด 1x1
        Square[][] grid = new Square[1][1];
        // แกล้งใส่ค่าว่าง (null) ลงไปแทนที่จะใส่ตารางปกติ
        grid[0][0] = null;

        Board board = new Board(grid);

        // ลองสั่งให้ระบบดึงข้อมูลตารางที่ช่อง (0,0) ออกมา
        board.squareAt(0, 0);
    }
}
