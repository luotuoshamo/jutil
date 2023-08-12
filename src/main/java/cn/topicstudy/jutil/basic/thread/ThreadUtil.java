package cn.topicstudy.jutil.basic.thread;

public class ThreadUtil {
    /**
     * 使线程sleep 为了少写try catch
     *
     * @param ms
     * @param thread
     */
    public static void sleep(long ms, Thread thread) {
        try {
            thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
