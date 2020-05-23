//Raja Hammad Mehmood
// This program runs the Minesweeper game.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Minesweeper {
    public static void main ( String[] args ) {
        boolean[][] cov_uncov=new boolean [12][22]; // cov_uncov saves either if the boxes are open or closed.
        for (int row=1; row<11; row++) {
            for(int column=1; column<21; column++) {
                cov_uncov[row][column]= false; // false means that boxes are uncovered.
            }
        }

        boolean[][] mines=new boolean [12][22]; // saves the position of mines
        for (int row=1; row<11; row++) {
            for(int column=1; column<21; column++) {
                mines[row][column]=false;
            }
        }

        int count=0;
        while (count<40) { // places the mines 40 times randomly

            int row=(int)(Math.random()*10)+1; // random value for row
            int column=(int)(Math.random()*20)+1;// random value for column
            if (mines[row][column]==false) {
                mines[row][column]=true;
                count++;
            }

        }
        int counter=0;// number of adjacent mines
        int[][] adjmines=new int[12][22]; // adjmines is keeping a track of adjacent mines

        for (int row=1; row<11; row++) { // row is the row in the 2D array
            for(int column=1; column<21; column++) { // column is the column in 2D array
// checking the 8 positions around a certain box
                if (mines[row][column]==false) {

                    if (mines[row+1][column]==true) {
                        counter++;
                    }

                    if (mines[row-1][column]==true) {
                        counter++;
                    }
                    if (mines[row][column+1]==true) {
                        counter++;
                    }
                    if (mines[row][column-1]==true) {
                        counter++;
                    }
                    if (mines[row+1][column+1]==true) {
                        counter++;
                    }
                    if (mines[row-1][column+1]==true) {
                        counter++;
                    }
                    if (mines[row-1][column-1]==true) {
                        counter++;
                    }
                    if (mines[row+1][column-1]==true) {
                        counter++;
                    }

                }
                adjmines[row][column]=counter;
                counter=0;

            }
        }




        Paint.buildWindow("minesweeper", 0, 0, 1000,500, Color.GRAY);// prints the starting screen
        for (int row=0; row<1000; row+=50) { //row is the row in the 2D array
            for(int column=0; column<500; column+=50) { //column is the column in 2D array
                Paint.setColor(Color.BLACK);
                Paint.drawRect(row,column,50,50);//squares with black outline
            }
        }
        // draws the current position as yellow
        Paint.setColor(Color.YELLOW);
        Paint.fillRect(0,0,50,50);

        int cpx=1;// current row position in the array
        int cpy=1; // current column position
        int cpdx=0; // current x axis on the display
        int cpdy=0; // current y axis on the display
        // play the game
        while(true) {
            int arrow = Paint.getArrow();// the key user presses

            if ( arrow == Paint.LEFT ) { // if the key is left it does the following
                if (cpy!=1) { // making sure it doesn't go beyond the grid
                    if (cov_uncov[cpx][cpy]==false) { // if it's covered do the folowing
                        Paint.setColor(Color.GRAY);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                    } else { // if it's uncovered
                        Paint.setColor(Color.CYAN);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.RED);
                        Paint.drawString(String.valueOf(adjmines[cpx][cpy]), (cpdx+25), (cpdy+25)); // printing the number of adjacent mines
                    }
                    //changing the position of coordinates and the axis
                    cpy=cpy-1;
                    cpdx=cpdx-50;
                    // drawing the new new current position out
                    Paint.setColor(Color.YELLOW);
                    Paint.fillRect((cpdx),cpdy,50,50);
                }

            } else if (arrow==Paint.RIGHT) { // if the key pressed by user is right do the folllowing
                if (cpy!=20) {
                    if (cov_uncov[cpx][cpy]==false) {
                        Paint.setColor(Color.GRAY);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                    } else {
                        Paint.setColor(Color.CYAN);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.RED);
                        Paint.drawString(String.valueOf(adjmines[cpx][cpy]), (cpdx+25), (cpdy+25));
                    }
                    cpy=cpy+1;
                    cpdx=cpdx+50;

                    Paint.setColor(Color.YELLOW);
                    Paint.fillRect((cpdx),cpdy,50,50);
                }

            }

            else if (arrow==Paint.UP) { // if the key pressed by user is up do the folllowing
                if (cpx!=1) {
                    if (cov_uncov[cpx][cpy]==false) {
                        Paint.setColor(Color.GRAY);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                    } else {
                        Paint.setColor(Color.CYAN);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.RED);
                        Paint.drawString(String.valueOf(adjmines[cpx][cpy]), (cpdx+25), (cpdy+25));
                    }
                    cpx=cpx-1;
                    cpdy=cpdy-50;

                    Paint.setColor(Color.YELLOW);
                    Paint.fillRect((cpdx),(cpdy),50,50);
                }

            } else if (arrow==Paint.DOWN) { // if the key pressed by user is down do the folllowing
                if (cpx!=10) {
                    if (cov_uncov[cpx][cpy]==false) {
                        Paint.setColor(Color.GRAY);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                    } else {
                        Paint.setColor(Color.CYAN);
                        Paint.fillRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.BLACK);
                        Paint.drawRect((cpdx),cpdy,50,50);
                        Paint.setColor(Color.RED);
                        Paint.drawString(String.valueOf(adjmines[cpx][cpy]), (cpdx+25), (cpdy+25));
                    }
                    cpx=cpx+1;
                    cpdy=cpdy+50;

                    Paint.setColor(Color.YELLOW);
                    Paint.fillRect((cpdx),(cpdy),50,50);
                }

            } else { // if the user presses anything other than the arrow keys. This would open the box up
                if(mines[cpx][cpy]==true) { // this means user has opened the mine up
                    // now we would show the mines, number of neighbouring mines and YOU LOOSE!
                    for (int row=0; row<1000; row+=50) {
                        for(int column=0; column<500; column+=50) {
                            Paint.setColor(Color.CYAN);
                            Paint.fillRect(row,column,50,50);
                            Paint.setColor(Color.BLACK);
                            Paint.drawRect(row,column,50,50);
                        }
                    }


                    for (int row=1; row<11; row++) {
                        for(int column=1; column<21; column++) {
                            if (mines[row][column]==true) {
                                Paint.setColor(Color.BLACK);
                                Paint.fillOval(((column-1)*50)+10,((row-1)*50)+10,25,25);  //draws the mines out
                            } else {
                                Paint.setColor(Color.RED);
                                Paint.drawString(String.valueOf(adjmines[row][column]), (((column-1)*50)+25), (((row-1)*50)+25));
                            }
                        }
                    }
                    Paint.setFont("SansSerif", Font.BOLD, 48);
                    Paint.drawString("YOU LOOSE!", 350,250);

                    break;
                }

                else { // if the user opened a non-mine box
                    Paint.setColor(Color.CYAN);
                    Paint.fillRect((cpdx),cpdy,50,50);
                    Paint.setColor(Color.BLACK);
                    Paint.drawRect((cpdx),cpdy,50,50);
                    Paint.setColor(Color.RED);
                    Paint.drawString(String.valueOf(adjmines[cpx][cpy]), (cpdx+25), (cpdy+25));

                    cov_uncov[cpx][cpy]=true; // that position is uncovered now
                }
                int counts=0; // a checking variable for number of non mines
                // checking if the user wins
                for (int row=1; row<11; row++) {
                    for(int column=1; column<21; column++) {
                        if (mines[row][column]==false) {
                            if (cov_uncov[row][column]==true) {
                                counts++;
                            }
                        }

                    }
                }
                if (counts==160) { // This means that the user won and now we need to show everything with a message YOU WIN!

                    for (int row=0; row<1000; row+=50) {
                        for(int column=0; column<500; column+=50) {
                            Paint.setColor(Color.CYAN);
                            Paint.fillRect(row,column,50,50);
                            Paint.setColor(Color.BLACK);
                            Paint.drawRect(row,column,50,50);
                        }
                    }


                    for (int row=1; row<11; row++) {
                        for(int column=1; column<21; column++) {
                            if (mines[row][column]==true) {
                                Paint.setColor(Color.BLACK);
                                Paint.fillOval(((column-1)*50)+10,((row-1)*50)+10,25,25);
                            } else {
                                Paint.setColor(Color.RED);
                                Paint.drawString(String.valueOf(adjmines[row][column]), (((column-1)*50)+25), (((row-1)*50)+25));
                            }
                        }
                    }

                    Paint.setFont("SansSerif", Font.BOLD, 48);
                    Paint.drawString("YOU WIN!", 350,250);
                    break;
                }


            }



        }








    }

}
































