package be.vives.ti;

import java.util.List;

public class Sighting
{
    private final String animal;
    private final int spotter;
    private final int count;
    private final int area;
    private final int period;
    private final List<String> habitats;

    public Sighting(String animal, int spotter, int count, int area, int period, List<String> habitats)
    {
        this.animal = animal;
        this.spotter = spotter;
        this.count = count;
        this.area = area;
        this.period = period;
        this.habitats = habitats;
    }

    public String getAnimal()
    {
        return animal;
    }

    public int getSpotter()
    {
        return spotter;
    }

    public int getCount()
    {
        return count;
    }

    public int getArea()
    {
        return area;
    }

    public int getPeriod() {
        return period;
    }

    public List<String> getHabitats() {
        return habitats;
    }

    public String toString()
    {
        return animal +
                ", count = " + count +
                ", area = " + area +
                ", spotter = " + spotter +
                ", period = " + period +
                ", habitats = " + habitats;
    }

}
