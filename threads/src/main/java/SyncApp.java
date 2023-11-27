class Printer{
//    synchronized void printDocuments(int numOfCopies, String document){
    void printDocuments(int numOfCopies, String document){
        for (int i=1;i<=numOfCopies;i++){
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("printing " + document + " " + i);
        }
    }
}

class MyThread extends Thread{
    Printer pRef;

    MyThread(Printer p){
        pRef =p;
    }

    @Override
     public void run() {

        synchronized (pRef) {
            pRef.printDocuments(10, "john's.pdf");

        }

    }
}

class YourThread extends Thread{
    Printer pRef;

    YourThread(Printer p){
        pRef =p;
    }

    @Override
    public void run(){
        synchronized (pRef){
        pRef.printDocuments(10,"dio's.pdf");
    }}
}

public class SyncApp {
    public static void main(String[] args) {
        System.out.println("===Application Started====");

        Printer printer =new Printer();
//        printer.printDocuments(10,"resume.pdf");

        //Scenario is that we have multiple threads working on same Printer Object
        //If Multiple Threads are working on the same object we must synchronize them
        MyThread mRef = new MyThread(printer);//MyThread is having reference to the Printer Object
        YourThread yRef =new YourThread(printer);//YourThread is having reference to the Printer Object

        mRef.start();
//        try {
//            mRef.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        yRef.start();

        System.out.println("===Application finished====");
    }
}
