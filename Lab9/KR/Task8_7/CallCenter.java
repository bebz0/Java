// Task 8.7
public class CallCenter {
    private boolean[] busy;
    private int served = 0;
    private int callsBack = 0;

    public CallCenter(int operators) {
        busy = new boolean[operators];
    }

    public synchronized int takeOperator() {
        for (int i = 0; i < busy.length; i++) {
            if (!busy[i]) {
                busy[i] = true;
                return i;
            }
        }
        callsBack++;
        return -1;
    }

    public synchronized void release(int operator) {
        busy[operator] = false;
        served++;
    }

    public synchronized int getServed() {
        return served;
    }

    public synchronized int getCallsBack() {
        return callsBack;
    }
}
