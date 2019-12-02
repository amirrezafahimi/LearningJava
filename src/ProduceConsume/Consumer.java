package ProduceConsume;

import java.security.SecureRandom;

/**
 * @author Homayoun Rad
 * Email: AmirRezaFahimi98@Gmail.com
 */

public class Consumer implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {

        int sum = 0;

        try {
            for (int count = 1; count <= 10; count++) {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("%n%s %d%n%s%n",
                "Consumer read values totaling", sum, "Terminating Consumer");
    }
}
