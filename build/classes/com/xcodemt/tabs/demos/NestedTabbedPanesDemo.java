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

import javax.swing.border.EmptyBorder;

import com.xcodemt.tabs.XTabbedPaneWindowFactory;
import com.xcodemt.tabs.ITab;
import com.xcodemt.tabs.ITabbedPaneDnDPolicy;
import com.xcodemt.tabs.ITabbedPaneWindow;
import com.xcodemt.tabs.TabbedPane;

public class NestedTabbedPanesDemo implements ISexyTabsDemo {

    @Override
    public void start() {
        XTabbedPaneWindowFactory windowFactory = new XTabbedPaneWindowFactory();
        ITabbedPaneWindow tabbedPaneWindow = windowFactory.createWindow();
        Window window = tabbedPaneWindow.getWindow();

        TabbedPane innerTabbedPane = new TabbedPane();
        innerTabbedPane.setBorder(new EmptyBorder(30, 5, 5, 5));
        final ITab innerTab1 = tabbedPaneWindow.getTabbedPane().getTabFactory().createTab("Inner Tabbed Pane");
        innerTabbedPane.addTab(innerTab1);
        innerTabbedPane.setSelectedTab(innerTab1);

        innerTabbedPane.setDnDPolicy(new ITabbedPaneDnDPolicy() {
            @Override
            public boolean isTearAwayAllowed(TabbedPane tabbedPane, ITab tab) {
                return tab != innerTab1;
            }

            @Override
            public boolean isSnapInAllowed(TabbedPane tabbedPane, ITab tab) {
                return true;
            }
        });

        final ITab outerTab1 = tabbedPaneWindow.getTabbedPane().getTabFactory().createTab("Outer Tabbed Pane");
        outerTab1.setContent(innerTabbedPane);
        tabbedPaneWindow.getTabbedPane().addTab(outerTab1);
        tabbedPaneWindow.getTabbedPane().setSelectedTab(outerTab1);

        tabbedPaneWindow.getTabbedPane().setDnDPolicy(new ITabbedPaneDnDPolicy() {
            @Override
            public boolean isTearAwayAllowed(TabbedPane tabbedPane, ITab tab) {
                return tab != outerTab1;
            }

            @Override
            public boolean isSnapInAllowed(TabbedPane tabbedPane, ITab tab) {
                return true;
            }
        });

        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
