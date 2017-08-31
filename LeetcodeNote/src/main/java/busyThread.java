/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class busyThread {

    public static void main(String [] args){
        Thread thread1=new Thread(new Runnable() {
            public void run() {
                while (true)
                    System.out.println("love you");
            }
        },"busythread");
        thread1.start();
    }
}
