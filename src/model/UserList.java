package model;

import java.util.ArrayList;
import java.util.List;

/* UserList class
 * Maintains a list of users - implements the read-only representation of the model
 */
public class UserList implements Model {
	
	// the user list (a user is only represented by a String
	private List<String> userList;
	
	// default constructor - creates an empty user list
	public UserList() { userList = new ArrayList<String>(); }
	
	// adds a user to the list - returns true if the list was changed, false otherwise
	public boolean addUser(String user) { return userList.add(user); }

	// returns a String[] version of the user list
    public String[] getData() {
    	// passes an empty array, which is return filled by toArray()
        return userList.toArray(new String[userList.size()]);
    }
        
}
