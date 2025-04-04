
class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void displayProcesses() {
        if (head == null) return;
        Process current = head;
        do {
            System.out.println("PID: " + current.pid + ", Burst Time: " + current.burstTime +
                    ", Remaining Time: " + current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void executeScheduling() {
        int time = 0;
        Process current = head;
        int totalProcesses = 0;
        Process temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                time += execTime;
                current.remainingTime -= execTime;

                Process temp2 = head;
                do {
                    if (temp2 != current && temp2.remainingTime > 0) {
                        temp2.waitingTime += execTime;
                    }
                    temp2 = temp2.next;
                } while (temp2 != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    removeProcess(current.pid);
                }
            }
            current = current.next;
            if (head == null) break;
        }
        displayFinalStats(totalProcesses);
    }

    private void removeProcess(int pid) {
        if (head == null) return;
        if (head == tail && head.pid == pid) {
            head = tail = null;
            return;
        }

        Process current = head;
        Process prev = tail;
        do {
            if (current.pid == pid) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    private void displayFinalStats(int totalProcesses) {
        Process current = head;
        int totalWaiting = 0;
        int totalTurnaround = 0;
        System.out.println("Final Statistics:");
        do {
            System.out.println("PID: " + current.pid + ", Waiting Time: " + current.waitingTime +
                    ", Turnaround Time: " + current.turnaroundTime);
            totalWaiting += current.waitingTime;
            totalTurnaround += current.turnaroundTime;
            current = current.next;
        } while (current != head);

        System.out.println("\nAverage Waiting Time: " + (double) totalWaiting / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaround / totalProcesses);
    }
}

public class RoundRobinDemo {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        scheduler.displayProcesses();
        scheduler.executeScheduling();
    }
}



