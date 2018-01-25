package view;

import model.Model;

/* AbstractView class
 * defines a general view:
 * - has a reference to a read-only model
 * - has a reference to its controller to propagate events handling
 */
public abstract class AbstractView implements View {
	
	// event handler and read-only model
	// Question 6. the controller cannot be declared as final, because we have to set
	// it with the provided setController() method (therefore it cannot be initialized before)
	private GUIListener controller;
	private Model model;
	
	// constructor
	public AbstractView(Model model) {
		this.model = model;
	}
	
	// read access to the model and event handler from the child classes
	/* Question 3.
	 * These methods are protected because we want them to be private in the
	 * daughter classes (because they are part of an internal process in the views)
	 * They are final because we don't want them to be overridden by the daughter views
	 * (we want to fix their behavior)
	 */
	protected final Model getModel() { return model; }
	protected final GUIListener getController() { return controller; }
	
	// each view must be able to be set its event handler (this will be from the controller)
	@Override
	public void setController(GUIListener controller) { this.controller = controller; }
	
}
