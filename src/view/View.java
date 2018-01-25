package view;

import java.util.Observer;

/* View interface
 * makes sure that each view can be started by a controller,
 * that can also listen to view events
 * [EX4] - every view are now also observers (that can be notified by observable models)
 */
public interface View extends Observer {
	void setController(GUIListener controller);
	void start();
}
