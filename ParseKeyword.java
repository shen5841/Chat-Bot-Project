
/**
 * Write a description of class ParseKeyword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Random;

public class ParseKeyword
{
    private List<String[]> keywords = new ArrayList<String[]>();
    private List<String[]> answer = new ArrayList<String[]>();
    
    //put a space before and after the keywords, so it only looks for the word itself, and not contained in another word
    private String[] whereBathroom = {" bathroom ", " toilet ", " restroom ", " pee "};
    private String[] whereBathroomAns = {"find it yourself", "hold it together","just don't drink water"};
     
    private String[] hello = {" hi ", " hello ", " hey "};
    private String[] helloAns = {"hi, how's it going?", "what do you want?", "hi, how are you?"};
    
    private String[] moody = {" stop ", " don't ", " nay "};
    private String[] moodyAns = {"what's wrong?", "feeling moody?"};

    private String[] no = {" no "};
    private String[] noAns = {"alright my bad", "nevermind then", "alright, I'll stop then"};

    
    public ParseKeyword () {
        //add in keywords in order from most important, to least important
        //this way if you have two key words in the same sentence, one will overwrite the other
        keywords.add(moody);
        keywords.add(whereBathroom);
        keywords.add(hello);
        
        //make sure the answer array matches up with the index of the keywords array
        answer.add(moodyAns);
        answer.add(whereBathroomAns);
        answer.add(helloAns);
    }
    
    
    public void keyToAnswer (String response) {
        boolean foundKey = false;
        //init with a negative number so it wouldn't display a result if there was no match
        int answerArrIndex = -1; 
        Random rand = new Random();
        for (int i = this.keywords.size() - 1; i >= 0; i--) {
            String[] key = this.keywords.get(i);
            for (int j = 0; j < key.length ; j++) {
                if (response.toLowerCase().contains(key[j])) {
                    foundKey = true;
                    answerArrIndex = i;
                }
            }
        }
        if (foundKey && (answerArrIndex != -1)){
            String[] ans = this.answer.get(answerArrIndex);
            int r = rand.nextInt(ans.length);
            System.out.println(ans[r]);
        }
        else {
            System.out.println("sorry, I don't understand what you mean");
        }
    }
}
