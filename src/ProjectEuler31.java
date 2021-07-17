import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class ProjectEuler31 {
    final static Integer target = 200;
    final static Set<Map<Integer, Integer>> permutations = new HashSet<>();
    final static Set<Map<Integer, Integer>> memoisedSolutions = new HashSet<>();
    final static List<Integer> coins = List.of(200, 100, 50, 20, 10, 5, 2, 1);

    public static void main(String[] args) {
        coins.forEach(coin -> recurse(Map.of(coin, 1), coin));
        System.out.println(permutations.size());
        System.out.println(permutations);
        System.out.println(memoisedSolutions);
    }

    private static void recurse(final Map<Integer, Integer> purse, final Integer sum) {
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
