package Creating_Account;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

class gst_number {
    Scanner input=new Scanner(System.in);
    public static boolean isValidGSTNo(String str)
    {
        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}" + "[A-Z]{1}[1-9A-Z]{1}" + "Z[0-9A-Z]{1}$";
        Pattern p = Pattern.compile(regex);
        if (str == null) {
            return false;
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public List<String> check_gst() {
        System.out.println("ENTER YOUR GST NUMBER:");
        String gst_number = input.nextLine();

        if (isValidGSTNo(gst_number)) {
            System.out.println("ENTER YOUR COMPANY NAME:");
            String company_name = input.nextLine();
            System.out.println("ENTER YOUR BUSSINESS:");
            String bussiness = input.nextLine();
            return new LinkedList<>(){{
                add(gst_number);
                add(company_name);
                add(bussiness);
            }};
        } else {
            System.out.println("!!!YOU HAVE ENTERED WRONG INFORMATION!!!");
            return null;
        }
    }
}