package application;

import java.util.ArrayList;

public class FindTheSet {
	private ArrayList<Cards> list;
	public FindTheSet() {
		
	}
	public FindTheSet(ArrayList<Cards> listOfCards) {
		this.list = listOfCards;
	}
	public Cards getFirstSet(ArrayList<Cards> listOfCards) {
		return listOfCards.get(0);
	}
	public Cards getSecondSet(ArrayList<Cards> listOfCards){
		return listOfCards.get(1);
	}
	public Cards getThirdSet(ArrayList<Cards> listOfCards){
		return listOfCards.get(2);
	}
	
	public Boolean determineAttribute(Cards card1, Cards card2, Cards card3) {
		card1 = getFirstSet(list);
		card2 = getSecondSet(list);
		card3 = getThirdSet(list);
		
		int cardNum1 = card1.getNumber();
		String cardFill1 = card1.getPattern();
		String cardShape1 = card1.getShape();
		String cardColor1 = card1.getColor();
		
		int cardNum2 = card2.getNumber();
		String cardFill2 = card2.getPattern();
		String cardShape2 = card2.getShape();
		String cardColor2 = card2.getColor();
		
		int cardNum3 = card3.getNumber();
		String cardFill3 = card3.getPattern();
		String cardShape3 = card3.getShape();
		String cardColor3 = card3.getColor();
		
		Boolean numForSets = false;
		
		Boolean shapeForSets = false;
		
		Boolean colorForSets = false;
		
		Boolean fillForSets = false;
		
		
		Boolean numForSetsDif = false;
		
		Boolean shapeForSetsDif = false;
		
		Boolean colorForSetsDif = false;
		
		Boolean fillForSetsDif = false;
		
		Boolean setExists = false;
		
		
		if(cardNum1 == cardNum2 && cardNum3 == cardNum1 && cardNum2 == cardNum3) {
			numForSets = true;
		}else if(cardNum1 != cardNum2 && cardNum1 != cardNum3 && cardNum2 != cardNum3) {
			numForSetsDif = true;
		}
		
		if(cardShape1.equalsIgnoreCase(cardShape2) && cardShape1.equalsIgnoreCase(cardShape3) && cardShape2.equalsIgnoreCase(cardShape3)) {
			shapeForSets = true;
		}else if(!cardShape1.equalsIgnoreCase(cardShape2) && !cardShape1.equalsIgnoreCase(cardShape3) && !cardShape2.equalsIgnoreCase(cardShape3)) {
			shapeForSetsDif = true;
		}
		
		if(cardColor1.equalsIgnoreCase(cardColor2) && cardColor1.equalsIgnoreCase(cardColor3) && cardColor2.equalsIgnoreCase(cardColor3)) {
			colorForSets = true;
		}else if(!cardColor1.equalsIgnoreCase(cardColor2) && !cardColor1.equalsIgnoreCase(cardColor3) && !cardColor2.equalsIgnoreCase(cardColor3)) {
			colorForSetsDif = true;
		}
		if(cardFill1.equalsIgnoreCase(cardFill2) && cardFill1.equalsIgnoreCase(cardFill3) && cardFill2.equalsIgnoreCase(cardFill3)) {
			fillForSets = true;
		}else if(!cardFill1.equalsIgnoreCase(cardFill2) && !cardFill1.equalsIgnoreCase(cardFill3) && !cardFill2.equalsIgnoreCase(cardFill3)) {
			fillForSetsDif = true;
		}
		
		//creates the sets
		//same shape, same number, different fill, different color
		if(numForSets == true && shapeForSets == true && fillForSets == true && colorForSetsDif == true) {
			setExists = true;
			return setExists;
			//same number, different shape, different fill, same color
		}else if(numForSets == true && shapeForSetsDif == true && colorForSets == true && fillForSetsDif == true) {
			setExists = true;
			return setExists;
			//same shape, same number, different color, different fills
		}else if(numForSets == true && shapeForSets == true && colorForSetsDif == true && fillForSetsDif == true) {
			setExists = true;
			return setExists;
			//different number, different shapes, different color, different fills
		}else if(numForSetsDif == true && shapeForSetsDif == true && colorForSetsDif == true && fillForSetsDif == true) {
			setExists = true;
			return setExists;
			//different number, different shape, different color, same fill
		}else if(numForSetsDif == true && shapeForSetsDif == true && colorForSetsDif == true && fillForSets == true) {
			setExists = true;
			return setExists;
			//same number, different color, same fill, different shape
		}else if(numForSets == true && shapeForSetsDif == true && colorForSetsDif == true && fillForSets == true) {
			setExists = true;
			return setExists;
			//same number, same shape, same color, different fill
		}else if(numForSets == true && shapeForSets == true && colorForSets == true && fillForSetsDif == true) {
			setExists = true;
			return setExists;
			//same fills, same color, different number, same shape
		}else if(numForSetsDif == true && fillForSets == true && colorForSets == true && shapeForSets == true) {
			setExists = true;
			return setExists;
			//different number, different fill, different shape, same color
		}else if(numForSetsDif == true && fillForSetsDif == true && shapeForSetsDif == true && colorForSets == true) {
			setExists = true;
			return setExists;
			//same number, different fill, different shape, different color
		}else if(numForSets == true && fillForSetsDif == true && shapeForSetsDif == true && colorForSetsDif == true) {
			setExists = true;
			return setExists;
			//different number, different color, different fill, same shape
		}else if(numForSetsDif == true && fillForSetsDif == true && colorForSetsDif == true && shapeForSets == true) {
			setExists = true;
			return setExists;
			//different number, same color, different fill, same shape
		}else if(numForSetsDif == true && fillForSetsDif == true && colorForSets == true && shapeForSets == true) {
			setExists = true;
			return setExists;
			//same color, same fill, different number, different shape
		}else if(numForSetsDif == true && colorForSets == true && fillForSets == true && shapeForSetsDif == true) {
			setExists = true;
			return setExists;
			//same color, same number, same fill, different fill
		}else if(numForSets == true && colorForSets == true && shapeForSetsDif == true && fillForSets == true) {
			setExists = true;
			return setExists;
			//same shape, same fill, different color, different number
		}else if(numForSetsDif == true && colorForSetsDif == true && shapeForSets == true && fillForSets == true) {
			setExists = true;
			return setExists;
			//different number, different shape, same color, different fill
		}else if(numForSetsDif == true && colorForSets == true && shapeForSetsDif == true && fillForSetsDif == true){
			setExists = true;
			return setExists;
		}else {
			setExists = false;
			return setExists;
		}
	}
}
