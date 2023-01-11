package blocking.synchro;

public class MyThreadUsingSynchro extends Thread {

    public MyThreadUsingSynchro() {
        System.out.println("MyThreadUsingSynchro create...");
    }

      @Override
    public void run() {
           synchronized (MyThreadUsingSynchro.class) {
            System.out.println("Hold MyThreadUsingSynchro");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Waiting MyOtherThreadUsingSynchro");

            synchronized (MyOtherThreadUsingSynchro.class) {
                System.out.println("Hold MyThreadUsingSynchro and MyOtherThreadUsingSynchro");
            }
        }
        System.out.println("MyThreadUsingSynchro finished...");
    }
}
