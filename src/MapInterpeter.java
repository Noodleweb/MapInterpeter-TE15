import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/*
 * TODO: Du ska sj�lv skapa en class Tile som �rver Rectangle 
 * och d�r skapa funktionallitet f�r att h�lla koll p� olika 
 * typer av rutor.
 * 
 * N�gra rutor ska vara v�ggar, hinder, flyttbara, d�dliga eller
 * hur du sj�lv vill skapa din v�rld.
 */


public class MapInterpeter {

	/**
	 * Storleken p� rutorna som denna MapInterpeter skapar
	 */
	public final double SQUARE_SIZE;

	/**
	 * Skapar en ny MapInterpeter med en best�md storlek p� varje ruta
	 * @param size storlek p� rutorna som kommer skapas av denna MapInterpeter
	 */
	public MapInterpeter(double size) {
		this.SQUARE_SIZE = size;
	}

	/**
	 * Skapar en ny karta genom att l�sa in en textfil
	 * @param file s�kv�g till din textfil
	 * @return en Group med en grafisk representation av din textfil
	 */
	public Group interpetMap(String file) {

		Scanner sc = null;

		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0); // St�ng av programmet.
		}

		int row = -1;

		Group mapGroup = new Group();

		while (sc.hasNextLine()) {
			
			String line = sc.nextLine();
			row++;

			char[] lineArray = line.toCharArray();

			for (int col = 0; col < lineArray.length; col++) {
				char c = lineArray[col];
				
				Rectangle tile = null;
				switch (c) {

				//TODO: L�gg till de cases du beh�ver f�r att skapa olika rutor.
				//TODO: Skapa en Tile class f�r att representera rutor.
				case '#':
					tile = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
					tile.setFill(Color.BLACK);
					tile.setTranslateY(SQUARE_SIZE * row);
					tile.setTranslateX(SQUARE_SIZE * col);
					break;
				case ' ':
					tile = null;
					break;
				default:
					tile = null;
					break;
				}

				// Om tile inte instansierades l�gg inte till n�gon ruta i Group
				if (tile != null) {
					mapGroup.getChildren().add(tile);
				}

			}
		}

		return mapGroup;

	}
}
