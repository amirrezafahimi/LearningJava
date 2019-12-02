package ProduceConsume;

/**
 * @author Homayoun Rad
 * Email: AmirRezaFahimi98@Gmail.com
 */

public interface Buffer {

    void blockingPut(int value) throws InterruptedException;

    int blockingGet() throws InterruptedException;
}
