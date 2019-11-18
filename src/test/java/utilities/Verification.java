package utilities;

public class Verification {

    public static boolean verify(String expected, String actual) {
        if (expected.equals(actual)) {
            return true;
        }
        return false;
    }


    public static void verifyEqualsInt (int expected, int actual){
        if(expected == actual ){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }


    public static void verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }


}
