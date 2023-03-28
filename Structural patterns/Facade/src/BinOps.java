public class BinOps {
    public String sum(String a, String b) {
        int numA = parseToInteger(a);
        int numB = parseToInteger(b);
        int sum = numA + numB;
        return Integer.toBinaryString(sum);
    }

    public String mult(String a, String b) {
        int numA = parseToInteger(a);
        int numB = parseToInteger(b);
        int mult = numA * numB;
        return Integer.toBinaryString(mult);
    }

    private int parseToInteger(String str) {
        int numA = 0;
        try {
            numA = Integer.parseInt(str, 2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return numA;
    }
}