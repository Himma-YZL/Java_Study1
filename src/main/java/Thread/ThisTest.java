package Thread;

public class ThisTest extends Thread {
    class res {
        public ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        public void getCount() {
            Integer count =this.count.get();
        }
    }

    public static void main(String[] args) {


    }
}
