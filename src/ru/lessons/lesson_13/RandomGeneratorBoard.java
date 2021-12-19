package ru.lessons.lesson_13;

import ru.lessons.lesson_13.gui.GUICell;

public class RandomGeneratorBoard implements GeneratorBoard {

	private int size;
	
	
	public RandomGeneratorBoard(int size) {
		super();
		this.size = size;
	}


	// FIXME задать сложность игры
	@Override
	public Cell[][] generate() {
		int bombSize = size;
		Cell[][] cells = new Cell[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cells[i][j] = new GUICell();
			}
		}
		for (int i = 0; i < bombSize; i++) {
			int col = (int) Math.round(Math.random() * (double) (size - 1));
			int row = (int) Math.round(Math.random() * (double) (size - 1));
			cells[col][row].setBomb();
		}
		calcBesideBomb(cells);
		return cells;
	}
	
	private void calcBesideBomb(Cell[][] cells) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!cells[i][j].isBomb()) {
					int count = 0;
					for (int x = i - 1; x <= i + 1; x++)
						if ((x>=0)&&(x<size)) 
							for (int y = j - 1; y <= j + 1; y++)
								if ((y>=0)&&(y<size))
									if (cells[x][y].isBomb())
										count++;
					cells[i][j].setBesideBomb(count);
				}
			}
		} 
	}
	
	

}
