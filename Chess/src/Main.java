import java.util.regex.*;
public class Main {
    public static void main(String[] args) {
        String moves = "exd1 Nbf7+ Nf8 Bb4# Qd4 exd5 hello";
        String[] arr = moves.split(" ");
        Pattern pattern = Pattern.compile("[NBRQK]?([a-h]x|[a-h])?([a-h][1-8])?[a-h][1-8][+#]?");
        Matcher matcher;
        for(String i : arr){
            matcher = pattern.matcher(i);
            if(matcher.matches()){
                System.out.printf("%s е валиден ход", i);
                System.out.println();
            }
            else{
                System.out.printf("%s не е валиден ход", i);
                System.out.println();
            }
        }
    }
}