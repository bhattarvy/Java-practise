package leet;

import java.util.*;
import java.util.stream.Collectors;

public class Contests {


    public void solve2520(){
        long num=121;

        Set<Integer> st = new HashSet<>();
        long x =num;
        while(x>0){
            int y = (int)num%10;
            if(num%y==0)
                st.add(y);
            x/=10;
        }
        System.out.println(st.size());
    }
    public void solve2383(){
        int initialEnergy=5;
        int initialExp = 3;
        int n=4;
        int energy[] = new int[]{1,4,3,2};
        int exp[] = new int[]{2,6,3,1};

        int hours=0;
        for(int i=0; i<n; i++) {
            if(!(initialEnergy > energy[i])){
                hours+= energy[i]-initialEnergy+1;
                initialEnergy=energy[i]+1;
            }
            if(!(initialExp > exp[i])){
                hours+= exp[i]-initialExp+1;
                initialExp=exp[i]+1;
            }
            initialEnergy-=energy[i];
            initialExp+=exp[i];
        }
        System.out.println(hours);
    }


    public String solve2384(){

        String num = "6006";
        Map<Character, Integer> treeMap = new TreeMap<>(Comparator.<Character>reverseOrder());
        for (int i = 0; i < num.length(); i++) {
            if (treeMap.containsKey(num.charAt(i))) {
                treeMap.put(num.charAt(i), treeMap.get(num.charAt(i)) + 1);
            } else {
                treeMap.put(num.charAt(i), 1);
            }
        }
        treeMap.forEach((key, value)->{
            System.out.println(key+ " = " + value);
        });

        final Character[] singleDigit = { '0' };
        final boolean[] updated = { false };
        StringBuffer ans = new StringBuffer();
        if(treeMap.get('0')==num.length()) {
            ans.append("0");
            return ans.toString();
        }

        treeMap.forEach((key,value)->{
            if(value%2!=0) {
                singleDigit[0] = (singleDigit[0] < key ? key : singleDigit[0]);
                updated[0] =true;
            }

            if (!(key == '0' && !(ans.length() > 0))) {
                for (int i = 0; i < (value % 2 == 0 ? value : value - 1) / 2; i++) {
                    ans.append(key);
                }
            }
        });

        System.out.println(singleDigit[0]+ " --- " + ans.toString() );
        StringBuffer revans = new StringBuffer(ans);
        revans.reverse();
        System.out.println(revans);
        if(updated[0])
            ans.append(singleDigit[0]);
        System.out.println(ans);

        ans.append(revans);
        System.out.println(ans.toString());
        return ans.toString();
    }

    public void solve1796(){
        String s="dfa12321afd";
        /*int a=-1,b=-1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if(Integer.parseInt(String.valueOf(s.charAt(i))) > a){
                    b=a;
                    a= Integer.parseInt(String.valueOf(s.charAt(i)));
                } else if (Integer.parseInt(String.valueOf(s.charAt(i))) < a && Integer.parseInt(String.valueOf(s.charAt(i))) > b)
                    b= Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        System.out.println(b);*/

        Map<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        }

        for(Map.Entry<Character,Integer> e :map.entrySet()){
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        int ans=-1;
        int count=0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            count++;
            if(count==2) {
                System.out.println(e.getKey() + " -- " + e.getValue());
                System.out.println(ans + "  " + e.getKey());
                ans = Integer.parseInt(String.valueOf(e.getKey()));
                System.out.println(ans);
                break;
            }
        }
        System.out.println("kdfngfdg " + ans);


    }

    public static void main(String[] args) {

        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,3,3), Arrays.asList(1,23,34));
        List<Integer> list2 = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        list2.forEach((e-> System.out.println(e)));

        /*Contests contests = new Contests();
        contests.solve1796();*/
    }

}
