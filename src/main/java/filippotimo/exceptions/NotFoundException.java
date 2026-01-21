package filippotimo.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long eventoId) {
        super("L'evento con id " + eventoId + " non è stato trovato");
    }
}