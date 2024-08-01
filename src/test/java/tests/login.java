package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.MyAccount;


public class login extends BaseTest{

        MyAccount ma = null;
        String nameStudent = null;

        @Test(dataProvider = "testdata")
        public void NavigateToHomePage( String username, String password) throws Exception {

            ma = new MyAccount();
            String nameStudent = ma.credentials(username,password);
            Assert.assertEquals(nameStudent,"ALESSANDRO MARINELLI","Student name isn't correct!!");

        }

        @DataProvider(name="testdata")
        public Object[][] tData(){

            return new Object[][] {
                    {"G10922088C","Rizzitiello1980!"}//,
                    //{"6999","K!1980!"}
            };
        }

        @Test(dataProvider = "testdata")
        public void options(String username, String password) throws Exception {
        ma = new MyAccount();
        ma.credentials(username,password);
        int sizeList = ma.menulist(nameStudent);
        Assert.assertEquals(sizeList,19,"MENU isn't correct!!");
    }

        @Test(dataProvider = "testdata")
        public void lessons(String username, String password) throws Exception {
            ma = new MyAccount();
            ma.credentials(username,password);
            ma.lessons();
            //Assert.assertEquals(f,"Elenco assenze giustificate","Page isn't correct!!");
        }

        @Test(dataProvider = "testdata")
        public void dailySchoolWork(String customerid, String username, String password) throws Exception {
            ma = new MyAccount();
            ma.credentials(username,password);
            //int workToDo = ma.myWork();
           // Assert.assertNotNull(workToDo, "The work table is empty! No work done!!");
        }

        //@Test(dataProvider = "testdata")
        public void today(String customerid, String username, String password) throws Exception {
            ma = new MyAccount();
            ma.credentials(username,password);
            //int numDay= ma.todayDate();
            //Assert.assertEquals(numDay, 0);

        }

        //@Test(dataProvider = "testdata")
        public void InformationSchoolToFamily(String customerid, String username, String password) throws Exception{
            ma = new MyAccount();
            ma.credentials(username,password);
           // ma.schoolToFamilyMessages();
        }

}
