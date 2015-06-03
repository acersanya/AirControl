package in.techyari.example.dao;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.resAuthType;
import in.techyari.example.model.Flight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.*;

import in.techyari.example.model.User;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class UserDAOImpl implements UserDAO, Serializable {

    Database db = new Database();
  private  List<User> captainList = new ArrayList<>();
  private  List<User> firstOfficerList = new ArrayList<>();
  private  List<User> secondOfficerList = new ArrayList<>();
  private  List<User> Stewardess = new ArrayList<>();

    @Override
    public User getUserByLogin(String login, String password) {
        User user = new User();
        try {
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE login LIKE ? AND password LIKE ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setSurname(rs.getString("surname"));
                user.setGender(rs.getString("gender"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setLogin(rs.getString("login"));
                user.setStatus(Integer.parseInt(rs.getString("status_bar")));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    public boolean userExist(Connection con, String login) throws SQLException, ServletException, IOException {

        boolean forReturn = false; //Add

	//UserBean uBExist = new UserBean();
        if (con != null) {
            ResultSet rs = null;
            Statement stmt = null;

            try {
                String strQuery = "select * from users where login='" + login + "' ";
                stmt = con.createStatement();
                rs = stmt.executeQuery(strQuery);
                if (rs.next()) {
                    forReturn = true; //change to variable assignment
                } else {
                    forReturn = false;	//change to variable assignment
                }
            } catch (Exception e) {
                System.out.println("Error on DB return");
                //userChk = true;				
            } //end of try
            finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }//end of finally
        }//end of if

        return forReturn;	// return the boolean
    }

    @Override
    public int createOrUpdateUser(User u) {
        int result = 0;
        try {
            Connection connection = db.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (fullname,surname,password,gender,birthdate,login,position) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getGender());
            ps.setString(5, u.getBirthdate());
            ps.setString(6, u.getLogin());
            ps.setString(7, u.getPosition());

            ResultSet rs = null;
            Statement stmt = null;
            String strQuery = "select * from users where login='" + u.getLogin() + "' ";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(strQuery);
            if (rs.next()) {
                return 0;
            } else {
                result = ps.executeUpdate();
            }

            //result = ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }

  public String getPosition(User u){
      return u.getPosition();
  }    

    
    public List<User> getUsers() throws IllegalAccessException {
        List<User> list = new ArrayList();
        Connection con = null;
        Statement st = null;

        try {
            con = db.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT *FROM users ORDER BY id");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFullname(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setGender(rs.getString(5));
                user.setBirthdate(rs.getString(6));
                user.setLogin(rs.getString(7));
                user.setPosition(rs.getString(8));
                user.setStatusAvaible(rs.getInt(10));
                list.add(user);
                if (rs.getString(8).toLowerCase().equalsIgnoreCase("captain")) {
                    captainList.add(user);
                } else if (rs.getString(8).equalsIgnoreCase("first officer")) {
                    firstOfficerList.add(user);
                } else if (rs.getString(8).equalsIgnoreCase("second officer")) {
                    secondOfficerList.add(user);
                } else {
                    Stewardess.add(user);
                }
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException e) {
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
 
}
