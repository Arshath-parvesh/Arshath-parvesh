package Creating_Account;
import java.sql.*;
import java.util.Date;
public class Jdbc {
    private String primary,account;
    private Connection con;
    void connect(){
        String url="jdbc:mysql://127.0.0.1:3306/";
        try {
            con = DriverManager.getConnection(url+"bank", "Arshath parvesh", "Arshath@24434");
            System.out.println("Connected");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    void Table(){
        primary="CREATE TABLE IF NOT EXISTS personal(acc INTEGER NOT NULL PRIMARY KEY,"+
                                           "name VARCHAR(25) NOT NULL," +
                                            "DOB VARCHAR(10) NOT NULL," +
                                            "Gender CHAR(1) NOT NULL," +
                                            "guardian VARCHAR(25) NOT NULL," +
                                            "address VARCHAR(100) NOT NULL," +
                                            "phone CHAR(10)," +
                                            "aadhar CHAR(14)," +
                                            "pan CHAR(10)," +
                                            "gst CHAR(15)," +
                                            "company CHAR(15)," +
                                            "bussiness CHAR(20));";

        try{
            Statement table=con.createStatement();
            table.execute(primary);
            System.out.println("success");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }
    void getPersonal(int id,String ...details){
        String query="INSERT INTO personal(acc,name,DOB,Gender,Guardian,address) VALUES(?,?,?,?,?,?)";
        try(PreparedStatement insert=con.prepareStatement(query)){
            int iter=1;
            insert.setInt(iter++,id);
            for(String detail: details)
                insert.setString(iter++,detail);
            insert.execute();
            System.out.println("success");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    void getAccountSelf(int id,String ...details) {
        String query = "UPDATE personal SET phone=?,aadhar=?,pan=? WHERE acc=?";
        try (PreparedStatement insert = con.prepareStatement(query)) {
            int iter = 1;
            for (String detail : details){
                insert.setString(iter++, detail);
            System.out.println(detail);}
            insert.setInt(iter, id);
            insert.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    int getRowCount(){
        String query="SELECT COUNT(*) FROM personal";
        try(Statement stmt= con.createStatement()){
            ResultSet rs=stmt.executeQuery(query);
            rs.next();
            return rs.getInt(1)+1;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    void getAccountCurrent(int id,String ...details){
        String query="UPDATE personal SET gst=?,company=?,bussiness=? WHERE acc=? ";
        try (PreparedStatement insert = con.prepareStatement(query)) {
            int iter = 1;
            for (String detail : details)
                insert.setString(iter++, detail);
            insert.setInt(iter, id);
            insert.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }



}
