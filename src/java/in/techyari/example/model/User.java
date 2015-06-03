package in.techyari.example.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private int id;
	private String fullname;
	private String surname;
	private String password;
	private String gender;
	private String birthdate;
        private String login;
        private String position;
        private int status;
        private int statusAvaible;

    public int getStatusAvaible() {
        return statusAvaible;
    }

    public void setStatusAvaible(int statusAvaible) {
        this.statusAvaible = statusAvaible;
    }
        
        
    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
        
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public String getPosition() {
        return position;
    }

    
    
	public User(){
		
	}
	
	public User(String fullname, String surname, String password,String gender, String birthdate, String login,String position) {
		this.fullname = fullname;
		this.surname = surname;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
                this.login = login;
                this.position = position;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

    @Override
    public String toString() {
        return  "id=" + id + ", Name=" + fullname + ", Surname=" + surname +  ", gender=" + gender + ", birthdate=" + birthdate +  ", position=" + position;
    }


	
	
}
