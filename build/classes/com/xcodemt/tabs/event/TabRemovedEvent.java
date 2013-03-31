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

public class TabRemovedEvent extends TabbedPaneEvent {

    public TabRemovedEvent(TabbedPane tabbedPane, long timestamp, ITab removedTab, int removedIndex) {
        super(tabbedPane, timestamp);
        this.removedTab = removedTab;
        this.removedIndex = removedIndex;
    }
    public final ITab removedTab;
    public final int removedIndex;

    public ITab getRemovedTab() {
        return removedTab;
    }

    public int getRemovedIndex() {
        return removedIndex;
    }

    @Override
    public String toString() {
        return String.format("%s[tabbedPane: %s, timestamp: %d, removedTab: %s, removedIndex: %d]", getClass().getName(), tabbedPane, timestamp, removedTab, removedIndex);
    }
}
