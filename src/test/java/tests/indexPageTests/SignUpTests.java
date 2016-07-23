package tests.indexPageTests;

import org.testng.annotations.Test;
import tests.Fixture;


public class SignUpTests extends Fixture {

    @Test
    public void test1_positiveSignUp() {
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();


    }

    @Test
    public  void test2_allBlankFieldsSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("");
        carServStation.signUpClientPage.fillSecondNameField("");
        carServStation.signUpClientPage.fillPhoneNumberField("");
        carServStation.signUpClientPage.fillDLNumberField("");
        carServStation.signUpClientPage.fillEmailField("");
        carServStation.signUpClientPage.fillPasswordfield("");
        carServStation.signUpClientPage.pressSubmitButton();


    }

    @Test
    public void test3_blankFirstNameFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void  test4_blankSecondNameFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test5_blankPhoneNumberFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test6_blankDLNumberFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test7_blankEmailFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test8_blankPassFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test9_wrongFormatFirstNameFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("A12asd");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test10_wrongFormatSecondNameFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tok123sdf");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test11_wrongFormatPhoneNumberFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-88-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test12_wrongFormatEmailFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar.gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test13_wrongFormatDLNumberFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }

    @Test
    public void test14_wrongFormatPassFieldSignUp(){
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToSignUpPage();
        carServStation.signUpClientPage.fillFirstNameField("Alisa");
        carServStation.signUpClientPage.fillSecondNameField("Tokar");
        carServStation.signUpClientPage.fillPhoneNumberField("097-098-9883");
        carServStation.signUpClientPage.fillDLNumberField("SWD#768334");
        carServStation.signUpClientPage.fillEmailField("alisa.tokar@gmail.com");
        carServStation.signUpClientPage.fillPasswordfield("Alisa1211");
        carServStation.signUpClientPage.pressSubmitButton();

    }
}
