package View;

import Controller.FcfsController;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);
        String nomeThread;
        int tempoExec;

        for(int i = 1; i <= 20; i++) {
            nomeThread = "Thread " + i;
            tempoExec = (int) (Math.random() * 121) + 4;
            FcfsController fcfsC = new FcfsController(nomeThread, tempoExec, semaforo);
            fcfsC.start();
        }


    }
}
