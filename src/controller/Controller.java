package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private View view;
	
	// constructor
	public Controller(UserList model, View view) { 
		// [EX4] - sets the view as an observer of the model
		model.addObserver(view);
		this.model = model;
		// the current controller is the event handler of its view
		view.setController(this);
		this.view = view; 
	}
	
	// starts the controller's view
	public void start() { view.start(); }

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
