package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        }

        app.contact().providerContactData();

    }

    @Test
    public void removeOneContactSuccess(){

        Assert.assertEquals(app.contact().removeOneContact(),1);


    }

    @Test
    public void removeAllContactsSuccess(){
        app.contact().removeAllContacts();
       Assert.assertTrue(app.contact().isNoContactsHere());


    }
}
