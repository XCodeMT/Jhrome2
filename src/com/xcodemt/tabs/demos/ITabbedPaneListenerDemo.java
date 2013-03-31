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

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.xcodemt.tabs.XTab;
import com.xcodemt.tabs.XTabbedPaneWindow;
import com.xcodemt.tabs.ITab;
import com.xcodemt.tabs.ITabbedPaneDnDPolicy;
import com.xcodemt.tabs.ITabbedPaneWindow;
import com.xcodemt.tabs.TabbedPane;
import com.xcodemt.tabs.event.ITabbedPaneListener;
import com.xcodemt.tabs.event.TabAddedEvent;
import com.xcodemt.tabs.event.TabMovedEvent;
import com.xcodemt.tabs.event.TabRemovedEvent;
import com.xcodemt.tabs.event.TabSelectedEvent;
import com.xcodemt.tabs.event.TabbedPaneEvent;
import com.xcodemt.tabs.event.TabsClearedEvent;

public class ITabbedPaneListenerDemo implements ISexyTabsDemo {

    @Override
    public void start() {
        ITabbedPaneWindow tabbedPaneWindow = new XTabbedPaneWindow("ITabbedPaneListener Demo");
        Window window = tabbedPaneWindow.getWindow();

        final JTextArea messageArea = new JTextArea();
        final JScrollPane messageScroller = new JScrollPane(messageArea);

        ITabbedPaneListener listener = new ITabbedPaneListener() {
            StringBuffer text = new StringBuffer();

            @Override
            public void onEvent(TabbedPaneEvent event) {
                text.append(formatEvent(event)).append('\n');
                messageArea.setText(text.toString());
                messageScroller.getVerticalScrollBar().setValue(messageScroller.getVerticalScrollBar().getMaximum());
            }
        };
        tabbedPaneWindow.getTabbedPane().addTabbedPaneListener(listener);
        final XTab listenerTab = new XTab("Listener", messageScroller);
        listenerTab.getCloseButton().setVisible(false);
        tabbedPaneWindow.getTabbedPane().addTab(listenerTab);
        tabbedPaneWindow.getTabbedPane().setSelectedTab(listenerTab);
        tabbedPaneWindow.getTabbedPane().setDnDPolicy(new ITabbedPaneDnDPolicy() {
            @Override
            public boolean isTearAwayAllowed(TabbedPane tabbedPane, ITab tab) {
                return tab != listenerTab;
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

    private static String formatEvent(TabbedPaneEvent event) {
        if (event instanceof TabAddedEvent) {
            TabAddedEvent e = (TabAddedEvent) event;
            return "Added tab '" + getTabTitle(e.getAddedTab()) + "' at index " + e.getInsertIndex();
        } else if (event instanceof TabRemovedEvent) {
            TabRemovedEvent e = (TabRemovedEvent) event;
            return "Removed tab '" + getTabTitle(e.getRemovedTab()) + "' at index " + e.getRemovedIndex();
        } else if (event instanceof TabMovedEvent) {
            TabMovedEvent e = (TabMovedEvent) event;
            return "Moved tab '" + getTabTitle(e.getMovedTab()) + "' from index " + e.getPrevIndex() + " to index " + e.getNewIndex();
        } else if (event instanceof TabSelectedEvent) {
            TabSelectedEvent e = (TabSelectedEvent) event;
            return "Selected tab '" + getTabTitle(e.getNewSelected()) + "' at index " + e.getNewSelectedIndex();
        } else if (event instanceof TabsClearedEvent) {
            return "Cleared all tabs";
        }
        return "";
    }

    private static String getTabTitle(ITab tab) {
        if (tab == null) {
            return "none";
        }
        return ((XTab) tab).getLabel().getText();
    }
}
