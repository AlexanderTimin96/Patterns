import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int max;
    protected int min;

    public Randoms(int min, int max) {
        random = new Random();
        this.max = max;
        this.min = min;
    }

   Iterator<Integer> iterator = new Iterator<>() {
       @Override
       public boolean hasNext() {
           return true;
       }

       @Override
       public Integer next() {
           return min + random.nextInt((max - min) + 1);
       }
   };

    @Override
    public Iterator<Integer> iterator() {
        return iterator;
    }
}