package com.bext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Datos {

    List<String> listNombres = new ArrayList<>();
    String[] arrNombres;
    String nombresjuntos = "Álan 	Jacinto Martinez Alicia 	Jesús 	Mirta Andrea 	Josefina 	Mónica " +
    "Andrés 	Juan 	Nicolás   Antonia 	Juana 	Noé    Antonio 	Juano 	Noelia    Azul 	Julia 	Paula " +
    "Bartolomé 	Julián 	Pomponio  Belén 	Juliana 	Renzo   Celeste 	Julio 	Rodrigo " +
    "Edgardo 	Leandra 	Rodriguez    Felicia 	Luis 	Romina     Florencia 	Luisa 	Rosario" +
    "Gaspar 	Marcelo 	Tato   Gerardo 	Marcos 	Tomás   Gimenez 	María 	Victor   Gonzalo 	Mariano 	Yayo "+
    "Gustavo 	Martín 	Zulema";
    String colores = "Rojo Naranga Amarillo Verde Azul Índigo Violeta";
    String[] arrColores;
    List<String> listColores = new ArrayList<>();

    public Datos() {
        StringTokenizer stoken = new StringTokenizer( nombresjuntos);
        //System.out.println( "stoken.countTokens(): " + stoken.countTokens());
        arrNombres = new String[ stoken.countTokens()];
        int i = 0;
        StringBuilder element = new StringBuilder();

        //System.out.println("Tokens");
        while( stoken.hasMoreTokens()){
            element.setLength(0); element.append( stoken.nextToken());
            //System.out.print( element + ", ");
            arrNombres[ i++ ] = element.toString();
        }
        //System.out.println();

        listNombres = Arrays.asList( arrNombres);
        // Display the filled String[] using Arrays.stream
        //Arrays.stream(arrNombres).forEach(s -> System.out.print(s + " "));

        stoken = new StringTokenizer( colores );
        arrColores = new String[ stoken.countTokens()];

        while(stoken.hasMoreTokens()){
            listColores.add( stoken.nextToken());
        }
        arrColores = listColores.toArray( arrColores);
        //Arrays.stream(arrColores).forEach(s -> System.out.println(s + " "));
    }
};



