import java.io.File;

public interface Config {

    String getMostraText_mostraDir();
    String getMostraText_buscaLlibre();
    String getMostraText_buscaCategoria();
    String getMostraText_creaInventari();
    String getMostraText_creaCategoria();
    String getMostraText_catalogarLlibre();
    String getMostraText_mostraLlibre();

    String getMostraText_demanaTitol();
    String getMostraText_demanaAutor();
    String getMostraText_demanaEditorial();

    String getMostraText_demanaRuta();


    String getMostraText_moureLlibre();
    String getMostraText_veureLlibre();
    String getMostraText_LlibreNoTrovat();

    String getMostraText_demanaCategoria();
    String getMostraText_demanaQuinaCategoria();

    File getPathBiblioteca();

}
