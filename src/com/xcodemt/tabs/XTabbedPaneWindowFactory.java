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

/**
 * The default implementation of {@link ITabbedPaneWindowFactory}.
 *
 * @author andy.edwards
 */
public class XTabbedPaneWindowFactory implements ITabbedPaneWindowFactory {

    private static int windowCounter = 1;
    public boolean showNewTabButton = true;

    /*
     * (non-Javadoc)
     * 
     * @see org.jhrome.IJhromeWindowFactory#createWindow()
     */
    @Override
    public ITabbedPaneWindow createWindow() {
        XTabbedPaneWindow frame = new XTabbedPaneWindow("Jhrome! " + (windowCounter++));
        frame.getTabbedPane().setWindowFactory(this);
        frame.getTabbedPane().getNewTabButton().setVisible(showNewTabButton);
        frame.setDefaultCloseOperation(XTabbedPaneWindow.EXIT_ON_CLOSE);
        return frame;
    }
}
