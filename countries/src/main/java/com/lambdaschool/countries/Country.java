package com.lambdaschool.countries;

public class Country
{
    private String name;
    private int population;
    private long landMass;
    private int medianAge;

    public Country(String name, int population, long landMass, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }
    public Country(Country toClone)
    {
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medianAge = toClone.getMedianAge();
    }
    public String getName()
    {
        return name;
    }

    public int getPopulation()
    {
        return population;
    }

    public long getLandMass()
    {
        return landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}