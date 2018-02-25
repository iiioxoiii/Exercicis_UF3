import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Obrador {

    public void creaCategoria(String nomCategoria){

    }


    public void creaInventari(){

    }


    public void llibresEnCategoria(String nomCategoria){

    }

    public boolean llibreTrobat(File directori) {

        boolean trobat = false;

        return trobat;
    }


    public void buscaLlibre(String nomLlibre){

    }


    public void mostraBibli() {
        Obrador o = new Obrador();

        List<llibre> llista = o.llegeixLlibres();

        System.out.println("------");
        for(llibre ll: llista){
            System.out.print("Categoria-> ");
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
                    BufferedReader bfr = new BufferedReader(new FileReader(ruta));
                    bfr.readLine();
                    a.setTitol(bfr.readLine());
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
                        BufferedReader bfr = new BufferedReader(new FileReader(fff.toString()));
                        bfr.readLine();
                        a.setTitol(bfr.readLine());
                        a.setNomAutor(bfr.readLine());
                        a.setEditorial(bfr.readLine());
                        a.setCategoria(rrr.getName().toString());

                        lp.add(a);

                        bfr.close();
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
}
