import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectEuler31Solver {
    private final Integer target;
    private final List<Integer> coins;
    private final Set<Map<Integer, Integer>> permutations;
    private final Set<Map<Integer, Integer>> memoisedSolutions;

    public static void main(String[] args) {
        ProjectEuler31Solver solver = new ProjectEuler31Solver(50, List.of(50, 20, 10, 5, 2, 1));
        solver.solve();
        System.out.println(solver.permutations.size());
        System.out.println(solver.permutations);
        System.out.println(solver.memoisedSolutions);
    }

    public ProjectEuler31Solver(final int target, final List<Integer> coins) {
        this.target = target;
        this.coins = coins;
        this.permutations = new HashSet<>();
        this.memoisedSolutions = new HashSet<>();
    }

    public int solve() {
        coins.forEach(coin -> recurse(Map.of(coin, 1), coin));
        return permutations.size();
    }

    private void recurse(final Map<Integer, Integer> purse, final Integer sum) {
        if (memoisedSolutions.contains(purse)) {
            return;
        }

        memoisedSolutions.add(purse);

        if (sum < target) {
            coins.forEach(coin -> {
                final Map<Integer, Integer> newPurse = new HashMap<>(purse);
                newPurse.put(coin, purse.getOrDefault(coin, 0) + 1);
                recurse(newPurse, sum + coin);
            });
        }

        if (sum.equals(target)) {
            permutations.add(purse);
        }
    }
}
