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
package com.xcodemt.tabs.launchers;

import java.awt.Dimension;
import java.awt.Window;

import javax.swing.SwingUtilities;

import com.xcodemt.tabs.XTab;
import com.xcodemt.tabs.XTabbedPaneWindowFactory;
import com.xcodemt.tabs.ITabbedPaneWindow;
import com.xcodemt.tabs.ITabbedPaneWindowFactory;
import com.xcodemt.tabs.TabbedPane;

public class JhromeTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ITabbedPaneWindowFactory windowFactory = new XTabbedPaneWindowFactory();
                ITabbedPaneWindow tabbedPaneWindow = windowFactory.createWindow();
                Window window = tabbedPaneWindow.getWindow();
                TabbedPane tabbedPane = tabbedPaneWindow.getTabbedPane();

                for (int i = 0; i < 1; i++) {
                    XTab defaultTab = new XTab("Tab " + i);
                    tabbedPane.addTab(i, defaultTab);
                    tabbedPane.setSelectedTab(defaultTab);
                }

                window.setSize(new Dimension(800, 600));
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }
}
