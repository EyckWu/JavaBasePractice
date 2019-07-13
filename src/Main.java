public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String selection = "number LIKE ?";
        String selection1 = "NUMBER LIKE ?";
        selection = selection.replaceAll("(?i)number", "shortDialNumber");
        selection1 = selection1.replaceAll("(?i)number", "shortDialNumber");
        System.out.println("selection = " + selection);
        System.out.println("selection1 = " + selection1);
    }
}
