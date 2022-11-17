public class test3 {
    public static void main(String[] args){
        double x;
        try {
            x = Double.parseDouble("str");
            System.out.println( "The number is " + x );
        }
        catch ( NumberFormatException e ) {
            System.out.println( "Not a legal number." );
            x = Double.NaN;
        }

    }
}
