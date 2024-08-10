//create thread for print odd numbers
class OddThread extends Thread{
    public void run(){
        for (int i = 1; i <= 100; i += 2){
            System.out.println("OddThread: " + i);
            try{
                Thread.sleep(500);				//sleep thread for half second
            } catch (InterruptedException e){
                System.out.println();
            }
        }
    }
}

//create thread for print prime numbers
class PrimeThread implements Runnable{
    public void run(){
        for (int num = 2; num <= 100; num++){
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++){
                if (num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.println("PrimeThread: " + num);
                try{
                    Thread.sleep(1000);				//sleep thread for one second
                }catch (InterruptedException e){
                    System.out.println();
                }
            }
        }
    }
}

public class Threads{
    public static void main(String[] args){
        OddThread ot = new OddThread();
        Thread pm = new Thread(new PrimeThread());

        ot.start();				//object call for start OddThread
        pm.start();				//object call for start PrimeThread

        try{
            ot.join();				//object call for join OddThread with PrimeThread
            pm.join();				//object call for join PrimeThread with OddThread
        }catch(InterruptedException e){
            System.out.println();
        }
    }
}