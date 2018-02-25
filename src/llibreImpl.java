public class llibreImpl implements llibre , Comparable<llibre>{

    String nomAutor = null;
    String titol = null;
    String editorial = null;
    String categoria = null;


    public String getNomAutor() {
        return nomAutor;
    }

    public String getTitol() {
        return titol;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNomAutor(String autor) {
        this.nomAutor=autor;
    }

    public void setTitol(String titol) {
        this.titol=titol;
    }

    public void setEditorial(String editorial) {
        this.editorial=editorial;
    }

    public void setCategoria(String categoria) {
        this.categoria=categoria;
    }




    public boolean equals (Object o){

        boolean res = false;

        if (o instanceof llibre){
            llibre l = (llibre) o;
            res = this.getTitol().equals(l.getTitol());
            if (res==true){
                res=this.getNomAutor().equals(l.getNomAutor());
            }
        }

        return res;
    }


    //Mètode compareTo amb el següent ordre:
    //Categoria, Títol, Autor, Editorial.

    @Override
    public int compareTo(llibre l) {

        int r;

        r = this.getCategoria().compareTo(l.getCategoria());
        if (r == 0) {
            r = this.getTitol().compareTo(l.getTitol());
            if (r == 0) {
                r = this.getNomAutor().compareTo(l.getNomAutor());
                if (r == 0) {
                    r = this.getEditorial().compareTo(l.getEditorial());
                }
            }
        }


        return r;
    }



    public String toString(){

        return (getTitol().toString() + " " + getNomAutor().toString() + " " +getEditorial().toString());
    }

}
