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
package com.xcodemt.tabs.jhrome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Path2D;

import javax.swing.border.Border;

import com.xcodemt.tabs.Utils;

public class JhromeNewTabButtonBorder implements Border {

    public static class Attributes {

        public float slant = 4.5f;
        public Color fillColor = new Color(255, 255, 255, 48);
        public Color borderColor = JhromeTabBorderAttributes.UNSELECTED_BORDER.outlineColor;
        public Stroke borderStroke = JhromeTabBorderAttributes.UNSELECTED_BORDER.outlineStroke;

        public Attributes() {
        }

        public Attributes(Attributes other) {
            copy(other);
        }

        public void copy(Attributes other) {
            slant = other.slant;
            fillColor = other.fillColor;
            borderColor = other.borderColor;
            borderStroke = other.borderStroke;
        }

        @Override
        public Attributes clone() {
            return new Attributes(this);
        }

        public void interpolateColors(Attributes a, Attributes b, float f) {
            borderColor = Utils.interpolate(a.borderColor, b.borderColor, f);
            fillColor = Utils.interpolate(a.fillColor, b.fillColor, f);
        }
    }
    public static final Attributes UNSELECTED_ATTRIBUTES = new Attributes();
    public static final Attributes ROLLOVER_ATTRIBUTES = new Attributes();
    public static final Attributes PRESSED_ATTRIBUTES = new Attributes();

    static {
        ROLLOVER_ATTRIBUTES.fillColor = new Color(255, 255, 255, 128);
        PRESSED_ATTRIBUTES.fillColor = new Color(196, 196, 196, 128);
        PRESSED_ATTRIBUTES.borderColor = JhromeTabBorderAttributes.SELECTED_BORDER.outlineColor;
    }
    public final Attributes attrs = new Attributes();

    public void paint(Component c, Graphics g, int x, int y, int width, int height, boolean paintBorder, boolean paintBackground) {
        Path2D path = new Path2D.Float();
        path.moveTo(x, y);
        path.lineTo(x + width - 1 - attrs.slant * 2, y);
        path.curveTo(x + width - 1 - attrs.slant, y, x + width - 1 - attrs.slant, y, x + width - 1, y + height - 1);
        path.lineTo(x + attrs.slant * 2, y + height - 1);
        path.curveTo(x + attrs.slant, y + height - 1, x + attrs.slant, y + height - 1, x, y);

        Graphics2D g2 = (Graphics2D) g;

        Object prevAntialias = g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Stroke prevStroke = g2.getStroke();
        Paint prevPaint = g2.getPaint();

        if (paintBackground) {
            g2.setColor(attrs.fillColor);
            g2.fill(path);
        }

        if (paintBorder) {
            g2.setColor(attrs.borderColor);
            g2.setStroke(attrs.borderStroke);
            g2.draw(path);
        }

        g2.setPaint(prevPaint);
        g2.setStroke(prevStroke);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, prevAntialias);

    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        paint(c, g, x, y, width, height, true, false);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int i = 2;
        return new Insets(i, i + (int) attrs.slant, i, i + (int) attrs.slant);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
