import java.io.File;

public class ConfigImp implements Config {


    private final File biblioteca = new File("./src/biblioteca");

    private final File inventari = new File("./src/biblioteca/inventari.txt");


    private final String mostraDir = "Mostrar directori";
    private final String buscallibre = "Buscar un llibre";
    private final String buscaCategoria = "Busca categoria";
    private final String creaInvetari = "Crear inventari";
    private final String creaCategoria = "Crear una categoria";
    private final String catalogarLlibre = "Catalogar un llibre";
    private final String moureLlibre = "Moure un llibre";
    private final String mostrarLlibre = "Mostrar llibre";
    private final String mostrarLlibreNoTrobat = "No hi ha cap llibre amb aquest nom";

    private final String demanaRuta = "Escriu la ruta:";
    private final String demanaTitol = "Escriu el titol del llibre:";
    private final String demanaAutor = "Escriu l'autor:";
    private final String demanaEditorial = "Escriu l'editorial:";

    private final String demanaQuinaCategoria = " Escriu categoria:";
    private final String demanaCategoria = "Vols inscriure'l en alguna la categoria existent? <s/n>";


    public String getMostraText_demanaQuinaCategoria() {
        return demanaQuinaCategoria;
    }

    public File getPathInventari(){return inventari;}

    public File getPathBiblioteca(){
        return biblioteca;
    }

    public String getMostraText_LlibreNoTrovat(){return mostrarLlibreNoTrobat;}

    public String getMostraText_demanaCategoria() {
        return demanaCategoria;
    }

    public String getMostraText_demanaRuta(){return demanaRuta;}

    public String getMostraText_mostraLlibre(){return mostrarLlibre;}

    public String getMostraText_demanaTitol(){return demanaTitol;}

    public String getMostraText_demanaAutor(){return demanaAutor;}

    public String getMostraText_demanaEditorial(){return demanaEditorial;}

    public String getMostraText_mostraDir() {
        return mostraDir;
    }

    public String getMostraText_buscaLlibre() {
        return buscallibre;
    }

    public String getMostraText_buscaCategoria() { return buscaCategoria; }

    public String getMostraText_creaInventari() {
        return creaInvetari;
    }

    public String getMostraText_creaCategoria() {
        return creaCategoria;
    }

    public String getMostraText_catalogarLlibre() {
        return catalogarLlibre;
    }

    public String getMostraText_moureLlibre() {return moureLlibre; }

    public String getMostraText_veureLlibre() {
        return mostrarLlibre;
    }
}
