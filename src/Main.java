import com.eyckwu.utils.Log;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String selection = "number LIKE ?";
        String selection1 = "NUMBER LIKE ?";
        selection = selection.replaceAll("(?i)number", "shortDialNumber");
        selection1 = selection1.replaceAll("(?i)number", "shortDialNumber");
        System.out.println("selection = " + selection);
        System.out.println("selection1 = " + selection1);
        Log.d(TAG, getLength("hello"));
        Log.d(TAG, getLength(null));
    }

    public static long getLength(String path){
        try{
            setData(path);
            return 1;
        } catch (IllegalArgumentException iaEx){
            return -1;
        }
    }

    private static void setData(String path){
        if (path == null){
            throw new IllegalArgumentException();
        }
    }
}
