package graph.exception;
public class VertexNotFoundException extends RuntimeException {
    public VertexNotFoundException(String message) {
        super(message);
    }
}