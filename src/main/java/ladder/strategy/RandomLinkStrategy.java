package ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLinkStrategy implements LinkStrategy {

    private final static Random random = new Random();

    @Override
    public List<Integer> link(final int column) {
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, column)
            .filter(i -> isLinkable(i, result))
            .forEach(result::add);

        return result;
    }

    private boolean isLinkable(final int index, final List<Integer> linked) {
        int previous = index - 1;
        if (index == 0) {
            previous = 0;
        }

        return random.nextBoolean() && !linked.contains(previous);
    }
}
