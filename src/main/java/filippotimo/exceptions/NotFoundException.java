package filippotimo.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID eventoId) {
        super("L'evento con id " + eventoId + " non è stato trovato");
    }
}