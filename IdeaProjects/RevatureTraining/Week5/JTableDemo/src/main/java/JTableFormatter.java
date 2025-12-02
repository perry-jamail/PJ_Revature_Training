import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTableFormatter {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "Smith", 30));
        users.add(new User("Bob", "Johnson", 24));
        users.add(new User("Charlie", "Brown", 45));

        JFrame frame = new JFrame("User List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        String[] columnNames = {"First Name", "Last Name", "Age"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (User user : users) {
            model.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getAge()});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}