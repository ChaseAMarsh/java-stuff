import javafx.scene.layout.Border;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import static javax.swing.SwingConstants.CENTER;

public class TextEditor extends JFrame {

    private JFrame frame;
    private JTextPane editor;
    private JScrollPane editorScrollPane;
    private JMenuBar topMenu;

    private static final String DEFAULT_FONT_FAMILY = "SansSerif";
    private static final int DEFAULT_FONT_SIZE = 18;

    public TextEditor() {
        init();
    }

    private void init() {
        editor = new JTextPane();
        editorScrollPane = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        topMenu = new JMenuBar();

        setJMenuBar(topMenu);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        topMenu.add(file);
        topMenu.add(edit);

        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(SaveAs);
        file.add(Quit);
        file.addSeparator();

        setTitle("Marsh Text Editor");
        add(editorScrollPane, BorderLayout.CENTER);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        UIManager.put("TextPane.font", new Font(DEFAULT_FONT_FAMILY, Font.PLAIN, DEFAULT_FONT_SIZE));
        //UIManager.setLookAndFeel(new NimbusLookAndFeel());

        EventQueue.invokeLater(() -> {
            TextEditor t1 = new TextEditor();
            t1.setVisible(true);
        });
    }
}
