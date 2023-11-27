//class MyTask{
//    void executeTask(){
//        for (int doc=1;doc<=10;doc++){
//            System.out.println("Printing doc #"+doc+" - Printer2");
//        }
//    }
//}

//MyTask IS-A Thread
//class MyTask extends Thread{
//    @Override
//    public void run(){
//        for (int doc=1;doc<=10;doc++){
//            System.out.println("Printing doc #"+doc+" - Printer2");
//        }
//    }
//}

class CA{

}

//class MyTask extends CA,Thread{   // multiple inheritance is not supported
    class MyTask extends CA implements Runnable{
    @Override
    public void run(){
        for (int doc=1;doc<=10;doc++){
            System.out.println("Printing doc #"+doc+" - Printer2");
        }
    }
}

class YourTask implements Runnable{
    @Override
    public void run(){
        for (int doc=1;doc<=10;doc++){
            System.out.println("Printing doc #"+doc+" - Printer3");
        }
    }
}

public class App {
    //main method represents main thread
    public static void main(String[] args) {
        //whatever we write here will be executed by main thread
        //threads always execute jobs in sequence


        //job 1
        System.out.println("==Application Started==");

        //job2
//        MyTask task = new MyTask(); // child/worker thread
//        task.executeTask();

//        task.start(); //-> start shall internally execute run method

        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.start();
//        task.setDaemon(true);

//        Thread yourTask =new Thread(new YourTask());
//        yourTask.start();

        new Thread(new YourTask()).start();

        //job3
        for (int doc=1;doc<=10;doc++){
            System.out.println("Printing doc #"+doc+" - Printer 1");
        }

        //job4
        System.out.println("==Application finished==");
    }
}