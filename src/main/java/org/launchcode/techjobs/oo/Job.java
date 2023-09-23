package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // Constructor that assigns new unique updated ID
    public Job(){
        id = nextId;
        nextId++;
    }

    // Constructor that initializes the five fields and includes new ID constructor
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // Casting
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    // GETTER FOR id
    public int getId(){
        return id;
    }

    // GETTERS AND SETTERS FOR name, employer, location, positionType, coreCompetency
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // TODO: Create custom toString method for TDD Task
    @Override
    public String toString() {
        // Line breaks
        // String newline = System.lineSeparator();

        // Ternary operators for fields
        String jobName = ((name != null && !name.isEmpty()) ? name : "Data not available");
        String jobEmployer = ((employer.getValue() != null && !employer.getValue().isEmpty()) ? employer.getValue() : "Data not available");
        String jobLocation = ((location.getValue() != null && !location.getValue().isEmpty()) ? location.getValue() : "Data not available");
        String jobPositionType = ((positionType.getValue() != null && !positionType.getValue().isEmpty()) ? positionType.getValue() : "Data not available");
        String jobCoreCompetency = ((coreCompetency.getValue() != null && !coreCompetency.getValue().isEmpty()) ? coreCompetency.getValue() : "Data not available");

        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + jobName + System.lineSeparator() +
                "Employer: " + jobEmployer + System.lineSeparator() +
                "Location: " + jobLocation + System.lineSeparator() +
                "Position Type: " + jobPositionType + System.lineSeparator() +
                "Core Competency: " + jobCoreCompetency +
                System.lineSeparator();
    }
}
