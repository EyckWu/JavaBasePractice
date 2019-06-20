package com.eyckwu.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ListenerLambda {
    public static void main(String[] args) {
        JButton show = new JButton("Show");
        show.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
}
