import java.util.*;

public class task3 extends Thread {
    private Thread t;
    private int priority;
    private int sleep;

    private createObject mat = new createObject();
    private createObject vec = new createObject();
    private operations operation = new operations();

    private float[][] MS, MT;
    private float[] O, P, result;
    private int size;

    public task3(int prior, int delay) {
        priority = prior;
        sleep = delay;
        System.out.println("Start Task3" );
        if(t == null) {
            t = new Thread(this, "Task3");
            t.setPriority(priority);
        }
    }
    
    
    @Override
    public void run() {
        System.out.println("Running Task 3 Thread...\n");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        size = 1000;

        MS = mat.CreateRandomMatrix(size);
        MT = mat.CreateRandomMatrix(size);
        O = vec.CreateRandomVector(size);
        P = vec.CreateRandomVector(size);

        result = operation.SubVectors(operation.MultiplyMatrixVector(operation.SortMatrix(operation.MultiplyMatrix(MS, MT)), O), P);
    
        System.out.print("Task3 result:\n");
        System.out.println(Arrays.toString(result));
        System.out.println();
    }
}