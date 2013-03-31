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
package com.xcodemt.tabs.event;

import com.xcodemt.tabs.ITab;
import com.xcodemt.tabs.TabbedPane;

public class TabSelectedEvent extends TabbedPaneEvent {

    public TabSelectedEvent(TabbedPane tabbedPane, long timestamp, ITab prevSelected, int prevSelectedIndex, ITab newSelected, int newSelectedIndex) {
        super(tabbedPane, timestamp);
        this.prevSelected = prevSelected;
        this.prevSelectedIndex = prevSelectedIndex;
        this.newSelected = newSelected;
        this.newSelectedIndex = newSelectedIndex;
    }
    public final ITab prevSelected;
    public final int prevSelectedIndex;
    public final ITab newSelected;
    public final int newSelectedIndex;

    public ITab getPrevSelected() {
        return prevSelected;
    }

    public ITab getNewSelected() {
        return newSelected;
    }

    public int getPrevSelectedIndex() {
        return prevSelectedIndex;
    }

    public int getNewSelectedIndex() {
        return newSelectedIndex;
    }

    @Override
    public String toString() {
        return String.format("%s[tabbedPane: %s, timestamp: %d, prevSelected: %s, prevSelectedIndex: %d, newIndex: %d]", getClass().getName(), tabbedPane, timestamp, prevSelected, prevSelectedIndex, newSelected, newSelectedIndex);
    }
}
