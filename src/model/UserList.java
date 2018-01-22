package model;

import java.util.ArrayList;
import java.util.List;

public class UserList implements Model{
	
	private List<String> userList;
	
	private UserList(){
		userList = new ArrayList<>();
	}
	
	boolean addUser(String user){
		return userList.add(user); //add a user and return true if succeed, false instead
	}

    @Override
    public String[] getData() {
        return userList.toArray(new String[]{}); //return a string[]
    }
        
}
