import java.util.concurrent.*;
public class ConnectionPoolMain{
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        System.out.println(classpath);
        System.out.println("Hello");  
       
       /*  int numberOfConnections = 10000;
        for(int i=0;i<numberOfConnections;i++){
            DatabaseConnectionThread dbc = new DatabaseConnectionThread(false);
            Thread thread = new Thread(dbc);
            thread.start();
        } 
       */
         // Start measuring execution time
        long startTime = System.nanoTime();
        int numberOfThreads = 100000;
        int poolSize = 1000; // Adjust this based on your system's capability
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(new DatabaseConnectionThread(true));
        }

        executor.shutdown(); // Initiates an orderly shutdown
        try {
            if (executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
                System.out.println("All threads have finished executing.");
                        // Stop measuring execution time
                 long endTime = System.nanoTime();

                // Calculate the execution time in milliseconds
                 long executionTime = (endTime - startTime) / 1000000;

                System.out.println("100k threads took: "+ executionTime + "ms");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}