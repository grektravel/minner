package ru.lessons.lesson_13;

/**
 * TODO: comment
 * @author parsentev
 * @since 08.04.2015
 */
public class BaseAction implements UserAction {
	private final GeneratorBoard generator;
	private final Board board;
	private final SaperLogic logic;
	private Cell[][] cells;

	public BaseAction(final SaperLogic logic, final Board board, final GeneratorBoard generator) {
		this.generator = generator;
		this.board = board;
		this.logic = logic;
	}

	public void initGame() {
		cells = generator.generate();
		board.drawBoard(cells);
		logic.loadBoard(cells);
	}

	public void select(int x, int y, boolean bomb) {
		logic.suggest(x, y, bomb);
		board.drawCell(x, y);
		if (logic.shouldBang(x, y)) {
			board.drawBang();
		}
		if (logic.finish()) {
			board.drawCongratulate();
		}
		//FIXME возможно сделать наследованием
		if (cells[x][y].getBesideBomb()==0) {
			for (int i = x - 1; i <= x + 1; i++)
				if ((i>=0)&&(i<cells.length)) 
					for (int j = y - 1; j <= y + 1; j++)
						if ((j>=0)&&(j<cells.length))
							if (!cells[i][j].isSuggestEmpty())
								select(i,j,false);
		}
	}

}
