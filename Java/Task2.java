import java.util.*;

public class task2 extends Thread {
    private Thread t;
    private int priority;
    private int sleep;

    private createObject mat = new createObject();
    private operations operation = new operations();

    private float[][] MG, MH, MK, ML, result;
    private int size;

    public task2(int prior, int delay) {
        priority = prior;
        sleep = delay;
        System.out.println("Start Task2" );
        if(t == null) {
            t = new Thread(this, "Task2");
            t.setPriority(priority);
        }
    }
    
    
    @Override
    public void run() {
        System.out.println("Running Task 2 Thread...\n");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        size = 1000;

        MG =  mat.CreateRandomMatrix(size);
        MH =  mat.CreateRandomMatrix(size);
        MK =  mat.CreateRandomMatrix(size);
        ML =  mat.CreateRandomMatrix(size);

        result = operation.MultiplyMatrix(operation.MultiplyMatrix(MG, MH),operation.SumMatrix(MK, ML));
        System.out.print("Task2 result:\n");

        for(int i=0; i<size; i++){
            System.out.println(Arrays.toString(result[i]));
        }
        System.out.println();
    }
}