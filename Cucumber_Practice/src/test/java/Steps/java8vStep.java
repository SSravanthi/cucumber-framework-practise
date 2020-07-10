package Steps;

import cucumber.api.java8.En;

public class java8vStep implements En {
    public java8vStep() {
        And("^I just need to see how step looks  for Cucumber-Java(\\d+)$", (Integer arg0) -> {
            System.out.println("The value form the new step class is :"+arg0);
        });
    }
}
