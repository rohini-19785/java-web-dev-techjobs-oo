package org.launchcode.techjobs_oo;

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

    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType= aPositionType;
        this.coreCompetency = aCoreCompetency;

    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer(){
        return this.employer;
    }
    public void setEmployer(Employer aEmployer){
        this.employer = aEmployer;
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

    @Override
    public String toString() {

        String jobName = this.name;
        if(jobName==null ||jobName.isBlank()==true)
        {
            jobName="Data not available";
        }

        String jobEmployerValue = "Data not available";
        Employer jobEmployer = this.employer;

        if(jobEmployer!=null && jobEmployer.getValue()!=null&& jobEmployer.getValue().isBlank() == false)
        {
            jobEmployerValue = jobEmployer.getValue();
        }

        String jobLocationValue = "Data not available";
        Location jobLocation = this.location;

        if(jobLocation!=null && jobLocation.getValue()!=null&& jobLocation.getValue().isBlank() == false)
        {
            jobLocationValue = jobLocation.getValue();
        }

        String jobPositionTypeValue = "Data not available";
        PositionType jobPositionType = this.positionType;

        if(jobPositionType!=null && jobPositionType.getValue()!=null&& jobPositionType.getValue().isBlank() == false)
        {
            jobPositionTypeValue = jobPositionType.getValue();
        }

        String jobCoreCompetencyValue = "Data not available";
        CoreCompetency jobCoreCompetency = this.coreCompetency;

        if(jobCoreCompetency!=null && jobCoreCompetency.getValue()!=null&& jobCoreCompetency.getValue().isBlank() == false)
        {
            jobCoreCompetencyValue = jobCoreCompetency.getValue();
        }

        if(jobName.equals("Data not available")
                && jobEmployerValue.equals("Data not available")
                && jobLocationValue.equals("Data not available")
                && jobPositionTypeValue.equals("Data not available")
                && jobCoreCompetencyValue.equals("Data not available"))
        {
            return "OOPS! This job does not seem to exist.";
        }

        return "\n" +
                "ID: " + id +
                "\nName: " +  jobName +
                "\nEmployer: " + jobEmployerValue +
                "\nLocation: " + jobLocationValue +
                "\nPosition Type: " + jobPositionTypeValue +
                "\nCore Competency: " + jobCoreCompetencyValue +
                "\n";
    }
}

