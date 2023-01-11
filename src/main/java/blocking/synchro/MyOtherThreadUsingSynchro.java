package blocking.synchro;

public class MyOtherThreadUsingSynchro extends Thread {
    public MyOtherThreadUsingSynchro() {
        System.out.println("MyOtherThreadUsingSynchro create...");
    }

    @Override
    public void run() {
        synchronized (MyOtherThreadUsingSynchro.class) {
            System.out.println("Hold MyOtherThreadUsingSynchro");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Waiting MyThreadUsingSynchro");

            synchronized (MyThreadUsingSynchro.class) {
                System.out.println("Hold MyThreadUsingSynchro and MyOtherThreadUsingSynchro");
            }
        }
        System.out.println("MyOtherThreadUsingSynchro finished...");
    }
}
