package org.eclipse.kEEPER.plugin.ui.figures;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import model.Type;
import model.Initially;

public class InitiallyFigure extends Shape{
	private RoundedRectangle r;
	private Initially in;
	private ArrayList<Type> typesList = new ArrayList<Type>();

	
	public InitiallyFigure(RoundedRectangle r, Initially in){
		this.r = r;
		this.in = in;
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.pushState();       
        graphics.setFillRule(SWT.FILL_WINDING);
        graphics.popState();
		
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		// Main parameters
		int mainWidth = r.getSize().width();
	    int mainHeight = r.getSize().height();
	    int mainX = r.getLocation().x;
	    int mainY = r.getLocation().y;
	    
	    // Drawing black line
	    graphics.setForegroundColor(new Color(null, 0, 0, 0));
	    graphics.drawLine(mainX, mainY + mainHeight/4, mainX+ mainWidth, mainY + mainHeight/4);
	    
	    // Drawing title label
	    if (in.getContextRelation() != null){
		    int lettersCounter = in.getContextRelation().getName().length();
		    if (!in.getContextRelation().getName().isEmpty()){
		    	graphics.setFont(new Font(null, "Arial", 12, 1));
		    	graphics.drawString(in.getContextRelation().getName(), new Point(mainX + mainWidth/2 - lettersCounter*3, mainY + mainHeight/8));
		    }		    
	   }
	    for (int i = 0; i < in.getInstances().size(); i++){
	    	 //	Image img = new Image(null,"src/images/Instance.gif");
		    	
		    //	graphics.drawImage(img, mainX, mainY);
	    	graphics.setFont(new Font(null, "Arial", 10, 1));
	    	Point instanceLabel = new Point(mainX + mainWidth/10, mainY + mainHeight/3 + i*10);
    		graphics.drawString(in.getInstances().get(i).getName(), instanceLabel);
	    }
		
	}

}
