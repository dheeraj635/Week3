
public class Compare_StringBufferAndStringBuilder_StringConcatenation{
    public static void main(String[] args) {
        int n = 1000000;

        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("hello");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        long startBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append("hello");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: " + timeBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " nanoseconds");
    }
}

