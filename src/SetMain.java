import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i =0; i <= 100; i++)
        {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        Set<Integer> union = new HashSet<>(squares);

        union.addAll(cubes);

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
    }
}
