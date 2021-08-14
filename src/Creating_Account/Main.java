package Creating_Account;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
class details{
    Jdbc jdbc= new Jdbc();
    Scanner input=new Scanner(System.in);
    int id;
    details(){
        jdbc.connect();
        jdbc.Table();
    }
    public void personal_details(){
        id=jdbc.getRowCount();
        System.out.println("id->"+id);
        System.out.println("AP BANK WELCOMES YOU \n TO CREATE A NEW ACCOUNT IN OUR BANK FILL THE FOLLOWING DETAILS AND ENJOY OUR ONLINE BANKING");
        System.out.println("ENTER YOUR NAME");
        String name=input.nextLine();
        System.out.println("ENTER YOUR DATE OF BIRTH");
        String dob=input.nextLine();
        System.out.println("ENTER YOUR GENDER");
        String gender=input.nextLine();
        System.out.println("ENTER GUARDIAN NAME");
        String guardian=input.nextLine();
        System.out.println("ENTER YOUR CURRENT ADDRESS");
        String address=input.nextLine();
        jdbc.getPersonal(id,dob,name,gender,guardian,address);

    }
    public void account_details(){
        System.out.println("ENTER THE ACCOUNT TYPE \n 1.SELF ACCOUNT or SAVING ACCOUNT\n 2.CURRENT ACCOUNT");
        int type=input.nextInt();
        boolean check=true;
        switch(type) {
            case 1:
                phone_number s=new phone_number();
                s.check_ph();
                jdbc.getAccountSelf(id,s.phone_number,s.aadhar_number,s.pan_number);
                break;
            case 2:
                phone_number a=new phone_number();
                a.check_ph();
                jdbc.getAccountSelf(id,a.phone_number,a.aadhar_number,a.pan_number);
                gst_number b=new gst_number();
                List<String> list =b.check_gst();
                jdbc.getAccountCurrent(id,list.get(0),list.get(1),list.get(2));
                break;
            default:
                System.out.println("!!!!!WRONG INFO!!!!!/n TRY AGAIN....");
                account_details();
        }

    }
}


public class Main {
    public static void main(String[] args) {
        Scanner get=new Scanner(System.in);
        details s=new details();
        s.personal_details();
        s.account_details();
        System.out.println("1.NEED OF CREDIT AND DEBIT CARD \n 2.NEED OF CHECK BOOK \n 3.BOTH");
        int type=get.nextInt();
        switch(type) {
            case 1:
                System.out.println("YOUR DEBIT CARD WILL BE POSTED TO YOUR CURRENT ADDRESS");
                break;
            case 2:
                System.out.println("YOUR CHACK BOOK WILL BE POSTED TO YOUR CURRENT ADDRESS");
                break;
            case 3:
                System.out.println("BOTH DEBIT CARD AND CHECK BOOK WILL BE POSTED TO YOUR ACCOUNT ");
                break;
            default:
                System.out.println("!!!WRONG INFO!!!");
        }


    }
}
