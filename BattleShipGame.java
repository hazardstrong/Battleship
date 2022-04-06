package battleship;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class BattleShipGame {
	
		//---------------------------------------------------------------------------------------------
	public static String[][] fog() {
		String[][] field= new String[11][11];
    	char[] chfield= {' ', 'A','B','C','D','E','F','G','H','I','J'};
    	for(int i= 0; i < 11; ++i) {
    		for(int j=0; j < 11; ++j) {
    			if(i == 0 && j == 0) {
    				field[i][j]= " ";
    			}else if (j > 0 && i == 0) {
    				field[i][j]= ""+j;
    			}else if(j == 0 && i > 0) {
    				field[i][j] = String.valueOf(chfield[i]);
    			}else {
    				field[i][j] = "~";
    			}
    		}
    	}
    	for(int i=0; i< 11; ++i) {
			for(int j=0; j< 11; ++j) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println();
		}
		return field;
	}
	//------------------------------------------PLAYER 1--------------------------------------------------
	private static String[] readFile(String string) {
        try {
            File f= new File(string);
            Scanner s= new Scanner(f);
            int ctr= 0;
            while(s.hasNext()) {
                ctr++;
                s.next();
            }
            String[] arr= new String[ctr];
            Scanner s1= new Scanner(f);
            for(int i=0; i < arr.length; i++) {
                arr[i]= s1.next();
            }
            return arr;

        }catch (Exception e){

        }
        return null;
    }
    public static String[][] theField() throws IOException {
        String[] data= readFile("E:\\player1.txt");
        String[][] field= new String[11][11];
        int x= 0;
        for(int i=0; i< 11; ++i) {
            for(int j=0; j< 11; ++j) {
                field[i][j]= data[x];
                field[0][0] = " ";
                x++;
            }
        }
        return field;
    }
	//------------------------------------------------PLAYER 2-------------------------------------------------
	private static String[] readFile2(String string) {
        try {
            File f= new File(string);
            Scanner s= new Scanner(f);
            int ctr= 0;
            while(s.hasNext()) {
                ctr++;
                s.next();
            }
            String[] arr= new String[ctr];
            Scanner s1= new Scanner(f);
            for(int i=0; i < arr.length; i++) {
                arr[i]= s1.next();
            }
            return arr;

        }catch (Exception e){

        }
        return null;
    }
    public static String[][] theField2() throws IOException {
        String[] data2= readFile2("E:\\player2.txt");
        String[][] field= new String[11][11];
        int x= 0;
        for(int i=0; i< 11; ++i) {
            for(int j=0; j< 11; ++j) {
                field[i][j]= data2[x];
                field[0][0]= " ";
                ++x;
            }
        }
        return field;
    }
	public static void game() throws IOException {
		Scanner sc= new Scanner(System.in);
		boolean exit = true;
		int count1 = 1;
		int count2 = 1;
		//Entering field2 and field1:
        String[][] f2 = new String[11][11];
        f2 = theField2();
        String[][] f1 = new String[11][11];
        f1 = theField();
        String[][] field1 =new String[25][25];
		for(int i=0; i< 25; ++i) {
			for(int j=0; j< 25; ++j) {
				if(i < 11 && j < 11) {
					field1[i][j] = f1[i][j];
				}else {
					field1[i][j] = "0";
				}
			}
		}
		String[][] field2 =new String[25][25];
		for(int i=0; i< 25; ++i) {
			for(int j=0; j< 25; ++j) {
				if(i < 11 && j < 11) {
					field2[i][j] = f2[i][j];
				}else {
					field2[i][j] = "0";
				}
			}
		}
		do {
			System.out.println("Press Enter and pass the move to another player");
			sc.nextLine();
			//------------------------------------------------------------
			fog();
			System.out.println("---------------------");
	        for(int i=0; i< 11; ++i) {
	            for(int j=0; j< 11; ++j) {
	                System.out.print(field1[i][j]+" ");
	            }
	            System.out.println();
	        }
			System.out.println("Player 1, it's your turn:");
			Scanner scanner = new Scanner(System.in);
			String shot = scanner.next();
			int l= shot.length();
			char[] ch= shot.toCharArray();
			if(l == 2 && ch[0] > 64 && ch[0] < 75 && ch[1] > 48 && ch[1] < 58) {
				int r= ch[0]-64;
				int c= ch[1]-48;
				if(field2[r][c].equals("O") && ((field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && field2[r][c+3].equals("X") && field2[r][c+4].equals("X")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c-3].equals("X") && field2[r][c-4].equals("X")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && field2[r+3][c].equals("X") && field2[r+4][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X") && field2[r-4][c].equals("X")) || (field2[r+1][c].equals("X") && field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r+1][c].equals("X") && field2[r+2][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && field2[r+3][c].equals("X")) || (field2[r][c-1].equals("X") && field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && field2[r][c+3].equals("X")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c+1].equals("X") && field2[r][c+2].equals("X")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c-3].equals("X") && field2[r][c+1].equals("X")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && field2[r][c+3].equals("X") && !field2[r][c+4].equals("O") && !field2[r][c-1].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c-3].equals("X") && !field2[r][c-4].equals("O") && !field2[r][c+1].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && !field2[r][c+3].equals("O") && !field2[r][c-2].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c+1].equals("X") && !field2[r][c-3].equals("O") && !field2[r][c+2].equals("O")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && field2[r+3][c].equals("X") && !field2[r+4][c].equals("O") && !field2[r-1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X") && !field2[r-4][c].equals("O") && !field2[r+1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && !field2[r+3][c].equals("O") && !field2[r-2][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r+1][c].equals("X") && !field2[r+2][c].equals("O") && !field2[r-3][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && !field2[r][c+3].equals("O") && !field2[r][c-1].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c+1].equals("X") && !field2[r][c-2].equals("O") && !field2[r][c+2].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && !field2[r][c-3].equals("O") && !field2[r][c+1].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && !field2[r-3][c].equals("O") && !field2[r+1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r+1][c].equals("X") && !field2[r-2][c].equals("O") && !field2[r+2][c].equals("O")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && !field2[r+3][c].equals("O") && !field2[r-1][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c+1].equals("X") && !field2[r][c+2].equals("O") && !field2[r][c-1].equals("O")) || (field2[r][c-1].equals("X") && !field2[r][c-2].equals("O") && !field2[r][c+1].equals("O")) || (field2[r+1][c].equals("X") && !field2[r+2][c].equals("O") && !field2[r-1][c].equals("O")) || (field2[r-1][c].equals("X") && !field2[r-2][c].equals("O") && !field2[r+1][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if (field2[r][c].equals("O") || field2[r][c].equals("X")) {
					field2[r][c] = "X";
					System.out.println("You hit a ship!");
				}else if (field2[r][c].equals("~") || field2[r][c].equals("M")) {
					field2[r][c] = "M";
					System.out.println("You missed.");
				}
			}else if(l == 3 && ch[0] > 64 && ch[0] < 75 && ch[1] == 49 && ch[2] == 48) {
				int r= ch[0]-64;
				int c= 10;
				if(field2[r][c].equals("O") && ((field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c-3].equals("X") && field2[r][c-4].equals("X")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && field2[r+3][c].equals("X") && field2[r+4][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X") && field2[r-4][c].equals("X")) || (field2[r+1][c].equals("X") && field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r+1][c].equals("X") && field2[r+2][c].equals("X")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X") && field2[r+1][c].equals("X")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && field2[r][c-3].equals("X") && !field2[r][c-4].equals("O")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && field2[r+3][c].equals("X") && !field2[r+4][c].equals("O") && !field2[r-1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r-3][c].equals("X") && !field2[r-4][c].equals("O") && !field2[r+1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && !field2[r-2][c].equals("O") && !field2[r+3][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && field2[r+1][c].equals("X") && !field2[r-3][c].equals("O") && !field2[r+2][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c+1].equals("X") && field2[r][c+2].equals("X") && !field2[r][c+3].equals("O") && !field2[r][c-1].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c+1].equals("X") && !field2[r][c-2].equals("O") && !field2[r][c+2].equals("O")) || (field2[r][c-1].equals("X") && field2[r][c-2].equals("X") && !field2[r][c-3].equals("O") && !field2[r][c+1].equals("O")) || (field2[r-1][c].equals("X") && field2[r-2][c].equals("X") && !field2[r-3][c].equals("O") && !field2[r+1][c].equals("O")) || (field2[r-1][c].equals("X") && field2[r+1][c].equals("X") && !field2[r-2][c].equals("O") && !field2[r+2][c].equals("O")) || (field2[r+1][c].equals("X") && field2[r+2][c].equals("X") && !field2[r+3][c].equals("O") && !field2[r-1][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") && ((field2[r][c-1].equals("X") && !field2[r][c-2].equals("O")) || (field2[r+1][c].equals("X") && !field2[r+2][c].equals("O") && !field2[r-1][c].equals("O")) || (field2[r-1][c].equals("X") && !field2[r-2][c].equals("O") && !field2[r+1][c].equals("O")))) {
					field2[r][c] = "X";
					if(count2 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count2 += 1;
				}else if(field2[r][c].equals("O") || field2[r][c].equals("X")) {
					field2[r][c] = "X";
					System.out.println("You hit a ship!");
				}else if(field2[r][c].equals("~") || field2[r][c].equals("M")) {
					field2[r][c] = "M";
					System.out.println("You missed.");
				}
			}
			else 
				System.out.println("Error!");
			//-------------------------------------------------------------------------
			if(exit == false) {
				break;
			}
			System.out.println("Press Enter and pass the move to another player");
			sc.nextLine();
			fog();
			System.out.println("---------------------");
	        for(int i=0; i< 11; ++i) {
	            for(int j=0; j< 11; ++j) {
	                System.out.print(field2[i][j]+" ");
	            }
	            System.out.println();
	        }
			System.out.println("Player 2, it's your turn:");
			String shot2 = scanner.next();
			int l2 = shot2.length();
			char[] ch2= shot2.toCharArray();
			if(l2 == 2 && ch2[0] > 64 && ch2[0] < 75 && ch2[1] > 48 && ch2[1] < 58) {
				int r= ch2[0]-64;
				int c= ch2[1]-48;
				if(field1[r][c].equals("O") && ((field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && field1[r][c+3].equals("X") && field1[r][c+4].equals("X")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c-3].equals("X") && field1[r][c-4].equals("X")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && field1[r+3][c].equals("X") && field1[r+4][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X") && field1[r-4][c].equals("X")) || (field1[r+1][c].equals("X") && field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r+1][c].equals("X") && field1[r+2][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && field1[r+3][c].equals("X")) || (field1[r][c-1].equals("X") && field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && field1[r][c+3].equals("X")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c+1].equals("X") && field1[r][c+2].equals("X")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c-3].equals("X") && field1[r][c+1].equals("X")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && field1[r][c+3].equals("X") && !field1[r][c+4].equals("O") && !field1[r][c-1].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c-3].equals("X") && !field1[r][c-4].equals("O") && !field1[r][c+1].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && !field1[r][c+3].equals("O") && !field1[r][c-2].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c+1].equals("X") && !field1[r][c-3].equals("O") && !field1[r][c+2].equals("O")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && field1[r+3][c].equals("X") && !field1[r+4][c].equals("O") && !field1[r-1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X") && !field1[r-4][c].equals("O") && !field1[r+1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && !field1[r+3][c].equals("O") && !field1[r-2][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r+1][c].equals("X") && !field1[r+2][c].equals("O") && !field1[r-3][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && !field1[r][c+3].equals("O") && !field1[r][c-1].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c+1].equals("X") && !field1[r][c-2].equals("O") && !field1[r][c+2].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && !field1[r][c-3].equals("O") && !field1[r][c+1].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && !field1[r-3][c].equals("O") && !field1[r+1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r+1][c].equals("X") && !field1[r-2][c].equals("O") && !field1[r+2][c].equals("O")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && !field1[r+3][c].equals("O") && !field1[r-1][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c+1].equals("X") && !field1[r][c+2].equals("O") && !field1[r][c-1].equals("O")) || (field1[r][c-1].equals("X") && !field1[r][c-2].equals("O") && !field1[r][c+1].equals("O")) || (field1[r+1][c].equals("X") && !field1[r+2][c].equals("O") && !field1[r-1][c].equals("O")) || (field1[r-1][c].equals("X") && !field1[r-2][c].equals("O") && !field1[r+1][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if (field1[r][c].equals("O") || field1[r][c].equals("X")) {
					field1[r][c] = "X";
					System.out.println("You hit a ship!");
				}else if (field1[r][c].equals("~") || field1[r][c].equals("M")) {
					field1[r][c] = "M";
					System.out.println("You missed.");
				}
			}else if(l2 == 3 && ch2[0] > 64 && ch2[0] < 75 && ch2[1] == 49 && ch2[2] == 48) {
				int r= ch2[0]-64;
				int c= 10;
				if(field1[r][c].equals("O") && ((field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c-3].equals("X") && field1[r][c-4].equals("X")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && field1[r+3][c].equals("X") && field1[r+4][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X") && field1[r-4][c].equals("X")) || (field1[r+1][c].equals("X") && field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r+1][c].equals("X") && field1[r+2][c].equals("X")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X") && field1[r+1][c].equals("X")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && field1[r][c-3].equals("X") && !field1[r][c-4].equals("O")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && field1[r+3][c].equals("X") && !field1[r+4][c].equals("O") && !field1[r-1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r-3][c].equals("X") && !field1[r-4][c].equals("O") && !field1[r+1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && !field1[r-2][c].equals("O") && !field1[r+3][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && field1[r+1][c].equals("X") && !field1[r-3][c].equals("O") && !field1[r+2][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c+1].equals("X") && field1[r][c+2].equals("X") && !field1[r][c+3].equals("O") && !field1[r][c-1].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c+1].equals("X") && !field1[r][c-2].equals("O") && !field1[r][c+2].equals("O")) || (field1[r][c-1].equals("X") && field1[r][c-2].equals("X") && !field1[r][c-3].equals("O") && !field1[r][c+1].equals("O")) || (field1[r-1][c].equals("X") && field1[r-2][c].equals("X") && !field1[r-3][c].equals("O") && !field1[r+1][c].equals("O")) || (field1[r-1][c].equals("X") && field1[r+1][c].equals("X") && !field1[r-2][c].equals("O") && !field1[r+2][c].equals("O")) || (field1[r+1][c].equals("X") && field1[r+2][c].equals("X") && !field1[r+3][c].equals("O") && !field1[r-1][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") && ((field1[r][c-1].equals("X") && !field1[r][c-2].equals("O")) || (field1[r+1][c].equals("X") && !field1[r+2][c].equals("O") && !field1[r-1][c].equals("O")) || (field1[r-1][c].equals("X") && !field1[r-2][c].equals("O") && !field1[r+1][c].equals("O")))) {
					field1[r][c] = "X";
					if(count1 == 5) {
						System.out.println("You sank the last ship. You won. Congratulations!");
						exit = false;
					}else
						System.out.println("You sank a ship! Specify a new target:");
					count1 += 1;
				}else if(field1[r][c].equals("O") || field1[r][c].equals("X")) {
					field1[r][c] = "X";
					System.out.println("You hit a ship!");
				}else if(field1[r][c].equals("~") || field1[r][c].equals("M")) {
					field1[r][c] = "M";
					System.out.println("You missed.");
				}
			}
			else {
			System.out.println("Error!");
			}
		}while(exit);
}
}