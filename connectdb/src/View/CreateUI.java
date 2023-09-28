package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class CreateUI extends JFrame {
    public CreateUI() {
        DesignUI();
        AttachEvent();
    }

    private void DesignUI() {
        this.setDefaultCloseOperation(3);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createRigidArea(new Dimension(15, 15)));

        JPanel viewPanel = new JPanel();
        viewPanel.setPreferredSize(new Dimension(600, 300));
        // viewPanel.setBackground(Color.red);
        mainPanel.add(viewPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(15, 15)));

        JPanel btnPanel = new JPanel();
        btnPanel.setPreferredSize(new Dimension(600, 100));
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        // viewPanel2.setBackground(Color.blue);

        JButton btn_OK = new JButton("OK");
        btnPanel.add(btn_OK);

        JButton btn_Cancel = new JButton("Cancel");
        btnPanel.add(Box.createRigidArea(new Dimension(15, 15)));
        btnPanel.add(btn_Cancel);

        mainPanel.add(btnPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(15, 15)));

        this.add(mainPanel);

        this.setSize(600, 400);
        this.setVisible(true);
    }

    private void AttachEvent() {

    }
}
