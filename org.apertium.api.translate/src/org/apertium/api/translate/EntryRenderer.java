/**
 * This file is part of the eConference project and it is distributed under the 

 * terms of the MIT Open Source license.
 * 
 * The MIT License
 * Copyright (c) 2010 Collaborative Development Group - Dipartimento di Informatica, 
 *                    University of Bari, http://cdg.di.uniba.it
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this 
 * software and associated documentation files (the "Software"), to deal in the Software 
 * without restriction, including without limitation the rights to use, copy, modify, 
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to 
 * permit persons to whom the Software is furnished to do so, subject to the following 
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies 
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.apertium.api.translate;

import javax.swing.*;
import java.awt.*;

public class EntryRenderer extends JLabel implements ListCellRenderer {

	private static final long serialVersionUID = -8230366668996692971L;

	public EntryRenderer() {
		this.setOpaque(true);
	}

	public Component getListCellRendererComponent(JList listbox, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		String pair = (String) value;

		if (pair != null) {
			this.setText(pair);
		}

		if (isSelected) {
			this.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
			this.setForeground(UIManager.getColor("ComboBox.selectionForeground"));
		} else {
			this.setBackground(UIManager.getColor("ComboBox.background"));
			this.setForeground(UIManager.getColor("ComboBox.foreground"));
		}

		return this;
	}

}
