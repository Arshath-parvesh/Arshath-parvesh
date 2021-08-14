package Creating_Account;
import java.util.regex.*;
import java.util.Scanner;

class phone_number{

Scanner input=new Scanner(System.in);
String phone_number,aadhar_number,pan_number;
    public boolean isValid(String s) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
    public void check_ph(){
        System.out.println("ENTER YOUR PHONE NUMBER:");
        phone_number=input.nextLine();
        if(isValid(phone_number)){
            check_an();
        }
        else{
            System.out.println("!!!YOU HAVE ENTERED WRONG INFORMATION!!!");
            check_ph();
        }
    }
    public static boolean isValidAadharNumber(String str)
    {
        String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        Pattern p = Pattern.compile(regex);
        if (str == null) {
            return false;
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public void check_an() {
        System.out.println("ENTER YOUR AADHAR NUMBER");
         aadhar_number = input.nextLine();
        if (isValidAadharNumber(aadhar_number)) {
            check_pn();
        } else {
            System.out.println("!!!YOU HAVE ENTERED WRONG INFORMATION!!!");
            check_an();
        }
    }
    public static boolean isValidPanCardNo(
            String panCardNo) {
        String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        if (panCardNo == null) {
            return false;
        }
        Matcher m = p.matcher(panCardNo);
        return m.matches();
    }

    public void check_pn() {
        System.out.println("ENTER YOUR PAN NUMBER:");
        pan_number = input.nextLine();
        if (isValidPanCardNo(pan_number)) {
            System.out.println("ENTER YOUR ANNUAL INCOME");
            double income = input.nextDouble();

        } else {
            System.out.println("!!!YOU HAVE ENTERED WRONG INFORMATION!!!");
            check_pn();
        }
    }
}
