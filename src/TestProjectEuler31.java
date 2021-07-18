import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProjectEuler31 {
    @Test
    public void test50PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(50, List.of(50, 20, 10, 5, 2, 1));

        assertEquals(451, solver.solve());
    }

    @Test
    public void test20PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(20, List.of(20, 10, 5, 2, 1));

        assertEquals(41, solver.solve());
    }

    @Test
    public void test10PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(10, List.of(10, 5, 2, 1));

        assertEquals(11, solver.solve());
    }

    @Test
    public void test5PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(5, List.of(5, 2, 1));

        assertEquals(4, solver.solve());
    }

    @Test
    public void test2PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(2, List.of(2, 1));

        assertEquals(2, solver.solve());
    }

    @Test
    public void test21PCoin() {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(1, List.of(1));

        assertEquals(1, solver.solve());
    }
}
