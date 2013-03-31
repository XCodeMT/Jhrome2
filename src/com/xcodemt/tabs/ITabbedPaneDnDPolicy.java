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
 * Controls the drag and drop policy of a {@link TabbedPane}. This includes whether tabs may be torn away from the tabbed pane or snapped in.
 *
 * @author andy.edwards
 *
 */
public interface ITabbedPaneDnDPolicy {

    /**
     * Controls whether a jhromeTab may be "torn away" from a {@code JhromeTabbedPane} (if it can be removed by being dragged out of the tabbed pane).
     *
     * @param tabbedPane the {@code JhromeTabbedPane} the user is dragging the jhromeTab out of.
     * @param tab the {@code IJhromeTab} the user is dragging.
     * @return {@code true} if {@code jhromeTab} may be torn away from {@code tabbedPane}.
     */
    boolean isTearAwayAllowed(TabbedPane tabbedPane, ITab tab);

    /**
     * Controls whether a jhromeTab may be "snapped in" to a {@code JhromeTabbedPane} (if it can be added by being dragged over the tabbed pane).
     *
     * @param tabbedPane the {@code JhromeTabbedPane} the user is dragging the jhromeTab over.
     * @param tab the {@code IJhromeTab} the user is dragging.
     * @return {@code true} if {@code jhromeTab} may be snapped into {@code tabbedPane}.
     */
    boolean isSnapInAllowed(TabbedPane tabbedPane, ITab tab);
}
