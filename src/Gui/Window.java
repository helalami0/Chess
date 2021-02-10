/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.*;

/**
 *
 * @author helalami
 */
public class Window extends JFrame {
    JPanel board = new JPanel();

    public Window()
    {
        super("Chess Board");
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(board);
        setVisible(true);
    }
}