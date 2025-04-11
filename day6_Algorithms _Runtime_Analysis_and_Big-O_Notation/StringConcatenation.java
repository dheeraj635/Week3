public class StringConcatenation {

    public static void main(String[] args) {
        int n = 1_000_000;

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endTime - startTime) + "ms");
    }
}
