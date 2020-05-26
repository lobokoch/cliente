package br.com.kerubin.api.cadastros.agenda.model;

public class AgendaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AgendaException() {
        super();
    }

    
    public AgendaException(String message) {
        super(message);
    }

    
    public AgendaException(String message, Throwable cause) {
        super(message, cause);
    }

}
