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

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.HashSet;

/**
 * A tool that allows you listen to a {@link Component} and all of its children. Even when children or added or removed, the listeners will automatically be added/removed as necessary.
 *
 * @author andy.edwards
 *
 */
public abstract class RecursiveListener {

    private ContainerListener containerListener = new HierarchyChangeListener();
    private HashSet<Component> excluded = new HashSet<Component>();

    public void addExcludedComponent(Component c) {
        excluded.add(c);
    }

    public void removeExcludedComponent(Component c) {
        excluded.remove(c);
    }

    private class HierarchyChangeListener implements ContainerListener {

        @Override
        public void componentAdded(ContainerEvent e) {
            installRecursively(e.getChild());
        }

        @Override
        public void componentRemoved(ContainerEvent e) {
            uninstallRecursively(e.getChild());
        }
    }

    public void installRecursively(Component c) {
        if (excluded.contains(c)) {
            return;
        }
        install(c);
        if (c instanceof Container) {
            Container cont = (Container) c;
            cont.addContainerListener(containerListener);
            installRecursively(cont);
        }
    }

    public void uninstallRecursively(Component c) {
        uninstall(c);
        if (c instanceof Container) {
            Container cont = (Container) c;
            cont.removeContainerListener(containerListener);
            uninstallRecursively(cont);
        }
    }

    protected abstract void install(Component c);

    protected abstract void uninstall(Component c);
}
