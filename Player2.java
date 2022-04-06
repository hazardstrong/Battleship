package battleship;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player2 extends BattleShipGame{
	public void Placing() throws IOException {
		//-----------------------------------------------------------------
		System.out.println("Player 2, place your ships on the game field");
		String[][] field= new String[11][11];
		field = fog();
		//------------------------------Placing Aircraft: -----------------------------------------------------------------------
		boolean end= true;
		System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
		Scanner scanner = new Scanner(System.in);
		do {
			String place= scanner.nextLine();
			char[] ch= place.toCharArray();
			if(place.length() == 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1] != ch[4] && ch[0] == ch[3] && ch[2] == 32 && Math.abs(Character.getNumericValue(ch[1])-Character.getNumericValue(ch[4])) ==4){
				for(char k=65; k<= 74; ++k) {
					if(ch[1] < ch[4] && ch[0] == k) {
						for(int r=0; r< 5; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}
					}else if(ch[1] > ch[4] && ch[0] == k) {
						for(int r=0; r< 5; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}						
					}
				}
				end= false;
				}else if(place.length() == 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1]==ch[4] && ch[0] != ch[3] && Math.abs(Character.getNumericValue(ch[0])-Character.getNumericValue(ch[3]))==4) {
					for(char r=49; r<= 57; ++r) {
						if(ch[0]< ch[3] && r == ch[1]) {
							for(int k=0; k <5; ++k) {								
								field[ch[0]-64+k][ch[1]-48]= "O";
							}
						}else if(ch[0] > ch[3] && r== ch[1]) {
							for(int k=0; k < 5; ++k) {
								field[ch[0]-64-k][ch[1]-48]= "O";
							}
						}
					}
					end= false;
			}else if(place.length()==6 && ch[0]>64 && ch[0]<75){
					if(ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==54 && ch[3]>64 && ch[3]<75 && ch[1]>47 && ch[1]<58 && ch[2] == 32) {
						for(int k=0; k < 5; ++k) {
							field[ch[0]- 64][6+k]= "O";
						}end= false;
						break;
					}else if (ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==54 && ch[4] >64 && ch[4]<75 && ch[5]>47 && ch[5]<58 && ch[3] ==32) {
						for(int k=0; k < 5; ++k) {
							field[ch[0]- 64][6+k]= "O";
						}end= false;
						break;
					}else {
						System.out.println("Error! Wrong Coordinates! Try Again:");
					}		
			}
			else if(place.length()==7 && ch[0] < 75 &&ch[0]> 64 && ch[1]== 49 && ch[2]== 48 && ch[3] == 32 && ch[4] != ch[0] && Math.abs(ch[0]-ch[4]) ==4 && ch[5] == 49 && ch[6] == 48) {
				if(ch[0] < ch[4]) {
					for(int r=0; r < 5; ++r) {
						field[ch[0] - 64 +r][10]= "O";
					}
				}else if(ch[0] > ch[4]) {
					for(int r=0; r < 5; ++r) {
						field[ch[0]-64-r][10]= "O";
					}
				}end= false;
			}else {
				System.out.println("Error! Try Again:");
			}
			}while(end);
		for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		//---------------------------------Placing Battleship: -------------------------------------------------------------
		System.out.println("Enter the coordinates of the Battleship (4 cells):");
		boolean end2= true;
		do {
			String bplace= scanner.nextLine();
			int l= bplace.length();
			char[] ch= bplace.toCharArray();
			if(l== 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1] != ch[4] && ch[0] == ch[3] && ch[2] == 32 && Math.abs((ch[1]-ch[4])) ==3) {
				if(ch[0] != 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O" && field[ch[0]-64-1][ch[1]-48+3] != "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[0]-64+1][ch[1]-48+1] != "O" && field[ch[0]-64+1][ch[1]-48+2] != "O" && field[ch[0]-64+1][ch[1]-48+3] != "O") {
						for(int r=0; r< 4; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end2= false;
						break;
					}else if(ch[0] != 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O" && field[ch[0]-64-1][ch[4]-48+3] != "O" && field[ch[0]-64+1][ch[4]-48] != "O" && field[ch[0]-64+1][ch[4]-48+1] != "O" && field[ch[0]-64+1][ch[4]-48+2] != "O" && field[ch[0]-64+1][ch[4]-48+3] != "O") {
						for(int r=0; r< 4; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end2= false;
						break;
					}else if(ch[0]== 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O" && field[ch[0]-64-1][ch[1]-48+3] != "O") {
						for(int r=0; r< 4; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end2= false;
						break;
					}else if(ch[0] == 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O" && field[ch[0]-64-1][ch[4]-48+3] != "O") {
						for(int r=0; r< 4; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end2= false;
						break;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else if(l==5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1]==ch[4] && ch[0] != ch[3] && ch[2] == 32 && Math.abs((ch[0]-ch[3])) ==3){
				if( ch[3] != 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[3]-64+1][ch[1]-48] != "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O" && field[ch[0]-64+3][ch[1]-48-1]!= "O" && field[ch[0]-64+3][ch[1]-48+1]!= "O") {
					for(int c=0; c < 4; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end2= false;
					break;
				}else if(ch[0] != 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O" && field[ch[3]-64+3][ch[1]-48-1]!= "O" && field[ch[3]-64+3][ch[1]-48+1]!= "O") {
					for(int c=0; c < 4; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end2= false;
					break;
				}else if(ch[3] == 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O" && field[ch[0]-64+3][ch[1]-48-1]!= "O" && field[ch[0]-64+3][ch[1]-48+1]!= "O") {
					for(int c=0; c < 4; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end2= false;
					break;
				}else if(ch[0] == 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O" && field[ch[3]-64+3][ch[1]-48-1]!= "O" && field[ch[3]-64+3][ch[1]-48+1]!= "O") {
					for(int c=0; c < 4; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end2= false;
					break;
				}else {
					System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
				}
				}else if(l==6 && ch[0]>64 && ch[0]<75){
					if(ch[0] != 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==55 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][6] != "O" && field[ch[0]-64-1][7]!= "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][7]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64][7+k]= "O";
						}end2= false;
					}else if (ch[0] != 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==55 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][6] != "O" && field[ch[0]-64-1][7]!= "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][7]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64][7+k]= "O";
						}end2= false;
					}else if(ch[0] == 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==55 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][6] != "O" && field[ch[0]-64-1][7]!= "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64][7+k]= "O";
						}end2= false;
					}else if(ch[0] == 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==55 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][6] != "O" && field[ch[0]-64-1][7]!= "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64][7+k]= "O";
						}end2= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
				}else if(l== 7 && 64<ch[0] && ch[0]<75 && ch[4]>64 && ch[4] <75 && ch[1] == 49 && ch[2] == 48 && ch[3] == 32 && Math.abs(ch[0]-ch[4]) == 3) {
					if(ch[4] != 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64+3][9] != "O" && field[ch[0]-64-1][10] != "O" && field[ch[4]-64+1][10] != "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end2= false;
					}else if(ch[0] != 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64+3][9] != "O" && field[ch[4]-64-1][10] != "O" && field[ch[0]-64+1][10] != "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end2= false;
					}else if(ch[4] == 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64+3][9] != "O" && field[ch[0]-64-1][10] != "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end2= false;
					}else if(ch[0] == 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64+3][9] != "O" && field[ch[4]-64-1][10] != "O") {
						for(int k=0; k < 4; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end2= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
				}else {
				System.out.println("Error! Wrong coordinates! Try Again:");
				}
		
		}while(end2);
		for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		//-----------------------------------Placing Submarine: -----------------------------------------------------------------
		System.out.println("Enter the coordinates of the Submarine (3 cells):");
		boolean end3= true;
		do {
			String bplace= scanner.nextLine();
			int l= bplace.length();
			char[] ch= bplace.toCharArray();
			if(l== 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1] != ch[4] && ch[0] == ch[3] && ch[2] == 32 && Math.abs((ch[1]-ch[4])) ==2) {
				if(ch[0] != 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[0]-64+1][ch[1]-48+1] != "O" && field[ch[0]-64+1][ch[1]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end3= false;
						break;
					}else if(ch[0] != 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O" && field[ch[0]-64+1][ch[4]-48] != "O" && field[ch[0]-64+1][ch[4]-48+1] != "O" && field[ch[0]-64+1][ch[4]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end3= false;
						break;
					}else if(ch[0]== 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end3= false;
						break;
					}else if(ch[0] == 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end3= false;
						break;
					}else {
						System.out.println("Error! Too close to other ships! Try Again:");
					}
			}else if(l==5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1]==ch[4] && ch[0] != ch[3] && ch[2] == 32 && Math.abs((ch[0]-ch[3])) ==2){
				if( ch[3] != 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[3]-64+1][ch[1]-48] != "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end3= false;
					break;
				}else if(ch[0] != 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end3= false;
					break;
				}else if(ch[3] == 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end3= false;
					break;
				}else if(ch[0] == 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end3= false;
					break;
				}else {
					System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
				}
			}else if(l==6 && ch[0]>64 && ch[0]<75){
					if(ch[0] != 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==56 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end3= false;
					}else if (ch[0] != 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==56 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][8] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end3= false;
					}else if(ch[0] == 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==56 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end3= false;
					}else if(ch[0] == 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==56 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end3= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else if(l== 7 && 64<ch[0] && ch[0]<75 && ch[4]>64 && ch[4] <75 && ch[1] == 49 && ch[2] == 48 && ch[3] == 32) {
					if(ch[4] != 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64-1][10] != "O" && field[ch[4]-64+1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end3= false;
					}else if(ch[0] != 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64-1][10] != "O" && field[ch[0]-64+1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end3= false;
					}else if(ch[4] == 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64-1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end3= false;
					}else if(ch[0] == 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64-1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end3= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else {
				System.out.println("Error! Wrong coordinates! Try Again:");
				}
		
		}while(end3);
		for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		//--------------------------------------Placing Cruiser: -----------------------------------------
		System.out.println("Enter the coordinates of the Cruiser (3 cells):");
		boolean end4= true;
		do {
			String bplace= scanner.nextLine();
			int l= bplace.length();
			char[] ch= bplace.toCharArray();
			if(l== 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1] != ch[4] && ch[0] == ch[3] && ch[2] == 32 && Math.abs((ch[1]-ch[4])) ==2) {
				if(ch[0] != 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[0]-64+1][ch[1]-48+1] != "O" && field[ch[0]-64+1][ch[1]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end4= false;
					}else if(ch[0] != 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O" && field[ch[0]-64+1][ch[4]-48] != "O" && field[ch[0]-64+1][ch[4]-48+1] != "O" && field[ch[0]-64+1][ch[4]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end4= false;
					}else if(ch[0]== 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end4= false;
					}else if(ch[0] == 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48+2] != "O") {
						for(int r=0; r< 3; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end4= false;
					}else {
						System.out.println("Error! Too close to other ships! Try Again:");
					}
			}else if(l==5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1]==ch[4] && ch[0] != ch[3] && ch[2] == 32 && Math.abs((ch[0]-ch[3])) ==2){
				if( ch[3] != 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[3]-64+1][ch[1]-48] != "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end4= false;
				}else if(ch[0] != 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end4= false;
				}else if(ch[3] == 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O" && field[ch[0]-64+2][ch[1]-48-1]!= "O" && field[ch[0]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end4= false;
				}else if(ch[0] == 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O" && field[ch[3]-64+2][ch[1]-48-1]!= "O" && field[ch[3]-64+2][ch[1]-48+1]!= "O") {
					for(int c=0; c < 3; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end4= false;
				}else {
					System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
				}
			}else if(l==6 && ch[0]>64 && ch[0]<75){
					if(ch[0] != 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==56 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end4= false;
					}else if (ch[0] != 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==56 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][8]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end4= false;
					}else if(ch[0] == 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==56 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end4= false;
					}else if(ch[0] == 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==56 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][7] != "O" && field[ch[0]-64-1][8]!= "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64][8+k]= "O";
						}end4= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else if(l== 7 && 64<ch[0] && ch[0]<75 && ch[4]>64 && ch[4] <75 && ch[1] == 49 && ch[2] == 48 && ch[3] == 32) {
					if(ch[4] != 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64-1][10] != "O" && field[ch[4]-64+1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end4= false;
					}else if(ch[0] != 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64-1][10] != "O" && field[ch[0]-64+1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end4= false;
					}else if(ch[4] == 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64+2][9] != "O" && field[ch[0]-64-1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end4= false;
					}else if(ch[0] == 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64+2][9] != "O" && field[ch[4]-64-1][10] != "O") {
						for(int k=0; k < 3; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end4= false;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else {
				System.out.println("Error! Wrong coordinates! Try Again:");
				}
		
		}while(end4);
		for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		//---------------------------------------Placing Destroyer: ------------------------------------------
		System.out.println("Enter the coordinates of the Destroyer (2 cells):");
		boolean end5= true;
		do {
			String bplace= scanner.nextLine();
			int l= bplace.length();
			char[] ch= bplace.toCharArray();
			if(l== 5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1] != ch[4] && ch[0] == ch[3] && ch[2] == 32 && Math.abs((ch[1]-ch[4])) ==1) {
				if(ch[0] != 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[0]-64+1][ch[1]-48+1] != "O") {
						for(int r=0; r< 2; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end5= false;
						break;
					}else if(ch[0] != 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O" && field[ch[0]-64+1][ch[4]-48] != "O" && field[ch[0]-64+1][ch[4]-48+1] != "O") {
						for(int r=0; r< 2; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end5= false;
						break;
					}else if(ch[0]== 74 && ch[1] < ch[4] && field[ch[0]-64][ch[1]-48-1] != "O" && field[ch[0]-64][ch[4]-48+1] != "O" && field[ch[0]-64-1][ch[1]-48] != "O" && field[ch[0]-64-1][ch[1]-48+1] != "O") {
						for(int r=0; r< 2; ++r) {
							field[ch[0]-64][ch[1]-48+r]= "O";
						}end5= false;
						break;
					}else if(ch[0] == 74 && ch[1] > ch[4] && field[ch[0]-64][ch[4]-48-1] != "O" && field[ch[0]-64][ch[1]-48+1] != "O" && field[ch[0]-64-1][ch[4]-48] != "O" && field[ch[0]-64-1][ch[4]-48+1] != "O") {
						for(int r=0; r< 2; ++r) {
							field[ch[0]-64][ch[4]-48+r]= "O";
						}end5= false;
						break;
					}else {
						System.out.println("Error! Too close to other ships! Try Again:");
					}
			}else if(l==5 && ch[0]>64 && ch[0]<75 && ch[3]>64 && ch[3]<75 && ch[1]>48 && ch[1]<58 && ch[4]>48 && ch[4]<58 && ch[1]==ch[4] && ch[0] != ch[3] && ch[2] == 32 && Math.abs((ch[0]-ch[3])) ==1){
				if( ch[3] != 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[3]-64+1][ch[1]-48] != "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O") {
					for(int c=0; c < 2; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end5= false;
					break;
				}else if(ch[0] != 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[0]-64+1][ch[1]-48] != "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O") {
					for(int c=0; c < 2; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end5= false;
					break;
				}else if(ch[3] == 74 && ch[0] < ch[3] && field[ch[0]-64-1][ch[1]-48]!= "O" && field[ch[0]-64][ch[1]-48-1]!= "O" && field[ch[0]-64][ch[1]-48+1]!= "O" && field[ch[0]-64+1][ch[1]-48-1]!= "O" && field[ch[0]-64+1][ch[1]-48+1]!= "O") {
					for(int c=0; c < 2; ++c) {
						field[ch[0]-64+c][ch[1]-48]= "O";
					}end5= false;
					break;
				}else if(ch[0] == 74 && ch[0] > ch[3] && field[ch[3]-64-1][ch[1]-48]!= "O" && field[ch[3]-64][ch[1]-48-1]!= "O" && field[ch[3]-64][ch[1]-48+1]!= "O" && field[ch[3]-64+1][ch[1]-48-1]!= "O" && field[ch[3]-64+1][ch[1]-48+1]!= "O") {
					for(int c=0; c < 2; ++c) {
						field[ch[3]-64+c][ch[1]-48]= "O";
					}end5= false;
					break;
				}else {
					System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
				}
			}else if(l==6 && ch[0]>64 && ch[0]<75){
					if(ch[0] != 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==57 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][8] != "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64][9+k]= "O";
						}end5= false;
						break;
					}else if (ch[0] != 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==57 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][8] != "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O" && field[ch[0]-64+1][9]!= "O" && field[ch[0]-64+1][10]!= "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64][9+k]= "O";
						}end5= false;
						break;
					}else if(ch[0] == 74 && ch[0] == ch[3] && ch[4]== 49 && ch[5] == 48 && ch[1] ==57 && ch[3]>64 && ch[3]<75 && ch[1]<58 && ch[2] == 32 && field[ch[0]-64][8] != "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64][9+k]= "O";
						}end5= false;
						break;
					}else if(ch[0] == 74 && ch[0] == ch[4] && ch[1] == 49 && ch[2] ==48 && ch[5] ==57 && ch[4] >64 && ch[4]<75 && ch[3] ==32 && field[ch[0]-64][8] != "O" && field[ch[0]-64-1][9]!= "O" && field[ch[0]-64-1][10]!= "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64][9+k]= "O";
						}end5= false;
						break;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else if(l== 7 && 64<ch[0] && ch[0]<75 && ch[4]>64 && ch[4] <75 && ch[1] == 49 && ch[2] == 48 && ch[3] == 32) {
					if(ch[4] != 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64-1][10] != "O" && field[ch[4]-64+1][10] != "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end5= false;
						break;
					}else if(ch[0] != 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64-1][10] != "O" && field[ch[0]-64+1][10] != "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end5= false;
						break;
					}else if(ch[4] == 74 && ch[0] < ch[4] && field[ch[0]-64][9] != "O" && field[ch[0]-64+1][9] != "O" && field[ch[0]-64-1][10] != "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[0]- 64+k][10]= "O";
						}end5= false;
						break;
					}else if(ch[0] == 74 && ch[0] > ch[4] && field[ch[4]-64][9] != "O" && field[ch[4]-64+1][9] != "O" && field[ch[4]-64-1][10] != "O") {
						for(int k=0; k < 2; ++k) {
							field[ch[4]- 64+k][10]= "O";
						}end5= false;
						break;
					}else {
						System.out.println("Error! Too close to or intersecting the Aircraft! Try Again:");
					}
			}else {
				System.out.println("Error! Wrong coordinates! Try Again:");
				}
		
		}while(end5);
		for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		field[0][0] = "0";// To facilitate reading from file
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < field.length; i++)//for each row
		{
		   for(int j = 0; j < field[i].length; j++)//for each column
		   {
		      builder.append(field[i][j]+"");//append to the output string
		      if(j < field.length - 1)//if this is not the last row element
		         builder.append(" ");//then add comma (if you don't like commas you can use spaces)
		   }
		   builder.append("\n");//append new line at the end of the row
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\player2.txt"));
		writer.write(builder.toString());//save the string representation of the board
		writer.close();
	}
}
