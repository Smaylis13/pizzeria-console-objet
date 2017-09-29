package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {

	public DeletePizzaException() {
		super();
	}

public DeletePizzaException(String msg) {
		super(msg);
	}
}