package sort.startPage;

import sort.gui.Frame;
import sort.constants.SortingAlgorithm;
import sort.gui.Graph;

import javax.swing.*;
import java.awt.*;

import static sort.constants.Constants.*;

public class StartPage extends JPanel {
    private Frame frame;
    private JButton bubbleButton;
    private JButton mergeButton;
    private JButton insertionButton;
    private JButton selectionButton;
    private JButton quickButton;

    public StartPage(Frame frame) {
        super();
        this.frame = frame;
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        bubbleButton = new JButton("Bubble Sort") {
            {
                setSize(BUTTON_WIDTH,BUTTON_HEIGHT);
                setLocation((FRAME_WIDTH - BUTTON_WIDTH) / 2, FIRST_BUTTON_Y);
                setVisible(true);
                setFont(new Font("Arial", Font.BOLD, 30));
                addActionListener(e -> handleBubble());
            }
        };
        this.add(bubbleButton);

        mergeButton = new JButton("Merge Sort") {
            {
                setSize(BUTTON_WIDTH,BUTTON_HEIGHT);
                setLocation((FRAME_WIDTH - BUTTON_WIDTH) / 2, FIRST_BUTTON_Y + BUTTON_HEIGHT + 20);
                setVisible(true);
                setFont(new Font("Arial", Font.BOLD, 30));
                addActionListener(e -> handleMerge());
            }
        };
        this.add(mergeButton);

        insertionButton = new JButton("Insertion Sort") {
            {
                setSize(BUTTON_WIDTH,BUTTON_HEIGHT);
                setLocation((FRAME_WIDTH - BUTTON_WIDTH) / 2, FIRST_BUTTON_Y + (2 * (BUTTON_HEIGHT + 20)));
                setVisible(true);
                setFont(new Font("Arial", Font.BOLD, 30));
                addActionListener(e -> handleInsertion());
            }
        };
        this.add(insertionButton);

        selectionButton = new JButton("Selection Sort") {
            {
                setSize(BUTTON_WIDTH,BUTTON_HEIGHT);
                setLocation((FRAME_WIDTH - BUTTON_WIDTH) / 2, FIRST_BUTTON_Y + (3 * (BUTTON_HEIGHT + 20)));
                setVisible(true);
                setFont(new Font("Arial", Font.BOLD, 30));
                addActionListener(e -> handleSelection());
            }
        };
        this.add(selectionButton);

        quickButton = new JButton("Quick Sort") {
            {
                setSize(BUTTON_WIDTH,BUTTON_HEIGHT);
                setLocation((FRAME_WIDTH - BUTTON_WIDTH) / 2, FIRST_BUTTON_Y + (4 * (BUTTON_HEIGHT + 20)));
                setVisible(true);
                setFont(new Font("Arial", Font.BOLD, 30));
                addActionListener(e -> handleQuick());
            }
        };
        this.add(quickButton);

        this.setVisible(true);
    }

    private void handleQuick() {
        this.setVisible(false);
        Graph graph = new Graph(SortingAlgorithm.QUICK, frame);
        frame.add(graph);
        frame.addKeyListener(graph);
        frame.requestFocus();
        frame.remove(this);
    }

    private void handleSelection() {
        this.setVisible(false);
        Graph graph = new Graph(SortingAlgorithm.SELECTION, frame);
        frame.add(graph);
        frame.addKeyListener(graph);
        frame.requestFocus();
        frame.remove(this);
    }

    private void handleInsertion() {
        this.setVisible(false);
        Graph graph = new Graph(SortingAlgorithm.INSERTION, frame);
        frame.add(graph);
        frame.addKeyListener(graph);
        frame.requestFocus();
        frame.remove(this);
    }

    private void handleMerge() {
        this.setVisible(false);
        Graph graph = new Graph(SortingAlgorithm.MERGE, frame);
        frame.add(graph);
        frame.addKeyListener(graph);
        frame.requestFocus();
        frame.remove(this);
    }

    private void handleBubble() {
        this.setVisible(false);
        Graph graph = new Graph(SortingAlgorithm.BUBBLE, frame);
        frame.add(graph);
        frame.addKeyListener(graph);
        frame.requestFocus();
        frame.remove(this);
    }
}
