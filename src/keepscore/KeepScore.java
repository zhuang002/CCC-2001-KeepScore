/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keepscore;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class KeepScore {

    /**
     * @param args the command line arguments
     */
    static String pattern="%-25s%15s\r\n";
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        char[][] suits=new char[4][13];
        int[] suitsLength=new int[4];
        String input=sc.nextLine();
        int currentSuit=0;
        int index=0;
        for (int i=0;i<input.length();i++) {
            char c=input.charAt(i);
            switch (c) {
                case 'C':
                    suitsLength[currentSuit]=index;
                    currentSuit=0;
                    index=0;
                    break;
                case 'D':
                    suitsLength[currentSuit]=index;
                    currentSuit=1;
                    index=0;
                    break;
                case 'H':
                    suitsLength[currentSuit]=index;
                    currentSuit=2;
                    index=0;
                    break;
                case 'S':
                    suitsLength[currentSuit]=index;
                    currentSuit=3;
                    index=0;
                    break;
                default:
                    suits[currentSuit][index]=c;
                    index++;
                    break;
            }
        }
        suitsLength[3]=index;
        System.out.printf(pattern,"Cards Dealt","Points");
        
        int totalScore=0;
        for (int i=0;i<4;i++) {
            Integer score=0;
            String cardDealt="";
            switch (i) {
                case 0:
                    cardDealt="Clubs";
                    break;
                case 1:
                    cardDealt="Diamonds";
                    break;
                case 2:
                    cardDealt="Hearts";
                    break;
                case 3:
                    cardDealt="Spades";
                    break;
                default:
                    break;
            }
            switch (suitsLength[i]) {
                case 0:
                    score+=3;
                    break;
                case 1:
                    score+=2;
                    break;
                case 2:
                    score+=1;
                    break;
                default:
                    break;
            }
            
            for (int j=0;j<suitsLength[i];j++) {
                cardDealt+=" "+suits[i][j];
                switch (suits[i][j]) {
                    case 'A':
                        score+=4;
                        break;
                    case 'K':
                        score+=3;
                        break;
                    case 'Q':
                        score+=2;
                        break;
                    case 'J':
                        score+=1;
                        break;
                    default:
                        break;
                }
                
            }
            System.out.printf(pattern, cardDealt,score.toString());
            totalScore+=score;
        }
        System.out.printf(pattern, "","Total "+totalScore);
    }
    
}
