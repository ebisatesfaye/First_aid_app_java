package views;

import javax.swing.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Campus First Aid App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("First Aid Tips", new FirstAidPanel());
        tabbedPane.addTab("Emergency Contacts", new EmergencyContactsPanel());
        tabbedPane.addTab("About", new AboutPanel());

        add(tabbedPane);
    }
}