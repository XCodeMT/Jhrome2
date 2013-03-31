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

public class TabMovedEvent extends TabbedPaneEvent {

    public TabMovedEvent(TabbedPane tabbedPane, long timestamp, ITab movedTab, int prevIndex, int newIndex) {
        super(tabbedPane, timestamp);
        this.movedTab = movedTab;
        this.prevIndex = prevIndex;
        this.newIndex = newIndex;
    }
    public final ITab movedTab;
    public final int prevIndex;
    public final int newIndex;

    public ITab getMovedTab() {
        return movedTab;
    }

    public int getPrevIndex() {
        return prevIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    @Override
    public String toString() {
        return String.format("%s[tabbedPane: %s, timestamp: %d, movedTab: %s, prevIndex: %d, newIndex: %d]", getClass().getName(), tabbedPane, timestamp, movedTab, prevIndex, newIndex);
    }
}
