package in.techyari.example.dao;

import in.techyari.example.model.User;

public interface UserDAO {
	
	public User getUserByLogin(String login,String password);
	public int createOrUpdateUser(User u);
	
}
