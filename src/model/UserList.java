package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* UserList class
 * Maintains a list of users - implements the read-only representation of the model
 * [EX4] The model is now observable (it can notify its changes to observers)
 */
public class UserList extends Observable implements Model {
	
	// the user list (a user is only represented by a String
	private List<String> userList;
	
	// default constructor - creates an empty user list
	public UserList() { userList = new ArrayList<String>(); }
	
	// adds a user to the list - returns true if the list was changed, false otherwise
	// [EX4] - if the user was successfully added - notify the observers
	public boolean addUser(String user) { 
		if(userList.add(user)) {
			this.setChanged();				// set the observable as changed
			this.notifyObservers();
			return true;
		}
		return false;
	}

	// returns a String[] version of the user list
    public String[] getData() {
    	// passes an empty array, which is return filled by toArray()
        return userList.toArray(new String[userList.size()]);
    }
        
}
