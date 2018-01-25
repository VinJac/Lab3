package view;

import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;

/* GUIListener interface
 * defines which methods a view expects from its controller
 */
public interface GUIListener {
	ActionListener getAddUserListener(JTextComponent textComponent);
}
