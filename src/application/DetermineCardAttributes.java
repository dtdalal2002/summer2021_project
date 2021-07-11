package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class DetermineCardAttributes {
private Cards card;
private String color;
private String pattern;
private String shape;
private Image stripes;
private ImagePattern pat;
	public DetermineCardAttributes(String color, String pattern, String shape) {
		this.color = color;
		this.shape = shape;
		this.pattern = pattern;
	}
	public Color getColor(String color) {
		if(color.equalsIgnoreCase("red")) {
			return Color.RED;
		}else if(color.equalsIgnoreCase("green")) {
			return Color.GREEN;
		}else if(color.equalsIgnoreCase("purple")) {
			return Color.PURPLE;
		}else {
			return Color.BLACK;
		}
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Shape getShape(String shape) {
		if(shape.equalsIgnoreCase("rectangle")) {
			return new Rectangle(65, 75);
		}else if(shape.equalsIgnoreCase("circle")){
			return new Circle(60);
		}else if(shape.equalsIgnoreCase("polygon")) {
			Rectangle rect = new Rectangle(65, 65);
			rect.setRotate(45);
			return rect;
		}else {
			return new Circle(40);
		}
	}
	
	public Paint getFill(String pattern) {
		if(pattern.equalsIgnoreCase("filled")) {
			return getColor(color);
		}else if(pattern.equalsIgnoreCase("empty")) {
			return Color.WHITE;
		}else {
			return getColor(color);
		}
	}
	
	
}
