package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

import static org.junit.Assert.*;


public class JobTest {

    Job job1, job2;
    Job testAllFieldsConstructorJob;
    Job testForEqualityJob1, testForEqualityJob2;

    @Before
    public void createObjects()
    {
        job1 = new Job();
        job2 = new Job();

        testAllFieldsConstructorJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        testForEqualityJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testForEqualityJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

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

        //test job PostionType
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
}


