package be.vives.ti;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        AnimalMonitor am = new AnimalMonitor();
        System.out.println(" ----------------- printlist");
        am.printList();
        System.out.println(" ----------------- printSightingsOf - Buffalo");
        am.printSightingsOf("Buffalo");
        System.out.println(" ----------------- printSightingsOf - 1");
        am.printSightingsBy(1);
        System.out.println(" ----------------- printEndagered - Buffalo-Elephant - 25");
        ArrayList<String> namenlijst = new ArrayList<>(Arrays.asList("Buffalo", "Elephant"));
        am.printEndangered(namenlijst, 25);
        System.out.println(" ----------------- getCount - elephant");
        System.out.println(am.count("Elephant"));
        System.out.println(" ----------------- getSightingsInArea - Buffalo - 2");
        System.out.println(am.getSightingsInArea("Buffalo", 2));
        System.out.println(" ----------------- getSightingsOf - buffalo");
        System.out.println(am.getSightingsOf("Buffalo"));
        System.out.println(" ----------------- animalNamesBySpotterInUpperCase - 1");
        System.out.println(am.getUniqueAnimalNamesBySpotter(1));
        System.out.println(" ----------------- sightingsSortedByArea");
        System.out.println(am.getSightingsOrderByArea());
        System.out.println(" ----------------- getFirstXAlphabeticOrderedUniqueAnimalNameForArea - 1 | x = 3");
        System.out.println(am.getFirstXAlphabeticOrderedUniqueAnimalNameForArea(1, 3));
        System.out.println(" ----------------- checkIfThereIsASightingOfAnimalWithMoreThen20counts - Elephant");
        System.out.println(am.checkIfThereIsASightingOfAnimalWithMoreThan20counts("Elephant"));
        System.out.println(" ----------------- checkIfThereIsASightingOfAnimalWithMoreThen20counts - Buffalo");
        System.out.println(am.checkIfThereIsASightingOfAnimalWithMoreThan20counts("Buffalo"));
        System.out.println(" ----------------- getAllUniqueHabitats");
        System.out.println(am.getAllUniqueHabitats());
        System.out.println(" ----------------- getAllSightingsThatHappenInMoreThanOneHabitat");
        System.out.println(am.getAllSightingsThatHappenInMoreThanOneHabitat());
        System.out.println(" ----------------- getAllHabitatsWhereAnAnimalIsSpottedMoreThan50TimesOrderedByName - Elephant");
        System.out.println(am.getAllHabitatsWhereAnAnimalIsSpottedMoreThan5TimesOrderedByName("Elephant"));
        System.out.println(" ----------------- getAllHabitatsWhereAnAnimalIsSpottedMoreThan50TimesOrderedByName - Buffalo");
        System.out.println(am.getAllHabitatsWhereAnAnimalIsSpottedMoreThan5TimesOrderedByName("Buffalo"));
        System.out.println(" ----------------- isThereASightingByASpotterInAParticularHabitat(1, jungle)");
        System.out.println(am.isThereASightingByASpotterInAParticularHabitat(1, "jungle"));
        System.out.println(" ----------------- isThereASightingByASpotterInAParticularHabitat(2, savanna)");
        System.out.println(am.isThereASightingByASpotterInAParticularHabitat(2, "savanna"));
        System.out.println(" ----------------- maxNumberOfBuffaloSpottedIn1Sighting");
        System.out.println(am.maxNumberOfAnimalSpottedIn1Sighting("Buffalo"));
        System.out.println(" ----------------- maxNumberOfGruffaloSpottedIn1Sighting");
        System.out.println(am.maxNumberOfAnimalSpottedIn1Sighting("Gruffalo"));
    }
}
