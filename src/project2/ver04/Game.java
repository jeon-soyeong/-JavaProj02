package project2.ver04;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

	String[][] numberGame = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "X" } };
	String[][] answer = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "X" } };

	int x = 2;
	int y = 2;
	String temp;

	public void leftMove() {
		
		temp = numberGame[x][y + 1];
		numberGame[x][y + 1] = numberGame[x][y];
		numberGame[x][y] = temp;
		y++;
	}

	public void rightMove() {

		temp = numberGame[x][y - 1];
		numberGame[x][y - 1] = numberGame[x][y];
		numberGame[x][y] = temp;
		y--;
	}

	public void upperMove() {
		temp = numberGame[x + 1][y];
		numberGame[x + 1][y] = numberGame[x][y];
		numberGame[x][y] = temp;
		x++;
	}

	public void downMove() {
		temp = numberGame[x - 1][y];
		numberGame[x - 1][y] = numberGame[x][y];
		numberGame[x][y] = temp;
		x--;
	}
	
	boolean checkAnswer=false;
	public void check() {
		int answerCnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (numberGame[i][j].equals(answer[i][j])){
					answerCnt++;
				}
			}
		}
		if (answerCnt >= 9) {
			 checkAnswer = true;
			System.out.println("==^^정답입니다^^==");
		} else {
			System.out.println("==다시 시도하세요.==");
			checkAnswer = false;
		}
	}

	public void play() throws IOException {
		
		for (int i = 0; i < 3; i++) {
			suffle();
		}
		
		showArray();
		
		Scanner scanner = new Scanner(System.in);
		char exitCode =  ' ';
		checkAnswer = false;

		while (!(exitCode == 'x' || exitCode == 'X') && checkAnswer == false) {

			System.out.println("[이동] a:Left d:Right w:Up s:Down");
			System.out.println("[종료] x:Exit");
			System.out.println("키를 입력해주세요.");
			String code = scanner.next();
			exitCode = code.charAt(0);
			
			try {
				if (exitCode == 'a') {
					leftMove();
					showArray();
					check();
				} else if (exitCode == 'd') {
					rightMove();
					showArray();
					check();
				} else if (exitCode == 'w') {
					upperMove();
					showArray();
					check();
				} else if (exitCode == 's') {
					downMove();
					showArray();
					check();
				} else if (exitCode == 'x') {
					System.out.println("게임을 종료합니다.");
					break;
				} 
			} 
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("더 이상 이동이 불가합니다.");
				continue;
			}
		}

		int retry = 0;
		System.out.println("재시작하시겠습니까? (y 누르면 재시작, 나머지는 종료)");
		retry = System.in.read();
		if ((retry == 'y' || retry == 'Y')) {
			 play();
		} 
		else {
			System.out.println("게임을 종료합니다.");
		}
	}

	public void suffle() {
		
		try{
			Random random =  new Random();
			int randNum= random.nextInt(4);
			
			switch(randNum) {
				case 0: 
					leftMove();
					break;
				case 1:
					rightMove();
					break;
				case 2:
					upperMove();
					break;
				case 3: 
					downMove();
					break;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
	}

	public void showArray() {
		System.out.println("====================");
		for (int i = 0; i < numberGame.length; i++) {
			for (int j = 0; j < numberGame[i].length; j++) {
				System.out.printf("%-4s", numberGame[i][j]);
			}
			System.out.println();
		}
		System.out.println("====================");
	}

	public static void main(String[] args) {

		Game game = new Game();

		try {
			game.play();
		}
		catch (IOException e) {
		}
	}
}