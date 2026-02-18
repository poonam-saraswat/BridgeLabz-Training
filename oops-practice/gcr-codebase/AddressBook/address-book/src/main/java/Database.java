import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database implements AddressBookIO {

    private final String URL = "jdbc:mysql://localhost:3306/addressbook";
    private final String USER = "root";
    private final String PASS = "Alan@2004";

    @Override
    public void write(List<Contact> persons) throws Exception {

        Connection con = DriverManager.getConnection(URL, USER, PASS);

        String sql = "INSERT INTO contacts(firstName,lastName,phone,email,city,state) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        for(Contact p : persons){
            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getCity());
            ps.setString(6, p.getState());
            ps.executeUpdate();
        }

        con.close();
    }

    @Override
    public List<Contact> read() throws Exception {

        Connection con = DriverManager.getConnection(URL, USER, PASS);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM contacts");

        List<Contact> list = new ArrayList<>();

        while(rs.next()){
            list.add(new Contact(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("zip"),
                    rs.getString("phoneNumber")
                    rs.getString("email")
            ));
        }

        return list;
    }
}