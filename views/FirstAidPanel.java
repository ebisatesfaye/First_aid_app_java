package views;

import controllers.FirstAidController;
import models.FirstAidTip;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FirstAidPanel extends JPanel {
    public FirstAidPanel() {
        setLayout(new BorderLayout());
        FirstAidController controller = new FirstAidController();
        List<FirstAidTip> tips = controller.getAllFirstAidTips();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (FirstAidTip tip : tips) {
            listModel.addElement(tip.getTitle() + ": " + tip.getDescription());
        }

        JList<String> tipList = new JList<>(listModel);
        add(new JScrollPane(tipList), BorderLayout.CENTER);
    }
}