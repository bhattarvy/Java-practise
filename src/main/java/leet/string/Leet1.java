package leet.string;

import org.mockito.internal.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leet1 {

    public void solve125(){

        String s="A man, a plan, a canal: Panama"
                ;
        StringBuffer ans = new StringBuffer();
        s= s.toLowerCase();
        for(int i=0; i<s.length(); i++) {
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' &&
                                                          s.charAt(i)<='9')){
                ans.append(s.charAt(i));
            }
        }
        System.out.println(ans.toString());
        System.out.println("--------");

        StringBuffer t = new StringBuffer(ans.toString());
        ans.reverse();

        System.out.println(t.toString());
        System.out.println(ans.toString());
        if (t.toString().equals(ans.toString()) ) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    public void solve1592() {
        String text = "  this   is  a sentence ";

        String[] words = text.split(" ");
        List<String> wordsList = Arrays.stream(words).filter((e)-> !e.equals("")).collect(Collectors.toList());
        int countSpaces=0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i)==' '){
                countSpaces++;
            }
        }
        int spaceToEnter = countSpaces/(wordsList.size()-1);
        StringBuffer ans = new StringBuffer();
        StringBuffer spaceGenerated = new StringBuffer();
        for(int i=0; i<spaceToEnter; i++)
            spaceGenerated.append(" ");
        for(int i=0; i<wordsList.size(); i++){
            if(i==0) {
                ans.append(wordsList.get(i));
                continue;
            } else {
                ans.append(spaceGenerated);
                ans.append(wordsList.get(i));
            }
        }
       /* System.out.println(countSpaces + " " +spaceToEnter + " " +  wordsList.size() );
        System.out.println(countSpaces - spaceToEnter*wordsList.size());*/
        for(int i=0; i<(countSpaces - spaceToEnter*(wordsList.size()-1)); i++){
            ans.append(" ");
        }
        System.out.println(ans);
    }

    public void solve459() {
        String s = "";


    }
}
