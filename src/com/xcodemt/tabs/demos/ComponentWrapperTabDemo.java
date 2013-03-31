/*
 * This file is part of Jhrome2.
 * 
 * Copyright (C) 2013 Silas Schwarz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xcodemt.tabs.demos;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.xcodemt.tabs.ComponentWrapperTab;
import com.xcodemt.tabs.XTabbedPaneWindowFactory;
import com.xcodemt.tabs.ITabbedPaneWindow;

public class ComponentWrapperTabDemo implements ISexyTabsDemo {

    @Override
    public void start() {
        XTabbedPaneWindowFactory windowFactory = new XTabbedPaneWindowFactory();
        ITabbedPaneWindow tabbedPaneWindow = windowFactory.createWindow();
        final Window window = tabbedPaneWindow.getWindow();

        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Pretty cool huh?");
            }
        });

        JTextField textField = new JTextField("Edit Me!");
        textField.setTransferHandler(null);

        JPanel renderer = new JPanel(new GridLayout(2, 1, 2, 2));
        renderer.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 5, 5, 5)));
        renderer.add(button);
        renderer.add(textField);

        ComponentWrapperTab tab1 = new ComponentWrapperTab(renderer, null);
        tabbedPaneWindow.getTabbedPane().addTab(tab1);
        tabbedPaneWindow.getTabbedPane().setSelectedTab(tab1);

        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
