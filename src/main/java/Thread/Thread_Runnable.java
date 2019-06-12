package Thread;

public class Thread_Runnable {

    public static void main(String arg[]) throws InterruptedException {
        ThreadDame threadDame=new ThreadDame("ThreadWindow1");
        ThreadDame threadDame1=new ThreadDame("ThreadWindow2");
        System.out.println(Thread.activeCount());
        threadDame.start();
        threadDame1.start();
        RunnableDemo runnableDemo=new RunnableDemo();
        Thread R1=new Thread(runnableDemo,"RunnableWindow1");
        Thread R2=new Thread(runnableDemo,"RunnableWindow2");
        System.out.println(Thread.activeCount());
        R1.start();
        R1.currentThread().interrupt();
        R1.sleep(10000);
        System.out.println(R1.getName()+"暂停了");
        R1.yield();
        R2.start();

    }
}
class ThreadDame extends Thread{
    private static int ticket=10;
    public ThreadDame (String name){
        setName(name);
    }
    @Override
    public void run(){
        while (ticket>0){
            if (ticket>0){
                System.out.println(Thread.currentThread().getId()+Thread.currentThread().getName()+Thread.currentThread().isAlive()+"出售了第"+ticket--+"票");
                System.out.println("当前活跃线程数："+Thread.activeCount());
                try {
                    sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class RunnableDemo implements Runnable{
    private int ticket=100;
    public RunnableDemo(){
    }
    @Override
    public void run() {
        while (ticket>0){
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"出售了第"+ticket--+"票");
            }
        }
    }
}