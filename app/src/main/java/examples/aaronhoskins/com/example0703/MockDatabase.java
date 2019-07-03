package examples.aaronhoskins.com.example0703;

import java.util.ArrayList;

public class MockDatabase {
    private ArrayList<ExampleObject> exampleDatabase;
    private static MockDatabase mockDatabase;

    public static MockDatabase getInstance() {
        if(mockDatabase == null) {
            mockDatabase = new MockDatabase();
        }
        return mockDatabase;
    }

    private MockDatabase() {
        exampleDatabase = new ArrayList<>();
        exampleDatabase.add(
                new ExampleObject("Value_One", "example_one"));
        exampleDatabase.add(
                new ExampleObject("Value_Two", "example_two"));
        exampleDatabase.add(
                new ExampleObject("Value_Three", "example_three"));
        exampleDatabase.add(
                new ExampleObject("Value_Four", "example_four"));
        exampleDatabase.add(
                new ExampleObject("Value_Five", "example_five"));
        exampleDatabase.add(
                new ExampleObject("Value_Six", "example_six"));
        exampleDatabase.add(
                new ExampleObject("Value_Seven", "example_seven"));
    }

    public ArrayList<ExampleObject> getAllMockObjects() {
        return exampleDatabase;
    }

    public void removeItemFromMockDatabase(ExampleObject exampleObject) {
        exampleDatabase.remove(exampleObject);
    }

}
