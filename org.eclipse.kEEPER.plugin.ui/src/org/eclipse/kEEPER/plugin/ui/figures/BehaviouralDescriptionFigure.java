package org.eclipse.kEEPER.plugin.ui.figures;

import java.awt.Component;


import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import model.BehaviouralDescription;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;

import org.eclipse.emf.common.util.EList;



import org.eclipse.draw2d.Graphics;



public class BehaviouralDescriptionFigure extends Shape{
		private int timeInstants;
		private RectangleFigure r;
		private BehaviouralDescription bd;
		
		private ArrayList<Happens> happensList = new ArrayList<Happens>();
		private ArrayList<HoldsAt> holdsAtList = new ArrayList<HoldsAt>();
		private ArrayList<HoldsAtBetween> holdsAtBetweenList = new ArrayList<HoldsAtBetween>();
		
		/*
		 * Constructor that set the number of time instants of the figure
		 */
		public BehaviouralDescriptionFigure(RectangleFigure r, BehaviouralDescription bd) {
			System.out.println("BehaviouralDescription Constructor!");
			// behavDesc = (BehaviouralDescription) eObject;
			this.r = r;
			this.bd = bd;
			// Input the number of time instants 
			System.out.println(bd.getTimeInstants());
			if(bd.getTimeInstants() != 0){
				timeInstants = bd.getTimeInstants();
			/*	System.out.println("Dentro l'if");
				InputDialog inputDialog = new InputDialog(null, "Events", "Input the number of events", null, new IInputValidator() {

		        public String isValid(final String s) {
		            if (s.getBytes().length > 1024) {
		                return "Value too long!";
		            }
		            return null;
		        }
		    });
			inputDialog.open();	
			
			String time = inputDialog.getValue();
			this.timeInstants = Integer.parseInt(time);
		*/	}
			
		}
		
		@Override
	    protected void fillShape(Graphics graphics) {
		//	System.out.println("I'm in fillShape()");
	        graphics.pushState();       
	        graphics.setFillRule(SWT.FILL_WINDING);
	        graphics.popState();
	    }
		
		@Override
	    protected void outlineShape(Graphics graphics) {  

	        ArrayList<RectangleFigure> sr = new ArrayList<RectangleFigure>();
	        int mainWidth = r.getSize().width();
	        int mainHeight = r.getSize().height();
	        int mainX = r.getLocation().x;
	        int mainY = r.getLocation().y;
	        int k = 10;
	        int length = mainWidth/(bd.getTimeInstants()+1);
	        //System.out.println("A:" + mainWidth +" B:" +  mainHeight +" C:" +  mainX + " D:" + mainY );
	        graphics.setForegroundColor(new Color(null, 129, 23, 45));
	        
	        // Creating main line
	        for (int i = -2; i < 3; i++){
	        	graphics.drawLine(mainX, mainY+mainHeight/2 +i, r.getLocation().x +r.getSize().width(), mainY+mainHeight/2 +i);
	        }
	        
	        // Creating small lines for the timeline
	        for (int i = 1; i <= bd.getTimeInstants(); i++){
	        	Point p1 = new Point(mainX+length*i, mainY+(mainHeight/2)-10);
	        	Point p2 = new Point(mainX+length*i, mainY+(mainHeight/2)+10);
	      
	        	graphics.drawLine(p1, p2);

	        }
	        
	        if (!bd.getHappens().isEmpty()){
	        	System.out.println("Creating point for events");
	        	for (int i = 0; i < bd.getHappens().size(); i++){
	        		graphics.setForegroundColor(new Color(null, 0, 0, 255));
	        		graphics.setBackgroundColor(new Color(null, 0, 0, 255));
	        		Point ovalStartingPoint = new Point(mainX + length*bd.getHappens().get(i).getTime() -3 , mainY + mainHeight/2 - 20);
	        		graphics.drawOval(ovalStartingPoint.x, ovalStartingPoint.y, 6, 6);
	        		Point label = new Point(mainX + length*bd.getHappens().get(i).getTime() -3 -10, mainY + mainHeight/2 - 20 - 10);
	        		graphics.drawString(bd.getHappens().get(i).getEvent().getName(), label);
	        	}
	        	
	        }
	        
	        if (!bd.getHoldsAts().isEmpty()){
		        System.out.println("Creating point for CR");
		        for (int i = 0; i < bd.getHoldsAts().size(); i++){
		        	
		        	if (bd.getHoldsAts().get(i).isIsHolding())
		        		graphics.setForegroundColor(new Color(null, 50, 205, 50));
		        	else
		        		graphics.setForegroundColor(new Color(null, 255, 0, 0));
		        	
		        	Point ovalStartingPoint = new Point(mainX + length*bd.getHoldsAts().get(i).getTime() -3 , mainY + mainHeight/2 + 20);
		        	graphics.drawOval(ovalStartingPoint.x, ovalStartingPoint.y, 6, 6);
		        	Point label = new Point(mainX + length*bd.getHoldsAts().get(i).getTime() -3 -10, mainY + mainHeight/2 + 20 + 7);
	        		graphics.drawString(bd.getHoldsAts().get(i).getContextRelation().getName(), label);
		        }

	        }
	        
	        if (!bd.getHoldsAtBetweens().isEmpty()){
		        System.out.println("Creating rectangle for CR");
		        for (int i = 0; i < bd.getHoldsAtBetweens().size(); i++){
		        	
		        	if (bd.getHoldsAtBetweens().get(i).isIsHolding())
		        		graphics.setForegroundColor(new Color(null, 50, 205, 50));
		        	else
		        		graphics.setForegroundColor(new Color(null, 255, 0, 0));
		        	
		        	Point rectangleP1 = new Point(mainX + length*bd.getHoldsAtBetweens().get(i).getInitialTime() , mainY + mainHeight/2 + 40);
		        	Point rectangleP2 = new Point(mainX + length*bd.getHoldsAtBetweens().get(i).getInitialTime() , mainY + mainHeight/2 + 45);
		        	Point rectangleP3 = new Point(mainX + length*bd.getHoldsAtBetweens().get(i).getEndingTime() , mainY + mainHeight/2 + 45);
		        	Point rectangleP4 = new Point(mainX + length*bd.getHoldsAtBetweens().get(i).getEndingTime() , mainY + mainHeight/2 + 40);
		        	PointList points = new PointList();
		        	points.addPoint(rectangleP1);
		        	points.addPoint(rectangleP2);
		        	points.addPoint(rectangleP3);
		        	points.addPoint(rectangleP4);
		        	
		        	graphics.drawPolygon(points);
		        	Point label = new Point(mainX + length*bd.getHoldsAtBetweens().get(i).getInitialTime(), mainY + mainHeight/2 +45 + 7);
	        		graphics.drawString(bd.getHoldsAtBetweens().get(i).getContextRelation().getName(), label);

		        }

	        }
	        
	    } 

	    @Override
	    public void paintFigure(Graphics graphics) {
	        // TODO Auto-generated method stub
	        super.paintFigure(graphics);        
	    }
	    
	    public void setHappens(Happens newHappens){
	    	System.out.println("I'm in happens");
	    	happensList.add(newHappens);
	    }
	    
	    public void setHoldsAt(HoldsAt newHoldsAt){
	    	System.out.println("I'm in holdsat");
	    	holdsAtList.add(newHoldsAt);

	    }
	    
	    public void setHoldsAtBetween(HoldsAtBetween newHoldsAtBetween){
	    	System.out.println("I'm in holdsatbetween");
	    	holdsAtBetweenList.add(newHoldsAtBetween);

	    }
 
	    public int getTimeInstants(){
	    	return timeInstants;
	    }
	}
