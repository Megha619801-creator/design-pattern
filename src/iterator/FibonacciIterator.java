package iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    /*
     * Design decision:
     * The state of Fibonacci calculation is stored here in the iterator,
     * not in FibonacciSequence.
     *
     * Rationale:
     * - Each iterator is independent.
     * - Multiple iterators can iterate over the same sequence separately.
     * - No shared mutable state.
     * - Follows standard Iterator pattern behavior.
     */

    private int count = 0;
    private int limit;

    private int previous = 1;
    private int current = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return count < limit;
    }

    @Override
    public Integer next() {
        count++;

        if (count == 1 || count == 2) {
            return 1;
        }

        int nextValue = previous + current;
        previous = current;
        current = nextValue;

        return nextValue;
    }
}