
import java.util.Map;
        import java.util.TreeMap;

public class Exercise1 {



    private TreeMap<String,String> data;


    public Exercise1() {
        data = new TreeMap<String,String>();
    }



    public String getNumber( String name ) {
        return data.get(name);
    }


    public void putNumber( String name, String number ) {
        if (name == null || number == null)
            throw new IllegalArgumentException("name and number cannot be null");
        data.put(name,number);
    }


    public void print() {
        for ( Map.Entry<String,String> entry : data.entrySet() )
            System.out.println( entry.getKey() + ":  " + entry.getValue() );
    }

} // end class PhoneDirectoryWithTreeMap


