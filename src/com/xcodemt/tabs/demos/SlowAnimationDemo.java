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

import java.awt.Window;

import com.xcodemt.tabs.XTabbedPaneWindowFactory;
import com.xcodemt.tabs.ITab;
import com.xcodemt.tabs.ITabbedPaneWindow;

public class SlowAnimationDemo implements ISexyTabsDemo {

    @Override
    public void start() {
        XTabbedPaneWindowFactory windowFactory = new XTabbedPaneWindowFactory() {
            @Override
            public ITabbedPaneWindow createWindow() {
                ITabbedPaneWindow window = super.createWindow();
                window.getTabbedPane().setAnimationFactor(0.95f);
                return window;
            }
        };
        ITabbedPaneWindow tabbedPaneWindow = windowFactory.createWindow();
        Window window = tabbedPaneWindow.getWindow();

        ITab tab1 = tabbedPaneWindow.getTabbedPane().getTabFactory().createTab();
        tabbedPaneWindow.getTabbedPane().addTab(tab1);
        tabbedPaneWindow.getTabbedPane().setSelectedTab(tab1);

        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
