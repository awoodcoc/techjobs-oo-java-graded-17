package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    // Test 1: Test that asserts the IDs of two jobs are not equal
    @Test
    public void testSettingJobId(){
    Job job1 = new Job("Scrum Master", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Full Time"), new CoreCompetency("Attention to Detail"));
    Job job2 = new Job("Java Engineer", new Employer("NASA"), new Location("Florida"), new PositionType("Part Time"), new CoreCompetency("Flexibility"));
    assertNotEquals(job1.getId(), job2.getId());
    }

    // Test 2: Test that assets the job constructor sets all fields correctly, both values and classes
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    /* Test 3: Test the equals method that compares IDs, which should be different
    despite the Job class having all the same fields otherwise */
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Web Designer", new Employer("Vogue"), new Location("New York City"), new PositionType("Team Leader"), new CoreCompetency("JavaScript"));
        Job job2 = new Job("Web Designer", new Employer("Vogue"), new Location("New York City"), new PositionType("Team Leader"), new CoreCompetency("JavaScript"));
        assertFalse(job1.equals(job2));
    }
}
