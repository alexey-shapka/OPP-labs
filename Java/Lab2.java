/* ==========================================
Основи Паралельного програмування
Лабораторна робота №2
Потоки в мові програмування Java
F1: d  = (B * C) + (A * B) + (C * (B * (MA * ME)))
F2: MF = (MG * MH) * (MK + ML)
F3: S  = SORT(MS * MT) * O - P 
Шапка Олексій Володимирович ІО-62
дата: 28.09.2018
========================================== */

public class lab2 {
    public static void main(String[] args) {
        System.out.println("Main Thread Started: \n");
        
        task1 t1 = new task1(1,1000);
        task2 t2 = new task2(2,400);
        task3 t3 = new task3(3,300);

        t1.start();
        t2.start();
        t3.start();

        try 
        {
            t1.join();
            t2.join();
            t3.join();

        } 
        catch(InterruptedException e)
        {
            System.out.println("System error");
        }
        System.out.println("Main process finished");
    }
}
