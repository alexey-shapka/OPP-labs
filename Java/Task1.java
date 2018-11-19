public class task1 extends Thread {
    private Thread t;
    private int priority;
    private int sleep;

    private createObject mat = new createObject();
    private createObject vec = new createObject();
    private operations operation = new operations();

    private float[][] MA, ME;
    private float[] A, B, C;
    private float result;
    private int size;

    public task1(int prior, int delay) {
        priority = prior;
        sleep = delay;
        System.out.println("Start Task1" );
        if(t == null) {
            t = new Thread(this, "Task1");
            t.setPriority(priority);
        }
    }
    
    
    @Override
    public void run() {
        System.out.println("Running Task 1 Thread...\n");
        try {
            Thread.sleep(sleep);,
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        size = 1000;

        A = vec.CreateRandomVector(size);
        B = vec.CreateRandomVector(size);
        C = vec.CreateRandomVector(size);
        MA = mat.CreateRandomMatrix(size);
        ME = mat.CreateRandomMatrix(size);

        result = operation.MultiplyVectors(B, C) + operation.MultiplyVectors(A, B) +
        operation.MultiplyVectors(operation.MultiplyMatrixVector(operation.MultiplyMatrix(MA, ME), B), C);
        
        System.out.print("Task1 result:\n");
        System.out.println(result);
        System.out.println();
    }
}