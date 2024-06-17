package be.vives.ti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 */
public class AnimalMonitor {
    // Records of all the sightings of animals.
    private List<Sighting> sightings;

    public AnimalMonitor() {
        addSightings();
    }

    private void addSightings() {
        this.sightings = Arrays.asList(
                new Sighting("Mountain Gorilla", 0, 3, 1, 0, Arrays.asList("savanna", "grassland")),
                new Sighting("Buffalo", 0, 10, 1, 0, Arrays.asList("jungle", "forest", "waterfall")),
                new Sighting("Elephant", 0, 0, 1, 0, Arrays.asList("jungle")),
                new Sighting("Mountain Gorilla", 1, 1, 2, 0, Arrays.asList("savanna", "grassland")),
                new Sighting("Mountain Gorilla", 2, 3, 3, 0, Arrays.asList("grassland")),
                new Sighting("Mountain Gorilla", 3, 0, 2, 0, Arrays.asList("savanna")),
                new Sighting("Buffalo", 3, 2, 1, 0, Arrays.asList("grassland", "forest", "waterfall")),
                new Sighting("Topi", 3, 25, 1, 0, Arrays.asList("grassland", "waterfall")),

                new Sighting("Mountain Gorilla", 0, 4, 1, 1, Arrays.asList("savanna", "grassland")),
                new Sighting("Buffalo", 0, 16, 1, 1, Arrays.asList("jungle", "forest", "savanna")),
                new Sighting("Topi", 1, 20, 1, 1, Arrays.asList("jungle", "forest", "waterfall")),
                new Sighting("Buffalo", 3, 0, 2, 1, Arrays.asList("forest", "waterfall")),
                new Sighting("Topi", 3, 30, 2, 1, Arrays.asList("savanna")),

                new Sighting("Mountain Gorilla", 0, 1, 1, 2, Arrays.asList("jungle", "forest")),
                new Sighting("Mountain Gorilla", 1, 2, 2, 2, Arrays.asList("savanna", "grassland")),
                new Sighting("Mountain Gorilla", 2, 0, 3, 2, Arrays.asList("jungle", "forest")),
                new Sighting("Topi", 3, 30, 2, 2, Arrays.asList("jungle")),
                new Sighting("Elephant", 3, 24, 2, 2, Arrays.asList("grassland"))
        );
    }

    /**
     * Print details of all the sightings.
     */
    public void printList() {
        // TODO: herwerk met forEach
//        for (Sighting record : sightings) {
//            System.out.println(record.toString());
//        }

        sightings.stream()
                .forEach(System.out::println);
    }

    /**
     * Print the details of all the sightings of the given animal.
     *
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal) {

        sightings.stream()
                .filter(a -> a.getAnimal().equals(animal))
                .forEach(System.out::println);
    }

    /**
     * Print all the sightings by the given spotter.
     *
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter) {

        sightings.stream()
                .filter(a -> a.getSpotter() == spotter)
                .forEach(System.out::println);
    }

    /**
     * Return a list of all the sightings of the given animal.
     *
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public List<Sighting> getSightingsOf(String animal) {

        return sightings.stream()
                .filter(a -> a.getAnimal().equals(animal))
                .toList();

    }

    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     *
     * @param animal The type of animal.
     * @param area   The ID of the area.
     * @return A list of sightings.
     */
    public List<Sighting> getSightingsInArea(String animal, int area) {

        return sightings.stream()
                .filter(a -> a.getAnimal().equals(animal))
                .filter(b -> b.getArea() == area)
                .toList();
    }

    /**
     * Return a count of the number of sightings of the given animal.
     *
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int count(String animal) {


        return sightings.stream()
                .filter(a -> a.getAnimal().equals(animal))
                .reduce(0, (total,a ) -> total + a.getCount(), Integer::sum);


    }

    /**
     * Print a list of the types of animal considered to be endangered.
     *
     * @param animalNames     A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(List<String> animalNames, int dangerThreshold) {
        // TODO: zet om naar streams 
//        for (String animal : animalNames) {
//            if (count(animal) <= dangerThreshold) {
//                System.out.println(animal + " is endangered.");
//            }
//        }

        animalNames.stream()
                .filter(a -> count(a) <= dangerThreshold)
                .map(b -> b + " is endangered.")
                .forEach(System.out::println);
    }

    /**
     * Return a list of all unique animal names (in uppercase!) by the given spotter.
     *
     * @param spotter
     */
    public List<String> getUniqueAnimalNamesBySpotter(int spotter) {
        // TODO: zet om naar streams
//        List<String> names = new ArrayList<>();
//        for (Sighting record : sightings) {
//            if (record.getSpotter() == spotter) {
//                String name = record.getAnimal().toUpperCase();
//                if(!names.contains(name)) {
//                    names.add(name);
//                }
//            }
//        }

        return sightings.stream()
                .filter(a -> a.getSpotter() == spotter)
                .map(b -> b.getAnimal().toUpperCase())
                .distinct()
                .toList();

    }

    /**
     * Return a list of all sightings order by the areaId
     * @return
     */
    public List<Sighting> getSightingsOrderByArea(){
//        // TODO: zet om naar streams - gebruik de comparing() statische methode
//        ArrayList<Sighting> copy = new ArrayList<>(sightings);
//
//        copy.sort(new Comparator<Sighting>() {
//            @Override
//            public int compare(Sighting o1, Sighting o2) {
//                return o1.getArea() - o2.getArea();
//            }
//        });
//
//        return copy;

        return sightings.stream()
                .sorted(Comparator.comparingInt(Sighting::getArea))
                .collect(Collectors.toList());
    }

    /**
     * Return a list of first X unique animal names in a certain area
     * The list of animal names is sorted in alphabetical order
     *
     * @param area
     * @param x
     */
    public List<String> getFirstXAlphabeticOrderedUniqueAnimalNameForArea(int area, int x){
//        // TODO: zet om naar streams
//        List<String> names = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            if(sighting.getArea() == area){
//                String name = sighting.getAnimal();
//                if(!names.contains(name)) {
//                    names.add(name);
//                }
//            }
//        }
//
//
//        names.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        return sightings.stream()
                .filter(a -> a.getArea() == area)
                .map(Sighting::getAnimal)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .limit(x)
                .collect(Collectors.toList());

//        List<String> result = new ArrayList<>();
//        for (int i = 0; i<names.size() && i < x; i++){
//            String name = names.get(i);
//            result.add(name);
//        }
//        return result;
    }

    public boolean checkIfThereIsASightingOfAnimalWithMoreThan20counts(String animalName){
        // TODO: zet om naar streams - zet niet terug om naar een Collection om te bepalen of die wel of niet leeg is

//        for (Sighting sighting : sightings) {
//            if (animalName.equals(sighting.getAnimal())) {
//                if(sighting.getCount() > 20){
//                    return true;
//                }
//            }
//        }
//        return false;
//
        return sightings.stream()
                .filter(a-> a.getAnimal().equals(animalName))
                .anyMatch(a -> a.getCount() > 20);

    }

    /**
     * Return a list of all the unique habitats
     */
    public List<String> getAllUniqueHabitats(){
        // TODO: zet om naar streams
//
//        List<String> allHabitats = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            for (String habitat : sighting.getHabitats()) {
//                if(!allHabitats.contains(habitat)) {
//                    allHabitats.add(habitat);
//                }
//            }
//        }
//        return allHabitats;

        List<String> allHabitats =  sightings.stream()
                .flatMap(s -> s.getHabitats().stream())
                .distinct()
                .toList();

        return allHabitats;
    }


    /**
     * get all sightings that happen in more than one habitat
     */
    public List<Sighting> getAllSightingsThatHappenInMoreThanOneHabitat(){
//        // TODO: zet om naar streams
//
//        List<Sighting> sightingsInMultipleHabitats = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            int count = sighting.getHabitats().size();
//            if(count > 1){
//                sightingsInMultipleHabitats.add(sighting);
//            }
//        }
//        return sightingsInMultipleHabitats;

        return sightings.stream()
                .filter(a -> a.getHabitats().size() > 1)
                .collect(Collectors.toList());
    }

    /**
     * get all habitats where an animal is spotted more than 5 times, ordered by name of the habitat
     *
     * @param animal The type of animal.
     */
    public List<String> getAllHabitatsWhereAnAnimalIsSpottedMoreThan5TimesOrderedByName(String animal){
        // TODO: zet om naar streams

//        List<String> habitats = new ArrayList<>();
//        for (Sighting sighting : sightings) {
//            if (sighting.getAnimal().equals(animal)) {
//                if (sighting.getCount() > 5) {
//                    for (String habitat : sighting.getHabitats()) {
//                        if(!habitats.contains(habitat)) {
//                            habitats.add(habitat);
//                        }
//                    }
//                }
//            }
//        }
//
        return  sightings.stream()
                .filter(a -> a.getAnimal().equals(animal))
                .filter(b -> b.getCount() > 5)
                .flatMap(a -> a.getHabitats().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

//        habitats.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        return habitats;
    }

    /**
     * Check if there are sightings by a spotter in a particular habitat
     * @param spotter
     * @param habitat
     * @return
     */
    public boolean isThereASightingByASpotterInAParticularHabitat(int spotter, String habitat){
        // TODO: zet om naar streams



        return sightings.stream()
                .filter(a -> a.getSpotter() == spotter)
                .anyMatch(a -> a.getHabitats().contains(habitat));
    }

    /**
     * return the maximum number of animals spotted in 1 sighting
     * @return maximum number of animals spotted in 1 sighting
     */
    public int maxNumberOfAnimalSpottedIn1Sighting(String animal){
        // TODO: zet om naar streams

//        int max = -1;
//        for (Sighting sighting : sightings) {
//            if(sighting.getAnimal().equals(animal)){
//                if(max < sighting.getCount()){
//                    max = sighting.getCount();
//                }
//            }
//        }
//        return max;

        return sightings.stream()
                .filter(s -> s.getAnimal().equals(animal))
                .mapToInt(a -> a.getCount())
                .max()
                .orElse(-1);
    }



}
