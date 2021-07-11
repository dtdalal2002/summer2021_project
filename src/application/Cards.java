package application;

import java.io.*;
import java.util.*;
public class Cards {
	private int number;
	private String color;
	private String pattern;
	private String shape;
	
	public Cards(int number, String color, String pattern, String shape) {
		this.number = number;
		this.color = color;
		this.pattern = pattern;
		this.shape = shape;
	}
	public int getNumber() {
		return number;
	}
	public String getShape() {
		return shape;
	}
	public String getColor() {
		return color;
	}
	public String getPattern() {
		return pattern;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String toString() {
		return number + "," + color + "," + pattern + "," + shape;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, number, pattern, shape);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Cards)) {
			return false;
		}
		Cards other = (Cards) obj;
		return Objects.equals(color, other.color) && number == other.number && Objects.equals(pattern, other.pattern)
				&& Objects.equals(shape, other.shape);
	}
	
}
