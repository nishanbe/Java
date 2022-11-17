import textio.TextIO;

public class test {
    public static void main(String[] args){

    int die1 = (int)(Math.random()*6) + 1;

    int die2 = (int)(Math.random()*6) + 1;
    int countrolls = 0;

    while (die1!= 1 || die2!=1){
        countrolls++;
        }
    System.out.println(countrolls);
    }
}
