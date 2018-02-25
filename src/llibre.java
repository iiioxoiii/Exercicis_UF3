public interface llibre extends Comparable<llibre> {

    public String getNomAutor();
    public String getTitol();
    public String getEditorial();
    public String getCategoria();

    public void setNomAutor(String autor);
    public void setTitol(String titol);
    public void setEditorial(String editorial);
    public void setCategoria(String categoria);

    public int compareTo(llibre l);
    public boolean equals(Object o);

}
