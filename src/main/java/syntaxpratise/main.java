package syntaxpratise;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class main {

    private static Scanner sc = new Scanner(System.in);

    public static void testCode() {
        int[] test = new int[6];
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static void solve1() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefix[i] = arr[i];
            else
                prefix[i] = arr[i] + prefix[i - 1];
        }

        for (int i = 0; i < n; i++)
            System.out.println(prefix[i]);

        System.out.println("ajsdb");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j += 2) {

                int x = i - 1;
                if (x < 0) {
                    sum += prefix[j];
                } else {
                    sum += (prefix[j] - prefix[x]);
                }
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    public static void solve1266() {

        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1]));
        }
        System.out.println(sum);

    }

    // non static method
    public void nonStaticTest() {
        System.out.println("hey this is nonstatisc");
    }

    public static String convertTo(int[] a) {
        String ans="";
        for(int i=0; i<a.length; i++) {
            ans+="'" +Integer.toString(a[i]) + "'";
            if(i!=a.length-1)
                ans+=", ";
        }
        return ans;
    }


    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();

        long milli = Long.valueOf("1681974251000");
        System.out.println(milli);
        calendar.setTimeInMillis(milli);
        Date date = calendar.getTime();
        StringBuffer ans = new StringBuffer();
        ans.append(calendar.get(calendar.DATE));
        ans.append("-");
        ans.append(calendar.get(calendar.MONTH));
        ans.append("-");
        ans.append(calendar.get(calendar.YEAR));
        System.out.println(ans.toString());

    }




    @Data
    @EqualsAndHashCode(callSuper = true)
    static class SendMailRequest extends BaseMailSendRequest {
        /**
         *
         */
        private static final long serialVersionUID = 6967098009552506129L;
        private String html;
        private List<String> attachmentInfoList;
    }

    @Data
    static class BaseMailSendRequest implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = -2634360100672859680L;

        private String reqId;
        private String from;
        private List<String> toList;
        private List<String> bccList;
        private List<String> ccList;
        private List<String> replyToList;
        private List<String> tagList;
        //Below two attributes are required if not using template
        private String message;
        private String subject;
        private String senderDisplayName;
        private String moduleName;

    }


}
