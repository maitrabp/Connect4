/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Maitra
 */
public class Connect4Controller implements Initializable {

    @FXML
    private Button Column1;
    @FXML
    private Button Column2;
    @FXML
    private Button Column3;
    @FXML
    private Button Column4;
    @FXML
    private Button Column5;
    @FXML
    private Button Column6;
    @FXML
    private Button Column7;
    @FXML
    private Label redmove;
    @FXML
    private Label blackmove;
    @FXML
    private Label playerwin;
    @FXML
    private GridPane connectGrid;
    private ImageView blackStore;
    private Image redImage;
    private ImageView redStore;
    private ImageView winView;
    private Image winImage;
    private Image blackImage;
    private boolean playerOne;
    private boolean connected;
    
    
    int[][] connectArray = new int[7][6];

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initializes disks
        redImage = new Image("images/redCircle_1.png");
        blackImage = new Image("images/greenCircle_1.png");
        
        redStore = new ImageView(redImage);
        blackStore = new ImageView(blackImage);
        //Sets Player one active ( Black disk )
        playerOne = true;
        //Nothing is connected as of now
        connected = false;
        //All labels are emptied
        playerwin.setText(" ");
        blackmove.setText(" ");
        redmove.setText(" ");
        //Grid or array that controls the grid is empty 
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                connectArray[i][j] = 0;
            }
        }
    }    

    private boolean gameEnds()
    {
        boolean result = true;
        //Checks for game end:false -> if non of the disks are connected, or the board is not full
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (connectArray[i][j] == 0 && !connected){
                    result = false;
                }
            }
        }
        if (!connected && result)
        {
            playerwin.setText("GAME OVER, NO WINNER!");
//            gameOverImage = new Image("images/gameOver.png");
//            gameOverColor = new ImageView(gameOverImage);
//            theGrid.add(gameOverColor, 3, 2);
        }
        return result;
    }
    //Invokes based on the button pressed, a column is passed into this function
    private void buttonPress(int col)
    {
        //My col starts at 1 but in array it's 0 so subtracting once
        col--;
        //As long as game has not ended, we can insert disks
        if(!gameEnds())
        {
           int row = connectArray[col].length - 1; 
           //Check as long as we find an empty spot in that column
           while(connectArray[col][row] != 0)
           {
               row--;
               if(row == -1)
               {
                   break;
               }
           }
           if((row != -1))
           {
                if(playerOne)
                {
                    redmove.setText(" ");
                    blackmove.setText("Black Move");
                    redImage = new Image("images/redCircle_1.png");
                    redStore = new ImageView(redImage);
                    connectGrid.add(redStore, col, row);
                    connectArray[col][row] = 1;
                    playerOne = false;
                }
                else
                {
                    blackmove.setText(" ");
                    redmove.setText("Red Move");
                    blackImage = new Image("images/greenCircle_1.png");
                    blackStore = new ImageView(blackImage);
                    connectGrid.add(blackStore, col, row);
                    connectArray[col][row] = 2;
                    playerOne = true;
                }
           }
        }  
    }
    
    @FXML
    private void button1(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(1);
        if (playerOne){
            //Check if they are connected, then print who wins
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }

    @FXML
    private void button2(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(2);
        if (playerOne){
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }

    @FXML
    private void button3(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(3);
        if (playerOne){
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
              
        }
        }
    }

    @FXML
    private void button4(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(4);
        if (playerOne){
            //Check if they are connected, then print who wins
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }

    @FXML
    private void button5(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(5);
        if (playerOne){
            //Check if they are connected, then print who wins
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
             playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }

    @FXML
    private void button6(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(6);
        if (playerOne){
            //Check if they are connected, then print who wins
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }

    @FXML
    private void button7(ActionEvent event) {
        String playerWin;
        if (!gameEnds()){
        buttonPress(7);
        if (playerOne){
            //Check if they are connected, then print who wins
            connected = areFourConnected(2);
            playerWin = "Black";
        }
        else
        {
            connected = areFourConnected(1);
            playerWin = "Red";
        }
        if (connected)
        {
              playerwin.setText(playerWin + " Wins!");
              winImage = new Image("images/winner.jpg");
              winView = new ImageView(winImage);
              connectGrid.add(winView, 3, 2);
        }
        }
    }
   public boolean areFourConnected(int player){

    // verticalCheck 
    for (int j = 0; j<3 ; j++ ){
        for (int i = 0; i<7; i++){
            if (connectArray[i][j] == player && connectArray[i][j+1] == player && connectArray[i][j+2] == player && connectArray[i][j+3] == player){
                return true;
            }           
        }
    }
    // horizontalCheck
    for (int i = 0; i<4 ; i++ ){
        for (int j = 0; j<6; j++){
            if (connectArray[i][j] == player && connectArray[i+1][j] == player && connectArray[i+2][j] == player && connectArray[i+3][j] == player){
                return true;
            }           
        }
    }
    // ascendingDiagonalCheck 
    for (int i=3; i<7; i++){
        for (int j=0; j<3; j++){
            if (connectArray[i][j] == player && connectArray[i-1][j+1] == player && connectArray[i-2][j+2] == player && connectArray[i-3][j+3] == player)
                return true;
        }
    }
    // descendingDiagonalCheck
    for (int i=3; i<7; i++){
        for (int j=3; j<6; j++){
            if (connectArray[i][j] == player && connectArray[i-1][j-1] == player && connectArray[i-2][j-2] == player && connectArray[i-3][j-3] == player)
                return true;
        }
    }
    return false;
   }
}
