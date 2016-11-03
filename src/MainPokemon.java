import generated.NombreType;
import generated.PokedexType;
import generated.PokemonType;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;
/**
 * Created by 53638138e on 03/11/16.
 */
public class MainPokemon {
    public static void main(String[] args) throws JAXBException {

        //Esto genera el lector del teclado
        Scanner teclat = new Scanner (System.in);
        int opcion = 2;
        int caso  =  0;
        System.out.println("Añadir Pokemon   => 1");
        System.out.println("Añadir Mostrar Resumen => 2");
        caso = teclat.nextInt();

        switch (opcion) {
            case 1:  caso = 1;
                AfegirPokemon();
                break;
            case 2:  caso = 2;
                MostrarResum();
                break;
        }
        System.out.println("Has elegido "+caso);
    }

    //ESte metodo añade un Pokemeon al xml
    private static void AfegirPokemon() {
        //variables
        Scanner teclat = new Scanner(System.in);
        File f1 = new File("pokemons.xml");


        //Metodo para añadir por pantalla
        System.out.println("Añadiremos Un nuevo Pokemon");
        PokemonType poke = new PokemonType ();
        NombreType nombreType= new NombreType();


        System.out.println("Nombre del pokemon");
        nombreType.setValue(teclat.nextLine());
        System.out.println("Clase del pokemon");
        nombreType.setClasse(teclat.nextLine());

        poke.setNombre(nombreType);

        

        //System.out.println("Autor");
        // info = teclat.next();
        // l2.setAutor(info);
        // System.out.println("Fecha del libro");
        //info = teclat.next();
        //l2.setTitulo(info);


    }
    //Aqui se muestra el xml en modo resumen
    private static void MostrarResum() {

    }

}

