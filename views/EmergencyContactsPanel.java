package views;

import controllers.EmergencyContactController;
import models.EmergencyContact;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmergencyContactsPanel extends JPanel {
    public EmergencyContactsPanel() {
        setLayout(new BorderLayout());
        EmergencyContactController controller = new EmergencyContactController();
        List<EmergencyContact> contacts = controller.getAllEmergencyContacts();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (EmergencyContact contact : contacts) {
            listModel.addElement(contact.getName() + ": " + contact.getPhoneNumber());
        }

        JList<String> contactList = new JList<>(listModel);
        add(new JScrollPane(contactList), BorderLayout.CENTER);
    }
}