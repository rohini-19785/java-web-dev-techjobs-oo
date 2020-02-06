package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Location extends JobField{

    public Location() {
        super();
    }

    // TODO: Add a constructor that takes a string as a parameter and assigns it to the 'value' field. The
    //  constructor should also call the empty constructor in order to initialize the 'id' field.

    public Location(String aValue){
        super(aValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;
        return getId() == location.getId();

    }

}
