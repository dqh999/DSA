package graph.exception;

public class VertexExistsException extends RuntimeException {
    public VertexExistsException(String message) {
        super(message);
    }
}