package ru.lessons.lesson_13.logics;

import ru.lessons.lesson_13.Cell;
import ru.lessons.lesson_13.SaperLogic;

/**
 * TODO: comment
 * @author parsentev
 * @since 08.04.2015
 */
public class Easy implements SaperLogic {
	private Cell[][] cells;

	@Override
	public void loadBoard(Cell[][] cells) {
		this.cells = cells;
	}

	@Override
	public boolean shouldBang(int x, int y) {
		final Cell selected = this.cells[x][y];
		return selected.isBomb() && !selected.isSuggestBomb();
	}

	@Override
	public boolean finish() {
		for (Cell[] row : cells) {
			for (Cell cell : row) {
				if (!(cell.isSuggestBomb() && cell.isBomb() ||
				          cell.isSuggestEmpty() && !cell.isBomb()))
					return false;
			}
		}
		return true;
	}

	@Override
	public void suggest(int x, int y, boolean bomb) {
		if (bomb) {
			this.cells[x][y].suggectBomb();
		} else {
			this.cells[x][y].suggectEmpty();
		}
	}
}
