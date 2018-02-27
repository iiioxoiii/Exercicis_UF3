import java.util.Scanner;
import java.io.File;


public class GestorMenuImpl implements GestorMenu {


    public void mostraCategoria(){
        Scanner sc = new Scanner(System.in);
        Config c = new ConfigImp();
        System.out.println(c.getMostraText_buscaCategoria());
        String nomLlibre = sc.nextLine();
    }

    public void mostraBiblioteca() {
        Obrador o = new Obrador();
        //o.mostraBibli();
        o.mostraBibli_02();
    }

    public void buscaLlibre() {
        Scanner sc = new Scanner(System.in);
        Config c = new ConfigImp();
        System.out.println(c.getMostraText_buscaLlibre());
        String nomLlibre = sc.nextLine();

        Obrador o = new Obrador();
        o.buscaLlibre(nomLlibre);
    }

    public void llibresEnCategoria() {

        Obrador o = new Obrador();

        Scanner sc = new Scanner(System.in);
        Config c = new ConfigImp();
        c.getMostraText_buscaCategoria();
        String nomCategoria = sc.next();

        o.llibresEnCategoria(nomCategoria);
    }

    public void creaInventari() {

        Obrador o = new Obrador();

        o.creaInventari();
    }

    public void creaCategoria() {

        Obrador o = new Obrador();

        Scanner sc = new Scanner(System.in);
        Config c = new ConfigImp();
        System.out.println(c.getMostraText_creaCategoria());
        String nomCategoria = sc.next();

        o.creaCategoria(nomCategoria);

    }

    public void catalogarLlibre() {

        Obrador o = new Obrador();

        Scanner sc = new Scanner(System.in);
        Config c = new ConfigImp();

        //Demanar quin fitxer obrir
        // (introduint el titol del fitxer per teclat)
        System.out.println(c.getMostraText_demanaTitol());
        String titol = sc.nextLine();

        //Escriure l'autor a la segona fila del fitxer
        // (introduït per teclat)
        System.out.println(c.getMostraText_demanaAutor());
        String autor = sc.nextLine();

        //Escriure l'editorial a la tercera fila del fitxer
        // (introduït per teclat)
        System.out.println(c.getMostraText_demanaEditorial());
        String editorial = sc.nextLine();

        //Preguntar per teclat si volem incloure'l en una categoria
        // si la resposta és afirmativa es mou el fitxer a una categoria
        // de la nostra biblioteca digital introduida per teclat,
        // en cas negatiu es quedarà a l'arrel de la biblioteca.
        System.out.println(c.getMostraText_demanaCategoria());
        String categoria= sc.nextLine();

        if(categoria.equals("s")){
            System.out.println(c.getMostraText_demanaQuinaCategoria());
            categoria=sc.nextLine();
            File fcategoria = new File(categoria);
            o.creaArxiuAlaCategoria(fcategoria, titol, autor, editorial);
        }else{
            File fcategoria = new File(c.getPathBiblioteca().toString());
            o.creaArxiuAlaCategoria(fcategoria,titol, autor, editorial);
        }

    }

    public void mostraLlibre() {

        Obrador o = new Obrador();

        Config c = new ConfigImp();

        Scanner sc = new Scanner(System.in);
        System.out.println(c.getMostraText_demanaTitol());
        String nomLlibre = sc.nextLine();
        o.mostraAtributsLlibre(nomLlibre);


    }

    public void moureLlibre() {

        Obrador o = new Obrador();

        Config c = new ConfigImp();

        Scanner sc = new Scanner(System.in);
        System.out.println(c.getMostraText_CanviCat());
        System.out.println(c.getMostraText_demanaTitol());
        String nomLlibre = sc.nextLine();
        //categoria destí
        System.out.println(c.getMostraText_demanaCategoria());
        String catDesti = sc.nextLine();

        o.mouLlibre(nomLlibre, catDesti);

    }
}
