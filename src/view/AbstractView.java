package view;

import model.Model;

public abstract class AbstractView implements View {
	
	private GUIListener controller;
	private final Model model;
	
	public AbstractView(Model model){
		this.model = model;
	}
	
	//Protected so the other views can access it
	//Final because we only have 1 model and we cannot modify it
	protected final Model getModel(){ return model; }
	//Same for controller
	protected final GUIListener getController(){ return controller; }
	
}
