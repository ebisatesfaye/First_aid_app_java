//package views;
//
//import controllers.FirstAidController;
//import models.FirstAidTip;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class FirstAidPanel extends JPanel {
//    public FirstAidPanel() {
//        setLayout(new BorderLayout());
//        FirstAidController controller = new FirstAidController();
//        List<FirstAidTip> tips = controller.getAllFirstAidTips();
//
//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        for (FirstAidTip tip : tips) {
//            listModel.addElement(tip.getTitle() + ": " + tip.getDescription() );
//            JLabel label = new JLabel();
//
//        }
//
//        JList<String> tipList = new JList<>(listModel);
//        add(new JScrollPane(tipList), BorderLayout.CENTER);
//    }
//}


//import javax.swing.*;
//import java.awt.*;
//import java.util.List;
//
//public class FirstAidPanel extends JPanel {
//    public FirstAidPanel() {
//        setLayout(new BorderLayout());
//
//        // Controller to fetch data
//        FirstAidController controller = new FirstAidController();
//        List<FirstAidTip> tips = controller.getAllFirstAidTips();
//
//        // Create a DefaultListModel to hold the data
//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        for (FirstAidTip tip : tips) {
//            // Add a more readable string for each tip
//            listModel.addElement("<html><b>" + tip.getTitle() + ":</b> " + tip.getDescription() + "</html>");
//        }
//
//        // Create a JList to display the tips with custom styling
//        JList<String> tipList = new JList<>(listModel);
//
//        // Set a custom cell renderer for better appearance
//        tipList.setCellRenderer(new DefaultListCellRenderer() {
//            @Override
//            public Component getListCellRendererComponent(
//                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//                // Get the default rendering
//                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//
//                // Apply custom styles
//                label.setFont(new Font("Arial", Font.PLAIN, 14));
//                label.setForeground(isSelected ? Color.WHITE : Color.BLACK);
//                label.setBackground(isSelected ? new Color(0, 102, 204) : Color.WHITE);
//                label.setOpaque(true);
//
//                return label;
//            }
//        });
//
//        // Add a JScrollPane to make the list scrollable
//        JScrollPane scrollPane = new JScrollPane(tipList);
//        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//
//        // Add the scrollPane to the panel
//        add(scrollPane, BorderLayout.CENTER);
//
//        // Add a title label to the panel
//        JLabel titleLabel = new JLabel("First Aid Tips", JLabel.CENTER);
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        titleLabel.setForeground(new Color(0, 102, 204));
//        add(titleLabel, BorderLayout.NORTH);
//    }
//}




package views;

import controllers.FirstAidController;
import models.FirstAidTip;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FirstAidPanel extends JPanel {

    public FirstAidPanel() {
        setLayout(new BorderLayout());

        // 1. Get the tips from your controller
        FirstAidController controller = new FirstAidController();
        List<FirstAidTip> tips = controller.getAllFirstAidTips();

        // 2. Build an HTML string to style your tips
        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<body style='font-family:SansSerif; font-size:14px; line-height:1.5; margin:10px;'>")
                .append("<h2 style='color:#2196F3; font-size:18px;'>First Aid Tips</h2>")
                .append("<ul>");

        for (FirstAidTip tip : tips) {
            sb.append("<li>")
                    .append("<strong>").append(tip.getTitle()).append(":</strong> ")
                    .append(tip.getDescription())
                    .append("</li>");
        }

        sb.append("</ul>")
                .append("</body></html>");

        // 3. Create a non-editable text pane to display the HTML
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setEditable(false);
        textPane.setText(sb.toString());
        textPane.setCaretPosition(0); // Scroll to top by default

        // 4. Put the text pane in a scroll pane
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // 5. Add to this panel
        add(scrollPane, BorderLayout.CENTER);
    }
}











