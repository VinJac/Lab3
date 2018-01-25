package view;

/* View interface
 * makes sure that each view can be started by a controller,
 * that can also listen to view events
 */
public interface View {
	void setController(GUIListener controller);
	void start();
}
