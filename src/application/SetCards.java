package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

import javax.management.Notification;

import java.util.Queue;
import java.util.Stack;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;




public class SetCards extends BorderPane
{
    //instance variables - check assignment's description
    //----

    private Button restartGame;
    private Button addCards, instructions;
    private HBox[][] cards;
    private int row, col;
    private int[] number;
    private String[] color, shape, pattern;
    private int randomColor, randomShape, randomPattern, randomNum;
    private int num;
    private String cardColor, cardShape, cardPattern;
    private Object[] cardInfo;
    private Cards info,solveSet1, solveSet2, solveSet3;
    private Queue<Cards> queue;
    private DetermineCardAttributes attr;
    private int width;
    private Shape shape2;
    private Circle inner, inner2, inner3;
    private StackPane stack;
    private Cards[][] holderCards;
    private final int NUM_COL = 3, NUM_ROW = 3;
    private int clickCounter = 0;
    private int cardNum;
    private String p,colr,sh;
    private int[] colHolder, rowHolder;
    private ArrayList<Cards> listOfCards, cardHolders;
    private FindTheSet findSet;
    private Boolean isTrue;
    private HashSet<Cards> hashSet;
    private Text text1;
    
    private GridPane canvas;	//this is where circles are drawn

    //constructor
    public SetCards()
    {
        //Initialize instance varibles and set up the layout
    	
    	addCards = new Button("Add Cards");
    	
    	color = new String[]{"red", "green", "purple"};
    	
    	shape = new String[]{"rectangle", "circle", "polygon"};
    	
    	pattern = new String[] {"stripe", "filled", "empty"};
    	
    	number = new int[]{1, 2, 3};
    	
    	cardInfo = new Object[4];
    	
    	restartGame  = new Button("Restart Game");
    	
    	instructions = new Button("Instructions");
    	
    	width = 7;
    	
    	queue = new ConcurrentLinkedQueue<>();
    	
    	colHolder = new int[3];
    	
    	rowHolder = new int[3];
    	
    	listOfCards = new ArrayList<Cards>();
    	
    	findSet = new FindTheSet(listOfCards);
    	
    	text1 = new Text();
    	
    	
    	hashSet = new HashSet<Cards>();
    	
    	cardHolders = new ArrayList<Cards>();
    	//random numbers

    	while(hashSet.size() < 81) {
			randomColor = ThreadLocalRandom.current().nextInt(0, 2+1);
			
			randomNum = ThreadLocalRandom.current().nextInt(0, 2+1);
			
			randomPattern = ThreadLocalRandom.current().nextInt(0, 2+1);
			
			randomShape = ThreadLocalRandom.current().nextInt(0, 2+1);
			
			cardColor = color[randomColor];
			
			cardShape = shape[randomShape];
			
			num = number[randomNum];
			
			cardPattern = pattern[randomPattern];
			
			cardInfo[0] = num;
			
			cardInfo[1] = cardColor;
			
			cardInfo[2] = cardPattern;
			
			cardInfo[3] = cardShape;
			info = new Cards(num, cardColor, cardPattern, cardShape);
			
			hashSet.add(info);
			
			
		}

    	cardHolders.addAll(hashSet);
    	
    	Collections.shuffle(cardHolders);
    	queue.addAll(cardHolders); 
    	
    	cardNum = 0;
    	
    	p = "";
    	
    	colr = "";
    	
    	sh = "";
    	
    	
    	//intializes the hboxes for gridpane
    	cards = new HBox[4][4];
    	holderCards = new Cards[4][NUM_ROW];
        //instantiate canvas and set its width and height
        canvas = new GridPane();
        
        canvas.setPrefWidth(100);
        
        canvas.setPrefHeight(200);
        
        canvas.setGridLinesVisible(true);
        
        canvas.setHgap(10);
        
        canvas.setVgap(10);
        
        canvas.setPadding(new Insets(10, 10, 10, 10));
        
        
        

        
        
        //nested loop to create 3x3 gridpane for the cards
        
        for(col = 0; col < NUM_COL; col++) {
        	for(row = 0; row < NUM_ROW; row++) {
        		
        		cardNum = queue.peek().getNumber();
        		p = queue.peek().getPattern();
        		colr = queue.peek().getColor();
        		sh = queue.peek().getShape();
        		
        		attr = new DetermineCardAttributes(colr, p, sh);
        		
        		
        		cards[col][row] = new HBox();
        		cards[col][row].setSpacing(10);
        		cards[col][row].setPadding(new Insets(10, 10, 10, 10));
        		
            	
        		
            	for(int i = 0; i < cardNum; i++) {
            		inner = new Circle(30);
                	inner.setFill(Color.WHITE);
                	inner2 = new Circle(20);
                	inner2.setFill(attr.getColor(colr));
                	inner3 = new Circle(10);
                	inner3.setFill(Color.WHITE);
                	if(sh.equalsIgnoreCase("circle")) {
                		inner.setRadius(50);
                		inner2.setRadius(40);
                		inner3.setRadius(30);
                	}
            		shape2 = attr.getShape(sh);
            		shape2.setStrokeWidth(width);
            		shape2.setLayoutX(3);
            		shape2.setLayoutY(3);
            		shape2.setStroke(attr.getColor(colr));
            		shape2.setFill(attr.getFill(p));
            		stack = new StackPane();
            		if(!p.equalsIgnoreCase("stripe")) {
            			cards[col][row].getChildren().addAll(shape2);
            			holderCards[col][row] = queue.peek();
            		}else {
            			stack.getChildren().addAll(shape2,inner,inner2,inner3);
            			cards[col][row].getChildren().addAll(stack);
            			holderCards[col][row] = queue.peek();
            		}
            		cards[col][row].setAlignment(Pos.CENTER);
            	}
            	cards[col][row].setOnMouseDragged(new MouseHandler(col, row));
            	
        		canvas.add(cards[col][row], col, row);
        		
        		queue.poll();
        	}
        	
        }
        //leftPane is a VBox, it should contain labels and the 3 comboBox
        VBox leftPane = new VBox();
        
        leftPane.setSpacing(20);
        
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        
        leftPane.setStyle("-fx-border-color: black");

        leftPane.getChildren().addAll(addCards, restartGame, instructions, text1);
        //add leftPane and canvas to CirclePane

        this.setLeft(leftPane);
        
        this.setCenter(canvas);
        
        
        //canvas.setOnMouseDragged(new MouseHandler());
        
        addCards.setOnAction(new AddCardsToDeck());
        
        instructions.setOnAction(new Instructions());
        
        restartGame.setOnAction(new restartGame()); 
        
    }

    private class MouseHandler implements EventHandler<MouseEvent> {

        private final int row;
        private final int col;

        MouseHandler(int column, int row) {
            this.row = row ;
            this.col = column ;
            //System.out.println(col + ", " + row);
        }

        public void handle(MouseEvent event) {
        	
            clickCounter++;
            
            text1.setText("You Selected: " + clickCounter + " cards");
            
            text1.setStyle("-fx-font: 16 arial;");
            
            if(clickCounter == 1) {
            	colHolder[0] = col;
            	rowHolder[0] = row;
            }
            if(clickCounter == 2) {
            	colHolder[1] = col;
            	rowHolder[1] = row;
            }
            if(clickCounter == 3) {
            	colHolder[2] = col;
            	rowHolder[2] = row;
            }
            
            
            if(clickCounter == 3) {
            	listOfCards.add(holderCards[colHolder[0]][rowHolder[0]]);
            	
            	listOfCards.add(holderCards[colHolder[1]][rowHolder[1]]);
            	
            	listOfCards.add(holderCards[colHolder[2]][rowHolder[2]]);
          
                
                solveSet1 = findSet.getFirstSet(listOfCards);
                
                solveSet2 = findSet.getSecondSet(listOfCards);
                
                solveSet3 = findSet.getThirdSet(listOfCards);
                
                isTrue = findSet.determineAttribute(solveSet1, solveSet2, solveSet3);
                if(isTrue == true) {
                	int a = 0;
                    while(a < 3) {
                    	canvas.getChildren().remove(cards[colHolder[a]][rowHolder[a]]);
                    	
                    	cardNum = queue.peek().getNumber();
                		p = queue.peek().getPattern();
                		colr = queue.peek().getColor();
                		sh = queue.peek().getShape();
                		
                		attr = new DetermineCardAttributes(colr, p, sh);
                		
                		cards[colHolder[a]][rowHolder[a]] = new HBox();
                		cards[colHolder[a]][rowHolder[a]].setSpacing(10);
                		cards[colHolder[a]][rowHolder[a]].setPadding(new Insets(10, 10, 10, 10));
                		
                    	
                		
                		for(int i = 0; i < cardNum; i++) {
                    		inner = new Circle(30);
                        	inner.setFill(Color.WHITE);
                        	inner2 = new Circle(20);
                        	inner2.setFill(attr.getColor(colr));
                        	inner3 = new Circle(10);
                        	inner3.setFill(Color.WHITE);
                        	if(sh.equalsIgnoreCase("circle")) {
                        		inner.setRadius(50);
                        		inner2.setRadius(40);
                        		inner3.setRadius(30);
                        	}
                    		shape2 = attr.getShape(sh);
                    		shape2.setStrokeWidth(width);
                    		shape2.setLayoutX(3);
                    		shape2.setLayoutY(3);
                    		shape2.setStroke(attr.getColor(colr));
                    		shape2.setFill(attr.getFill(p));
                    		stack = new StackPane();
                    		if(!p.equalsIgnoreCase("stripe")) {
                    			cards[colHolder[a]][rowHolder[a]].getChildren().addAll(shape2);
                    		}else {
                    			stack.getChildren().addAll(shape2,inner,inner2,inner3);
                    			cards[colHolder[a]][rowHolder[a]].getChildren().addAll(stack);
                    		}
                    		cards[colHolder[a]][rowHolder[a]].setAlignment(Pos.CENTER);
                    	}
                    	cards[colHolder[a]][rowHolder[a]].setOnMouseDragged(new MouseHandler(colHolder[a], rowHolder[a]));
                    	
                		canvas.add(cards[colHolder[a]][rowHolder[a]], colHolder[a], rowHolder[a]);
                		
                		if(colHolder[a] == 3) {
                			canvas.getChildren().remove(cards[colHolder[a]][rowHolder[a]]);
                    	}else {
                    		holderCards[colHolder[a]][rowHolder[a]] = queue.peek();
                    	}
                		
                		queue.poll();
                		
                    	a++;
                    	//System.out.println(queue.size());
                    	clickCounter = 0;
                    	listOfCards.clear();
                    	
                    	
                    	if(queue.size() == 0) {
                    		Alert alert2 = new Alert(AlertType.INFORMATION);
                    		alert2.setTitle("Message");
                        	alert2.setContentText("Restart Game");
                        	alert2.show();
           
                    	}
                    	
                    }
                   
                    
                }else {
                	System.out.println("false");
                	clickCounter = 0;
                	listOfCards.clear();
                	Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Message");
                	alert.setContentText("Try again or if there are no more sets click Add Cards");
                	alert.show();
                	
                }

            }
	
        }
        
    }


    private class AddCardsToDeck implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
        	
        	int j = 0;
        	
        	while(j < 3) {
        		if(queue.size() == 0) {
        			Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Message");
                	alert.setContentText("Restart Game");
                	alert.show();
        			break;
        		}
        		canvas.getChildren().remove(cards[3][j]);
        		cardNum = queue.peek().getNumber();
        		p = queue.peek().getPattern();
        		colr = queue.peek().getColor();
        		sh = queue.peek().getShape();
        		
        		attr = new DetermineCardAttributes(colr, p, sh);
        		
        		
        		cards[3][j] = new HBox();
        		cards[3][j].setSpacing(10);
        		cards[3][j].setPadding(new Insets(10, 10, 10, 10));
        		
            	
        		
            	for(int i = 0; i < cardNum; i++) {
            		inner = new Circle(30);
                	inner.setFill(Color.WHITE);
                	inner2 = new Circle(20);
                	inner2.setFill(attr.getColor(colr));
                	inner3 = new Circle(10);
                	inner3.setFill(Color.WHITE);
                	if(sh.equalsIgnoreCase("circle")) {
                		inner.setRadius(50);
                		inner2.setRadius(40);
                		inner3.setRadius(30);
                	}
            		shape2 = attr.getShape(sh);
            		shape2.setStrokeWidth(width);
            		shape2.setLayoutX(3);
            		shape2.setLayoutY(3);
            		shape2.setStroke(attr.getColor(colr));
            		shape2.setFill(attr.getFill(p));
            		stack = new StackPane();
            		if(!p.equalsIgnoreCase("stripe")) {
            			cards[3][j].getChildren().addAll(shape2);
            			holderCards[3][j] = queue.peek();
            		}else {
            			stack.getChildren().addAll(shape2,inner,inner2,inner3);
            			cards[3][j].getChildren().addAll(stack);
            			holderCards[3][j] = queue.peek();
            		}
            		cards[3][j].setAlignment(Pos.CENTER);
            	}
            	cards[3][j].setOnMouseDragged(new MouseHandler(3, j));
            	
        		canvas.add(cards[3][j], 3, j);
        		
        		
        		queue.poll();

        		System.out.println(queue.size());
        		
        		j++;
        	}
        	
        	
		}
    }
    private class Instructions implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Instructions");
    		Text text = new Text();
    		text.setText("Welcome to the game of Set. This is a brain game to test you visual perception."
    				+ " Each card has 4 attributes: color, shape, pattern, and number."
    				+ "\n" + " To make a set either at least one of the attributes of the cards can be the same"
    				+ " or none of the attributes are the same."
    				+ "\n" + " No two cards can have the same attributes."
    				+ "\n" + " For example: you have 3 cards all three are purple, one has a stripe fill, one has a solid fill, and one has a empty fill, and all 3 are"
    				+ "\n" + " rectangles, however 2 of the cards have one shape and one of the cards has 3 shapes, this is not a set."
    				+ "\n" + " An example for a set is 3 cards and each one card has one shape, is the color purple, has a stripe fill, and the shape is a circle"
    				+ "\n" + " the next card has 2 shapes, the shape is a diamond, the color is red, and the fill is empty"
    				+ "\n" + " and the last card has 3 shapes, the shapes are rectangles, the color is green, and the fill is solid."
    				+ "\n" + " A set can be as complex and as simple as you'd like as long as all three cards have at least one of the same attributes or none of the same attributes"
    						+ "\n" + " To restart the game press restart game. To add more cards if you can't find a Set press Add Cards");
    		ScrollPane scroll = new ScrollPane();
    		text.setStyle("-fx-font: 20 arial;");
    		
    		scroll.setContent(text);
    		
    		alert2.setResizable(true);
    		
    		alert2.getDialogPane().setContent(scroll);
    		alert2.show();
    		
    	}
    }
    public class restartGame implements EventHandler<ActionEvent>{
    	public void handle(ActionEvent event)
        {	
    		Node  source = (Node)  event.getSource(); 
    	    Stage stage  = (Stage) source.getScene().getWindow();
    	    stage.close();
    		canvas.getChildren().clear();
    		queue.clear();
    		hashSet.clear();
    		SetCards gui2 = new SetCards();
    		StackPane rootPane = new StackPane();
            rootPane.getChildren().add(gui2);
            Scene scene = new Scene(rootPane, 1500, 1500);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Set: The Game");
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show();
            
 		}
    }

}