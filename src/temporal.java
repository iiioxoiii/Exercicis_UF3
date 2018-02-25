import sun.awt.dnd.SunDropTargetEvent;

import java.io.File;

public class temporal {
    public static void main(String[] args) {
        Config b = new ConfigImp();

        File ff = new File (b.getPathBiblioteca().toString());

        if (b.getPathBiblioteca().exists()){
            System.out.println(ff.exists());
            System.out.println(ff.isFile());
            System.out.println(ff.isDirectory());

            System.out.println(ff.getAbsolutePath());
        }

    }
}
