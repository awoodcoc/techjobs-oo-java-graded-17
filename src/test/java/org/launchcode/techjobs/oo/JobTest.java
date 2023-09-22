package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;
import static java.lang.System.lineSeparator;

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

    // Test 4: TDD to test toString method that begins and ends with a new line
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("PR Specialist", new Employer("Edelman PR"), new Location("Chicago"), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        // String newline = lineSeparator();
        assertEquals(System.lineSeparator(), job1.toString().substring(0,1));
        assertEquals(System.lineSeparator(), job1.toString().substring(job1.toString().length() - 1));
    }

    // Test 5: TDD to test toString method that contains the correct labels and data
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("PR Specialist", new Employer("Edelman PR"), new Location("Chicago"), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        // Label test checks
        String idLabel = "ID";
        String nameLabel = "Name:";
        String employerLabel = "Employer:";
        String locationLabel = "Location";
        String positionTypeLabel = "Position Type:";
        String coreCompetencyLabel = "Core Competency:";

        // Value test checks
        int idValue = job1.getId();
        String nameValue = "PR Specialist";
        String employerValue = "Edelman PR";
        String locationValue = "Chicago";
        String positionTypeValue = "Entry Level";
        String coreCompetencyValue = "Flexibility";

        // Tests themselves
        assertTrue(job1.toString().contains(idLabel));
        assertTrue(job1.toString().contains(String.valueOf(idValue)));
        assertTrue(job1.toString().contains(nameLabel));
        assertTrue(job1.toString().contains(nameValue));
        assertTrue(job1.toString().contains(employerLabel));
        assertTrue(job1.toString().contains(employerValue));
        assertTrue(job1.toString().contains(locationLabel));
        assertTrue(job1.toString().contains(locationValue));
        assertTrue(job1.toString().contains(positionTypeLabel));
        assertTrue(job1.toString().contains(positionTypeValue));
        assertTrue(job1.toString().contains(coreCompetencyLabel));
        assertTrue(job1.toString().contains(coreCompetencyValue));
    }

    // Test 6: TDD to test if a field is empty, toString adds "Data not available" after the label.
    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("PR Specialist", new Employer("Edelman PR"), new Location(null), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        Job job2 = new Job("PR Specialist", new Employer("Edelman PR"), new Location(""), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        String message = "Data not available";
        assertTrue(job1.toString().contains(message));
        assertTrue(job2.toString().contains(message));
    }
}
