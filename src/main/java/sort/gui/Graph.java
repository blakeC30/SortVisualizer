package sort.gui;

import sort.algorithms.*;
import sort.constants.SortingAlgorithm;
import sort.startPage.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

import static sort.constants.Constants.*;

public class Graph extends JPanel implements KeyListener {
    private Frame frame;
    private SortingAlgorithm algorithm;
    private List<Integer> list;
    private AbstractSort sort;

    public Graph(SortingAlgorithm algorithm, Frame frame) {
        super();
        this.algorithm = algorithm;
        this.frame = frame;
        this.setBackground(Color.BLACK);

        (new Thread(this::draw)
            ).start();

        List<Integer> numbers = new ArrayList<>();
        list = new ArrayList<>();
        for(int i = 1; i <= LIST_SIZE; i++) {
            numbers.add(i);
        }

        while(!numbers.isEmpty()) {
            int random = (int) (Math.random() * numbers.size());
            list.add(numbers.get(random));
            numbers.remove(random);
        }

        initializeSort();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,FRAME_WIDTH,FRAME_HEIGHT);

        g2.setColor(Color.GREEN);
        int x = GRAPH_MARGIN;
        int barWidth = (int)(((FRAME_WIDTH - (2 * GRAPH_MARGIN)) / (double)LIST_SIZE));

        for(int i = 0; i < LIST_SIZE; i++) {
            int barHeight = (int) ((list.get(i) / (double)LIST_SIZE) * (FRAME_HEIGHT - (2 * GRAPH_MARGIN)));
            int y = GRAPH_MARGIN + ((FRAME_HEIGHT - (2 * GRAPH_MARGIN)) - barHeight);
            g2.fillRect(x, y, barWidth, barHeight);
            x += barWidth;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            (new Thread(() -> sort.sort())
            ).start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_N) {
            this.setVisible(false);
            frame.add(new StartPage(frame));
            frame.remove(this);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void initializeSort() {
        switch(algorithm) {
            case BUBBLE -> this.sort = new BubbleSort(list);
            case MERGE -> this.sort = new MergeSort(list);
            case INSERTION -> this.sort = new InsertionSort(list);
            case SELECTION -> this.sort = new SelectionSort(list);
            case QUICK -> this.sort = new QuickSort(list);
        };
    }

    private void draw() {
    while(true) {
        repaint();
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
