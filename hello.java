import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class ToDoList extends JFrame {
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoList() {
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top input field
        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");

        // Task list
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        JButton removeButton = new JButton("Remove Task");
        JButton clearButton = new JButton("Clear All");

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(clearButton);

        // Add components to frame
        add(taskField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Event Listeners
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                taskField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskModel.remove(selectedIndex);
            }
        });

        clearButton.addActionListener(e -> taskModel.clear());

        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}
