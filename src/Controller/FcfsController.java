package Controller;

import java.util.concurrent.Semaphore;

public class FcfsController extends Thread {


    private Semaphore semaforo;
    private int tempoExec;
    private String nomeThread;

    public FcfsController(String nomeThread, int tempoExec, Semaphore semaforo) {

        this.nomeThread = nomeThread;
        this.tempoExec = tempoExec;
        this.semaforo = semaforo;
    }


    @Override
    public void run() {

        try {
            semaforo.acquire();
            execProcess();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaforo.release();
        }


    }

    private void execProcess(){

        try {
            sleep((long) tempoExec * 100);
            System.out.println(nomeThread + " processada");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }




}
