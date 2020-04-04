package v2ch10.longList;

import java.awt.*;

import javax.swing.*;

/**
 * This frame contains a long word list and a label that shows a sentence made up from the chosen
 * word.
 */
public class LongListFrame extends JFrame {

    private static final int LETTER_COUNT = 5;
    private static final String SINGLE_PROTOTYPE_CELL_VALUE = "w";

    private JList<String> wordList;
    private JLabel label;
    private String prefix = "The quick brown ";
    private String suffix = " jumps over the lazy dog.";

    public LongListFrame() {
        wordList = new JList<>(new WordListModel(LETTER_COUNT));
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wordList.setPrototypeCellValue(computePrototypeCellValue(LETTER_COUNT));
        JScrollPane scrollPane = new JScrollPane(wordList);

        JPanel p = new JPanel();
        p.add(scrollPane);
        wordList.addListSelectionListener(event -> setSubject(wordList.getSelectedValue()));

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.NORTH);
        label = new JLabel(prefix + suffix);
        contentPane.add(label, BorderLayout.CENTER);
        setSubject("fox");
        pack();
    }

    private String computePrototypeCellValue(int letterCount) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < letterCount; i++) {
            resultStr.append(SINGLE_PROTOTYPE_CELL_VALUE);
        }
        return resultStr.toString();
    }

    /**
     * Sets the subject in the label.
     * @param word the new subject that jumps over the lazy dog
     */
    public void setSubject(String word) {
        String text = prefix + word + suffix;
        label.setText(text);
    }
}
