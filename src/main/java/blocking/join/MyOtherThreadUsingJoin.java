package blocking.join;

public class MyOtherThreadUsingJoin extends Thread {
    private Thread myThreadTwo;

    public MyOtherThreadUsingJoin() {
        System.out.println("MyOtherThread create...");
    }

    public void setMyThreadTwo(Thread myThreadTwo) {
        this.myThreadTwo = myThreadTwo;
    }

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MyOtherThread start...");
        try {
            myThreadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MyOtherThread finished...");
    }
}
