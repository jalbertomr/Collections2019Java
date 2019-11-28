package com.bext;

import java.text.Normalizer;
import java.util.*;
import java.util.function.BiConsumer;

public class HashMapLab {

    public HashMapLab() {
        HashMap<String, Integer> hashMapColor = new HashMap<>();

        String colores = "Rojo Naranga Amarillo Verde Azul Índigo Violeta";  //orden del arcoiris

        System.out.println(colores);
        StringTokenizer stringTokenizer = new StringTokenizer(colores);
        int i = 1;
        while (stringTokenizer.hasMoreTokens()) {
            hashMapColor.put(stringTokenizer.nextToken(), new Integer(i++));
        }

        //display hashMap
        hashMapColor.entrySet().stream()
                .map(s -> String.format("|%" + 10 + "s|", s))
                .forEach(s -> System.out.print(s));
        System.out.println();

        //display hashMap using BiConsumer
        hashMapColor.forEach((k, v) -> System.out.print(String.format("|%" + 10 + "s", k) + ":" + v + "|"));
        System.out.println();

        // TreeMap (alphabetic order) Order)
        System.out.println("TreeMap");
        Map<String, Integer> alphaOrderColor = new TreeMap<>();
        stringTokenizer = new StringTokenizer(colores);
        i = 1;
        while (stringTokenizer.hasMoreTokens()) {
            alphaOrderColor.put(stringTokenizer.nextToken(), new Integer(i++));
        }

        alphaOrderColor.forEach((k, v) -> System.out.print(String.format("|%" + 10 + "s", k) + ":" + v + "|"));
        System.out.println();

        System.out.println("TreeMap order without accent");
        Map<String, Integer> alphawithoutAccentOrderColor = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return removeAccents(o1).compareTo(removeAccents(o2));
            }
        });

        stringTokenizer = new StringTokenizer(colores);
        i = 1;
        while (stringTokenizer.hasMoreTokens()) {
            alphawithoutAccentOrderColor.put(stringTokenizer.nextToken(), new Integer(i++));
        }

        alphawithoutAccentOrderColor.forEach((k, v) -> System.out.print(String.format("|%" + 10 + "s", k) + ":" + v + "|"));
        System.out.println();

        // lambda y constructor TreeMap
        System.out.println("TreeMap order without accent Lambda in TreeMap constructor");
        Map<String, Integer> valueOrderLambdaColor = new TreeMap<>((o1, o2) -> removeAccents(o1).compareTo(o2));
        //Map<String, Integer> valueOrderLambdaColor = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        stringTokenizer = new StringTokenizer(colores);
        i = 1;
        while (stringTokenizer.hasMoreTokens()) {
            valueOrderLambdaColor.put(stringTokenizer.nextToken(), new Integer(i++));
        }

        valueOrderLambdaColor.forEach((k, v) -> System.out.print(String.format("|%" + 10 + "s", k) + ":" + v + "|"));
        System.out.println();

        List<Map.Entry<String, Integer>> listSortbyValue;
        System.out.println("Map sorted by Value");
        listSortbyValue = sortMapByValue(valueOrderLambdaColor);
        listSortbyValue.stream().forEach(e -> System.out.print(String.format("|%" + 10 + "s", e.getKey()) + ":" + e.getValue() + "|"));

        Map<String, List<String>> sinonimos = new TreeMap<>();

/*
        witty "amusing, humorous, funny, clever, facetious, smart, entertaining, whimsical, jokey, jocular, droll, comedic"
        joker "comic, clown, comedian, funnyman"
        slum "ghetto , hood (Slang), skid row, shanty town, the wrong side of the tracks (informal), poor neighborhood"
                sloopy "disordered, disorderly, cluttered, disarranged, unkempt, disheveled"
        stink "stench , reek, funk , odor, odour (UK), smell , bad smell, bad odor"

        preclude "prevent , stave off, head off, ward off, avert , avoid , negate, neutralize"
        nuance "subtlety, distinction , difference , fine point, shade"
        weild "exercise , exert , apply , ply, use , effect , command , control , manage"
        fate "luck , chance , fortune , happenstance (mainly US), good luck, bad luck, misfortune, good fortune, bad fortune"
                apalled shock , amaze, horrify, dismay , surprise , disgust, offend, cause offense
        cripping disabled person, handicapped person (dated), the handicapped (dated), the disabled, amputee, paraplegic
                tenant renter, lessee, rent payer, lodger, boarder, leaseholder, holder
        rift fissure, split , crack , break , fracture, hole , tear , gap
                hail barrage , torrent, deluge, shower , salvo, volley, battery
        relay communicate , pass on, pass along, convey , send , deliver , forward , transmit, transfer , circulate


    squeaking squeal , shrill sound, shrill cry, narrow escape
    wee small , tiny , infinitesimal, little , minute , negligible
        screech shriek , yell , outcry , cry , scream , howl , wail

    swooping plunge , fall , drop , descent , dive , chute, slide
    warfare combat, war , conflict , armed conflict, hostilities, fighting
    meek subdued , weak , yielding, docile, submissive, compliant , resigned
    invoice bill , itemized bill, tab (informal), request for payment, bill of account
    relinquish give up, surrender , give away, renounce, abandon , waive , hand over, get rid of, shed
*/

    }

    private List<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> elements = new LinkedList<>( map.entrySet());
        Collections.sort( elements, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return elements;
    }

    private Map<String, Integer> countWords( List<String> words) {
        Map<String, Integer> mapWordCount = new TreeMap<>();
        for (String word: words) {
            if ( mapWordCount.containsKey( word)){
                int count = mapWordCount.get(word) + 1;
                mapWordCount.put( word, count);
            } else {
                mapWordCount.put( word, 1);
            }
        }
        return mapWordCount;
    }

    public  static String removeAccents(String text) {
        return text == null ? null : Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCOMBINING_DIACRITICAL_MARKS}+","");
    }

    private void displayKVformatted(String k, Integer v) {
        String str = String.format("%" + 10 + "s", k);
        System.out.println( str + " " + v);
    }

    //System.out.print( String.format("|%" + 10 + "k|", k.toString()) + " " + v)
}
