package modelo;

public interface Estanterizable {

	public boolean insertarLibro(Libro libro);

	public boolean borrarLibro(String isbn);

	public Libro buscarLibro(Integer index);

}
