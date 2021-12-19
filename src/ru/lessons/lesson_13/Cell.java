package ru.lessons.lesson_13;

/**
 * TODO: comment
 * @author parsentev
 * @since 08.04.2015
 */
public interface Cell<T> {

	boolean isBomb();

	boolean isSuggestBomb();

	boolean isSuggestEmpty();

	void suggectEmpty();

	void suggectBomb();

	public void setBomb();
	public int getBesideBomb();
	public void setBesideBomb(int besideBomb) ;
	
	void draw(T paint, boolean real);
	void draw(T paint, int x, int y, boolean real);
}
