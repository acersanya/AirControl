package in.techyari.example.dao;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.resAuthType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.techyari.example.model.User;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;

public class UserDAOImpl implements UserDAO,Serializable{
	
	Database db = new Database();
	

	@Override
	public User getUserByLogin(String login, String password) {
		User user = new User();
		try {
			Connection connection = db.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE login LIKE ? AND password LIKE ?");
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
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

        
 public boolean userExist(Connection con, String login)throws SQLException,ServletException,IOException
{	


	boolean forReturn = false; //Add
	
	//UserBean uBExist = new UserBean();
		
    if (con != null) 
    {
    	ResultSet rs = null;
    	Statement stmt = null;
		
		try{
			String strQuery ="select * from users where login='"+login+"' ";
			stmt = con.createStatement();
			rs = stmt.executeQuery( strQuery);
			if(rs.next()){
                                  forReturn = true; //change to variable assignment
                               }
			else{
					forReturn = false;	//change to variable assignment
			}
		}
		catch(Exception e)
		{
			System.out.println("Error on DB return");
			//userChk = true;				
		}
		//end of try
		finally 
		{
        	if (stmt != null) 
        	{
        		try { stmt.close(); }
          		catch (SQLException e) { }
          	}
          	if(con!=null){
                    try{
                        con.close();
                    }
                    catch(SQLException e){e.printStackTrace();}
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
}
