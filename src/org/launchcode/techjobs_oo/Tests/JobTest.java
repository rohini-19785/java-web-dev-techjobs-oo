package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

import static org.junit.Assert.*;


public class JobTest {

    static Job job1, job2;
    static Job testAllFieldsConstructorJob;
    static Job testForEqualityJob1, testForEqualityJob2;
    static Job testForToStringJob;
    static Job testForToStringWithDataNotAvailableJob;
    static Job testForAllEmptyExceptIDJob;

    @BeforeClass
    public static void createObjects()
    {
        job1 = new Job();

        job2 = new Job();

        testAllFieldsConstructorJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        testForEqualityJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testForEqualityJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        testForToStringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        testForToStringWithDataNotAvailableJob = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        testForAllEmptyExceptIDJob = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
    }


    @Test
    public void testSettingJobId(){
        assertEquals(job2.getId(), job1.getId()+1);
        //fail("Test failed: the next job id should be incremented by 1");

        assertTrue(job2.getId()-job1.getId() == 1);
        assertFalse(job2.getId() == job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        //test job id
        assertEquals(3, testAllFieldsConstructorJob.getId());

        //test job name
        assertEquals("Product tester", testAllFieldsConstructorJob.getName());

        //test job employer
        assertTrue(testAllFieldsConstructorJob.getEmployer() instanceof Employer);
        assertEquals(testAllFieldsConstructorJob.getEmployer().getValue(), "ACME");

        //test job location
        assertTrue(testAllFieldsConstructorJob.getLocation() instanceof Location);
        assertEquals(testAllFieldsConstructorJob.getLocation().getValue(), "Desert");

        //test job PositionType
        assertTrue(testAllFieldsConstructorJob.getPositionType() instanceof PositionType);
        assertEquals(testAllFieldsConstructorJob.getPositionType().getValue(), "Quality control");

        //test job core competency
        assertTrue(testAllFieldsConstructorJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testAllFieldsConstructorJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testForEqualityJob1.getId() == testForEqualityJob2.getId());
    }

    @Test
    public void testJobToString(){
        System.out.println(testForToStringWithDataNotAvailableJob.toString());

        //Test Case 1: The output string should start and end with new line.
        assertTrue(testForToStringJob.toString().startsWith("\n") && testForToStringJob.toString().endsWith("\n"));

        //Test Case 2: The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
        assertEquals("\nID: 6\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", testForToStringJob.toString());

        //Test Case 3: If a field is empty, the method should add, “Data not available” after the label.
        assertEquals(testForToStringWithDataNotAvailableJob.toString(), "\nID: 7\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");

        //Test Case 4: (Bonus) If a Job object ONLY contains data for the id field, the method should return, "OOPS! This job does not seem to exist."
        //a. test with empty constructor job instance
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");

        //b. test with empty name and class instances of employer, position type, core competency
        assertEquals(testForAllEmptyExceptIDJob.toString(), "OOPS! This job does not seem to exist.");

    }
}


