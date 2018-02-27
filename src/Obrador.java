import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Obrador {

    public void creaCategoria(String nomCategoria){

            Config c = new ConfigImp();

            try {
                String ruta = c.getPathBiblioteca().toString().concat("/").concat(nomCategoria);
                File categoria = new File(ruta);
                categoria.mkdir();

            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public void creaInventari(){

        Config c = new ConfigImp();

        List<llibre> llista = llegeixLlibres();

        File invetari = c.getInventari();

        try{
            BufferedWriter brw = new BufferedWriter(new FileWriter(invetari));
            for (llibre ll : llista) {
                String linia = ll.getCategoria().concat("$").concat(ll.getTitol().concat("$").concat(ll.getNomAutor().concat("$").concat(ll.getEditorial())));
                brw.write(linia);
                brw.newLine();
            }
            brw.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public void llibresEnCategoria(String nomCategoria){
        Config c = new ConfigImp();

        List<llibre> llista = llegeixLlibres();
        int sortida = 0;

        for (llibre ll : llista) {
            if(ll.getCategoria().equals(nomCategoria)){
                System.out.println(ll.getTitol());
                sortida++;
            }
        }
        if(sortida==0){
            System.out.println(c.getMostraText_NoLlibreEnCat());
        }


    }


    public void buscaLlibre(String nomLlibre) {

        Config c = new ConfigImp();

        List<llibre> llista = llegeixLlibres();

        llibre ll = new llibreImpl();
        ll.setTitol(nomLlibre);

        boolean existeixLlibre = false;

        for(llibre l : llista){
            if(l.getTitol().equals(ll.getTitol()) && l.getCategoria()!=""){
                existeixLlibre = true;
                System.out.println(c.getMostraText_LlibreTrobat() + l.getCategoria());
            }else if((l.getTitol().equals(ll.getTitol()) && l.getCategoria()=="")) {
                existeixLlibre = true;
                System.out.println(c.getMostraText_LlibreTrobat() + "<no categoria>");
            }
        }

        if(!existeixLlibre){
            System.out.println(c.getMostraText_LlibreNoTrobat());

        }

    }


    public void mostraBibli() {
        Obrador o = new Obrador();

        List<llibre> llista = o.llegeixLlibres();

        System.out.println("------");
        for(llibre ll: llista){
            System.out.print("Categoria -> ");
            System.out.println(ll.getCategoria());
            System.out.print("títol: ");
            System.out.println(ll.getTitol());
            System.out.print("autor: ");
            System.out.println(ll.getNomAutor());
            System.out.print("editorial: ");
            System.out.println(ll.getEditorial());
            System.out.print('\n');
        }


    }

    /**
     * Mostra la biblioteca per categories
     *
     */
    public void mostraBibli_02() {
        Obrador o = new Obrador();

        List<llibre> llista = o.llegeixLlibres();

        String categoria = null;

        System.out.println("------");
        for(llibre ll: llista){

            if( ll.getCategoria().equals(categoria)) {

                System.out.print("títol: ");
                System.out.println(ll.getTitol());
                System.out.print("autor: ");
                System.out.println(ll.getNomAutor());
                System.out.print("editorial: ");
                System.out.println(ll.getEditorial());
                System.out.print('\n');
            }else{
                categoria=ll.getCategoria();
                System.out.print("Categoria ---> ");
                System.out.println(ll.getCategoria());
                System.out.print("títol: ");
                System.out.println(ll.getTitol());
                System.out.print("autor: ");
                System.out.println(ll.getNomAutor());
                System.out.print("editorial: ");
                System.out.println(ll.getEditorial());
                System.out.print('\n');
            }
        }


    }



    public List<llibre> llegeixLlibres(){

        List <llibre> lp = new LinkedList<llibre>();

        Config config = new ConfigImp();

        try {

            String ruta = config.getPathBiblioteca().toString();

            //Entra tots els llibres de l'arrel

            File rf = new File(ruta);
            File[] llista = rf.listFiles();

            //Itera per tots els llibres de l'arrel i s'adjunten al llistat
            for (File ff : llista) {
                if (ff.isFile()) {

                    llibre a = new llibreImpl();
                    BufferedReader bfr = new BufferedReader(new FileReader(ruta.concat("/").concat(ff.getName())));
                    bfr.readLine();
                    a.setTitol(bfr.readLine());
                    a.setNomAutor(bfr.readLine());
                    a.setEditorial(bfr.readLine());
                    a.setCategoria("");

                    lp.add(a);

                    bfr.close();

                } else {
                    //Si es un directori (una categoria) iterem el contingut
                    //de la carpeta i s'adjunta el contingut
                    File rrr = new File(ruta.concat("/").concat(ff.getName()));
                    File[] subLlista = rrr.listFiles();
                    for (File fff : subLlista) {

                        llibre a = new llibreImpl();
                        try {
                            BufferedReader bfr = new BufferedReader(new FileReader(fff.toString()));
                            bfr.readLine();
                            a.setTitol(bfr.readLine());
                            a.setNomAutor(bfr.readLine());
                            a.setEditorial(bfr.readLine());
                            a.setCategoria(rrr.getName().toString());
                            lp.add(a);
                            bfr.close();

                        }catch(NullPointerException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        //
        Collections.sort(lp);

        return lp;
    }



    public void creaArxiuAlaCategoria(File cat,String titol, String autor, String editorial){

        Config config = new ConfigImp();

        try {
            //Crea el fitxer:  categoria + / + nom
            String nomFitxer = cat.toString().concat("/").concat(titol);
            cat = new File (nomFitxer);
            cat.createNewFile();

            BufferedWriter bfr = new BufferedWriter(new FileWriter(cat));
            bfr.write("*** INICI DEL LLIBRE ***");
            bfr.newLine();
            bfr.write(titol);
            bfr.newLine();
            bfr.write(autor);
            bfr.newLine();
            bfr.write(editorial);
            bfr.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**El métode desplaca un llibre d'un origen a un destí.
     * El que fa es trobar es trobar el llibre i si existeix:
     * Copia el llibre en la categoria que se li passa per paràmetre.
     * Esborra el llibre de la categoria origen
     * @param nomLlibre Títol del llibre a cercar
     * @param catDesti Categoria on s'ha d'ubicar
     */
    public void mouLlibre(String nomLlibre, String catDesti) {

        Config config = new ConfigImp();

        //Es construeix la ruta del desti
        String rutaDesti = ((config.getPathBiblioteca().toString()).concat("/").concat(catDesti));
        File categoria = new File (rutaDesti);

        List<llibre> llista = llegeixLlibres();

        for (llibre ll : llista) {
            if(nomLlibre.equals(ll.getTitol())){

                //CreaElLlibre
                creaArxiuAlaCategoria(categoria,ll.getTitol(), ll.getNomAutor(), ll.getEditorial());

                //EsborraElLlibre
                File arxiuOrigen = new File(config.getPathBiblioteca().toString().concat("/").concat(ll.getCategoria().concat("/").concat(nomLlibre)));
                arxiuOrigen.delete();
            }
        }
    }

    public void mostraAtributsLlibre(String nomLlibre) {

        Config config = new ConfigImp();

        List <llibre> llista = llegeixLlibres();

        boolean existeix = false;

        for (llibre ll: llista) {
            if(ll.getTitol().equals(nomLlibre)){
                existeix = true;
                System.out.print("autor: ");
                System.out.println(ll.getNomAutor());
                System.out.print("editorial: ");
                System.out.println(ll.getEditorial());
                System.out.print('\n');
            }
        }
        if(!existeix){
            System.out.println(config.getMostraText_LlibreNoTrobat());
        }
    }
}
