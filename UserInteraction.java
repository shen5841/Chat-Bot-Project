/**
 * The UserInteraction class utilizes a main() method to run the chat bot, and take user input
 * the while loop inside the main() medthod kept on receiving user responses, until the user says "stop"
 */
import java.util.Scanner;

public class UserInteraction
{
    private static String response;
    public static void main() {
        response = "";
        while (response.equals("stop") == false){
            ParseKeyword p = new ParseKeyword();
            Scanner s = new Scanner(System.in);
            response = s.nextLine();
            p.keyToAnswer(response);
            //System.out.println("you said " + response);
        }
        System.out.println("ok, I'll shut up now");
    }
}
