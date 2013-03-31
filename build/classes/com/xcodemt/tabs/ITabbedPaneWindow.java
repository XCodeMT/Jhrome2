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
package com.xcodemt.tabs;

import java.awt.Window;

/**
 * The interface for a window containing a {@link TabbedPane}. {@code JhromeTabbedPane} uses this interface to move a jhromeTab that has been torn away into a new window. This allows you to control
 * the layout and attributes of the window besides its tabbed pane.
 *
 * @author andy.edwards
 *
 * @see ITabbedPaneWindowFactory
 */
public interface ITabbedPaneWindow {

    /**
     * @return the {@code JhromeTabbedPane} in the window.
     */
    TabbedPane getTabbedPane();

    /**
     * @return the {@code Window} containing the tabbed pane.
     */
    Window getWindow();

    /**
     * Disposes the window, tabbed pane, and any other associated resources.
     */
    void disposeWindow();
}
