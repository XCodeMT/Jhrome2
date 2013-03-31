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

import com.xcodemt.tabs.TabbedPane;

public class TabbedPaneEvent {

    public TabbedPaneEvent(TabbedPane tabbedPane, long timestamp) {
        this.timestamp = timestamp;
        this.tabbedPane = tabbedPane;
    }
    public final TabbedPane tabbedPane;
    public final long timestamp;

    public TabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
