package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.text.JTextComponent;

import model.UserList;
import view.*;

/* Controller class
 * handle event propagated by the view by modifying the model
 */

/* Question 1.
 * 
 * The controller has a reference to a UserList because it needs to modify the model
 * (the Model interface only provides a read-only access, so that it can be used by the view)
 * 
 * The controller has a reference to the View interface to be as generic as possible.
 * View is a view abstraction that only provides the methods needed by the controller,
 * therefore here the view could refer to any view implementing the interface, without
 * changing the controller class.
 */
public class Controller implements GUIListener {

	private UserList model;
	// [EX5] - the controller is now built from a set of views
	private Set<View> viewSet;
	
	// constructor
	public Controller(UserList model, Set<View> viewSet) { 
		// [EX4 | EX5] - sets the views observers of the model
		Iterator<View> iterator = viewSet.iterator();
		while(iterator.hasNext()){
			View view = iterator.next();
			model.addObserver(view);		// each view is an observer of the model
			view.setController(this);		// the current controller is the event handler of its views
		}
		this.model = model;
		this.viewSet = viewSet; 
	}
	
	// starts the controller's views
	public void start() { 
		Iterator<View> iterator = viewSet.iterator();
		while(iterator.hasNext()){
			iterator.next().start();
		}
	}

	// returns an ActionListener that handles the event of the JTextField
	// component of the GUI. => adding the entered text as a user in the user list.
	// Note: an action event is triggered when the ENTER key is pressed while focusing
	// a text component.
	@Override
	public ActionListener getAddUserListener(JTextComponent textComponent) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// retrieves the text contained in the text component
				String user = textComponent.getText(); 
				// if it is not empty, add it in the user list
				if(!user.equals(""))
					model.addUser(user);
			}
		}; 
	}
}
