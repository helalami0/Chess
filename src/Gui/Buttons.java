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
public class Buttons extends JFrame {
    JPanel pnl = new JPanel();

    ClassLoader ldr = this.getClass().getClassLoader();

    java.net.URL tickURL = ldr.getResource("img/tick.png");
    java.net.URL crossURL = ldr.getResource("img/cross.png");

    ImageIcon tick = new ImageIcon(tickURL);
    ImageIcon cross = new ImageIcon(crossURL);

    JButton btn = new JButton("Click Me");
    JButton tickBtn = new JButton(tick);
    JButton crossBtn = new JButton("STOP", cross);

    public Buttons()
    {
        super("Chess Board");
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);
        pnl.add(btn);
        pnl.add(tickBtn);
        pnl.add(crossBtn);
        setVisible(true);
        validate();
    }
}
