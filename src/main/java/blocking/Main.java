package blocking;

import blocking.join.MyOtherThreadUsingJoin;
import blocking.join.MyThreadUsingJoin;
import blocking.synchro.MyOtherThreadUsingSynchro;
import blocking.synchro.MyThreadUsingSynchro;

/**
 * Створити 2 класи. Реалізувати взаємне блокування цих класів.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("\nDeadlock with join(). \n");
        MyThreadUsingJoin myThreadOne = new MyThreadUsingJoin();
        MyOtherThreadUsingJoin myThreadTwo = new MyOtherThreadUsingJoin();

        myThreadOne.setMyThreadOne(myThreadTwo);
        myThreadTwo.setMyThreadTwo(myThreadOne);

        myThreadOne.start();
        myThreadTwo.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDeadlock with synchronized classes. \n");
        MyThreadUsingSynchro myThreadThree = new MyThreadUsingSynchro();
        MyOtherThreadUsingSynchro myThreadFour = new MyOtherThreadUsingSynchro();

        myThreadThree.start();
        myThreadFour.start();

    }
}
