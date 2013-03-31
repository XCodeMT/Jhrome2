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

public class TabAddedEvent extends TabbedPaneEvent {

    public TabAddedEvent(TabbedPane tabbedPane, long timestamp, ITab addedTab, int insertIndex) {
        super(tabbedPane, timestamp);
        this.addedTab = addedTab;
        this.insertIndex = insertIndex;
    }
    public final ITab addedTab;
    public final int insertIndex;

    public ITab getAddedTab() {
        return addedTab;
    }

    public int getInsertIndex() {
        return insertIndex;
    }

    @Override
    public String toString() {
        return String.format("%s[tabbedPane: %s, timestamp: %d, addedTab: %s, insertIndex: %d]", getClass().getName(), tabbedPane, timestamp, addedTab, insertIndex);
    }
}
