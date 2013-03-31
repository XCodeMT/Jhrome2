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

import java.util.List;

import com.xcodemt.tabs.ITab;
import com.xcodemt.tabs.TabbedPane;

public class TabsClearedEvent extends TabbedPaneEvent {

    public TabsClearedEvent(TabbedPane tabbedPane, long timestamp, List<ITab> removedTabs) {
        super(tabbedPane, timestamp);
        this.removedTabs = removedTabs;
    }
    public final List<ITab> removedTabs;

    public List<ITab> getRemovedTabs() {
        return removedTabs;
    }

    @Override
    public String toString() {
        return String.format("%s[tabbedPane: %s, timestamp: %d]", getClass().getName(), tabbedPane, timestamp);
    }
}
