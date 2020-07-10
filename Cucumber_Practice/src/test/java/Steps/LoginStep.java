package Steps;

import Base.BaseUtil;
import Transformations.EmailTransform;
import Transformations.SalaryCountTransform;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        //System.out.println("The driver is :" +base.StepInfo);
        System.out.println("I navigate to the login page");
        base.Driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("I click login button");
    }

    @Then("^I should see the user details page$")
    public void iShouldSeeTheUserDetailsPage() throws Throwable {
        System.out.println("I should see the user details page");
    }


    @And("^I enter following login details$")
    public void iEnterFollowingLoginDetails(DataTable table) throws Throwable {

        /*List<List<String>> data = table.raw();

        System.out.println("The value is :  " + data.get(0).get(0).toString());
        System.out.println("The value is :  " + data.get(0).get(1).toString());
        System.out.println("The value is :  " + data.get(1).get(0).toString());
        System.out.println("The value is :  " + data.get(1).get(1).toString());*/

        // create an arraylist
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);
        
        //create an iteration using for each
        for (User user: users){
            System.out.println("The Username is "+ user.username);
            System.out.println("The password is "+ user.password);
           // page.Login(user.username,user.password);
            
        }

    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) {
        System.out.println("The UserName is :" +userName);
        System.out.println("The Pasword is :" +password);
    }

    @Then("^I should see the user details page wrongly$")
    public void iShouldSeeTheUserDetailsPageWrongly()throws Throwable {
        System.out.println("I should see the user details page wrongly");
    }

    @And("^I enter the users email address as Email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The email address is :"+ email);
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransform.class) int salary) throws Throwable {
        System.out.println("My salary digits count is :"+ salary);
    }

    public class User{
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}