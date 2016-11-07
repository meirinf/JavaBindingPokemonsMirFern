import generated.NombreType;
import generated.PokedexType;
import generated.PokemonType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;
/**
 * Created by 53638138e on 03/11/16.
 */
public class MainPokemon {

    private static File f1 = new File("pokemons.xml");
    public static void main(String[] args) throws JAXBException {

        //Esto genera el lector del teclado
        Scanner teclat = new Scanner (System.in);
        int opcio = 1;

        while (opcio != 0) {
            System.out.println("1 - Añadir Pokemon");
            System.out.println("2 - Mostrar Resumen");

            opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
                    AfegirPokemon();
                    break;
                case 2:
                    MostrarResum();
                    break;
                default:
                    System.out.println("Ha seleccionat una opcio incorrecta");
                    break;
            }
        }

    }

    //ESte metodo añade un Pokemeon al xml
    //para generar los type he utilizado el comando xjc pokemons.xsd
    private static void AfegirPokemon() throws JAXBException {

        //variables
        Scanner teclat = new Scanner(System.in);

        try {

            //Metodo para añadir por pantalla
            System.out.println("Añadiremos Un nuevo Pokemon");
            PokemonType poke = new PokemonType();
            NombreType nombreType = new NombreType();

            //se saca el nombre y la clase de nombre type
            System.out.println("Nombre del pokemon");
            nombreType.setValue(teclat.nextLine());
            System.out.println("Clase del pokemon");
            nombreType.setClasse(teclat.nextLine());


            //El resto se saca de Pokemon type
            poke.setNombre(nombreType);
            System.out.println("Ataque 1");
            poke.setAtaque1(teclat.nextLine());
            System.out.println("Ataque 2");
            poke.setAtaque2(teclat.nextLine());
            System.out.println("Etapa");
            poke.setEtapa(teclat.nextLine());

            // llamamos al contexto
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);
            Unmarshaller um = context.createUnmarshaller();
            PokedexType pokedex =  (PokedexType)um.unmarshal(f1);

            //Añadimos a pokedex
            pokedex.getPokemon().add(poke);

            //llamamos al metodo Guardar
           guardar(pokedex);
        }
        catch (JAXBException e){    //Controlem les posibles exepcions
            e.printStackTrace();
        }



    }
    //Aqui se muestra el xml en modo resumen
    private static void MostrarResum() throws JAXBException{
        System.out.println(""); //Linea d'espai estetica

        try{
            //Creamos nuestra pokedex
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);
            Unmarshaller UMS = context.createUnmarshaller();
            PokedexType pokedex = (PokedexType) UMS.unmarshal(f1);

            //Imprimimos los Pokemons
            System.out.println(pokedex.getPokemon().size());
            System.out.println("-----------------");

            for (int iterador = 0; iterador < pokedex.getPokemon().size(); iterador++){
                System.out.println(iterador + 1 + " -  " + pokedex.getPokemon().get(iterador).getNombre().getValue());
            }
        }
        catch (JAXBException e){
            e.printStackTrace();
        }

    }
    private static void guardar( PokedexType pokedex) throws JAXBException {

        try{
            JAXBContext context = JAXBContext.newInstance(PokedexType.class);
            Marshaller MS = context.createMarshaller();
            MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MS.marshal(pokedex, f1);
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
    }

}

