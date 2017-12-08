import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/*
 * TODO: Du ska själv skapa en class Tile som ärver Rectangle 
 * och där skapa funktionallitet för att hålla koll på olika 
 * typer av rutor.
 * 
 * Några rutor ska vara väggar, hinder, flyttbara, dödliga eller
 * hur du själv vill skapa din värld.
 */


public class MapInterpeter {

	/**
	 * Storleken på rutorna som denna MapInterpeter skapar
	 */
	public final double SQUARE_SIZE;

	/**
	 * Skapar en ny MapInterpeter med en bestämd storlek på varje ruta
	 * @param size storlek på rutorna som kommer skapas av denna MapInterpeter
	 */
	public MapInterpeter(double size) {
		this.SQUARE_SIZE = size;
	}

	/**
	 * Skapar en ny karta genom att läsa in en textfil
	 * @param file sökväg till din textfil
	 * @return en Group med en grafisk representation av din textfil
	 */
	public Group interpetMap(String file) {

		Scanner sc = null;

		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0); // Stäng av programmet.
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

				//TODO: Lägg till de cases du behöver för att skapa olika rutor.
				//TODO: Skapa en Tile class för att representera rutor.
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

				// Om tile inte instansierades lägg inte till någon ruta i Group
				if (tile != null) {
					mapGroup.getChildren().add(tile);
				}

			}
		}

		return mapGroup;

	}
}
