import java.util.Scanner;

public class GestorPrincipalImpl implements GestorPrincipal {

    public static void main(String[] args) {
        GestorPrincipal aplicacio = new GestorPrincipalImpl();
        aplicacio.go();
    }

    public void go(){

        GestorMenu menu = new GestorMenuImpl();


        boolean sortir = false;

        while (!sortir){
            pintaMenu();
            int opcio = preguntaEnter();

            switch (opcio) {
                case 1:  menu.mostraBiblioteca();
                    break;
                case 2:  menu.buscaLlibre();
                    break;
                case 3:  menu.llibresEnCategoria();
                    break;
                case 4:  menu.creaInventari();
                    break;
                case 5:  menu.creaCategoria();
                    break;
                case 6:  menu.catalogarLlibre();
                    break;
                case 7:  menu.moureLlibre();
                    break;
                case 8:  menu.mostraLlibre();
                    break;
                case 9: sortir=true;
                    break;
                default:
                    System.out.println("Opció no vàlida");
                    break;
            }
        }
    }



    public void pintaMenu() {
        Config c = new ConfigImp();
        System.out.print("1-");
        System.out.println(c.getMostraText_mostraDir());
        System.out.print("2-");
        System.out.println(c.getMostraText_buscaLlibre());
        System.out.print("3-");
        System.out.println(c.getMostraText_buscaCategoria());
        System.out.print("4-");
        System.out.println(c.getMostraText_creaInventari());
        System.out.print("5-");
        System.out.println(c.getMostraText_creaCategoria());
        System.out.print("6-");
        System.out.println(c.getMostraText_catalogarLlibre());
        System.out.print("7-");
        System.out.println(c.getMostraText_moureLlibre());
        System.out.print("8-");
        System.out.println(c.getMostraText_mostraLlibre());
        System.out.print("9-");
        System.out.println("Sortir");
    }

    public int preguntaEnter(){
        Scanner sc = new Scanner(System.in);
        int enter = sc.nextInt();
        return enter;
    }
}
