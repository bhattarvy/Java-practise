package syntaxpratise;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

        Comparator<Integer> naturalOrder = (i,j) -> (i<j)? -1 : ((i==j)?0:1);
        List<Integer> ar = new ArrayList<>();
        ar.add(4);ar.add(2);ar.add(1);ar.add(3);
        ar.sort(naturalOrder);
        System.out.println(ar);

        System.out.println(naturalOrder.compare(new Integer(42),new Integer(42)));


        // improper intialization
        int[] a = new int[]{1341,
                1340,
                1184,
                1181,
                1180,
                1338,
                1337,
                1336,
                1335,
                1334,
                1333,
                1299,
                1332,
                1298,
                1331,
                1339,
                1352,
                1351,
                1350,
                1349,
                1348,
                1347,
                1346,
                1345,
                1344,
                1343,
                1342,
                1242,
                1363,
                1241,
                1362,
                1240,
                1361,
                1360,
                1239,
                1238,
                1359,
                1237,
                1358,
                1357,
                1356,
                1355,
                1354,
                1353,
                1253,
                1374,
                1252,
                1373,
                1372,
                1371,
                1370,
                1404,
                1403,
                1369,
                1402,
                1368,
                1401,
                1246,
                1367,
                1400,
                1245,
                1366,
                1244,
                1365,
                1243,
                1364,
                1409,
                1408,
                1407,
                1406,
                1405,
                1264,
                1385,
                1263,
                1384,
                1141,
                1262,
                1383,
                1261,
                1382,
                1260,
                1381,
                1380,
                1415,
                1414,
                1259,
                1413,
                1258,
                1379,
                1412,
                1257,
                1378,
                1411,
                1256,
                1377,
                1410,
                1255,
                1376,
                1254,
                1375,
                1275,
                1396,
                1274,
                1395,
                1273,
                1394,
                1272,
                1393,
                1271,
                1392,
                1270,
                1391,
                1390,
                1305,
                1304,
                1303,
                1269,
                1302,
                1268,
                1301,
                1389,
                1267,
                1300,
                1388,
                1266,
                1387,
                1265,
                1386,
                1309,
                1308,
                1307,
                1306,
                1286,
                1285,
                1284,
                1283,
                1282,
                1281,
                1280,
                1316,
                1315,
                1314,
                1313,
                1279,
                1312,
                1278,
                1311,
                1399,
                1277,
                1310,
                1398,
                1276,
                1397,
                1319,
                1318,
                1317,
                1297,
                1330,
                1296,
                1295,
                1294,
                1293,
                1292,
                1291,
                1290,
                1327,
                1326,
                1325,
                1324,
                1323,
                1201,
                1289,
                1322,
                1288,
                1321,
                1287,
                1320,
                1329,
                1328};
        String ans = convertTo(a);
        System.out.println(ans);

        try {
            List<String> t = new ArrayList<>();
            t.add("sf");

        } catch (Exception e) {

        }


       /* SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setMessage("this is message");
        sendMailRequest.setHtml("this is html");

        System.out.println(sendMailRequest);

        SendMailRequest sendMailRequest1 = new SendMailRequest();
        sendMailRequest1.setMessage("this is message");

        System.out.println(sendMailRequest1 + " " + sendMailRequest1.getMessage());

        SendMailRequest sendMailRequest2 = new SendMailRequest();
        sendMailRequest2.setHtml("this is HTML");

        System.out.println(sendMailRequest2);*/

        Campaign c= new Campaign();
        c.setCampaingName("jndg");
        System.out.println(c);


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
