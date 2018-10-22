public class Test extends CoreTest{

    @org.junit.Test
    public void mailTest() {
        loginPage.setLogin(props.getProperty("mail.login")) // set a login
                .setPassword(props.getProperty("mail.password")) // set a pass
                .pushEnter();
        mainPage.pushAButtonWriteALetter();
        letterPage.setToWhom(props.getProperty("mail.toWhom"))
                .setTopicLine(props.getProperty("mail.subject"))
                .setSubjectText(props.getProperty("mail.message"))
                .pushSend();
    }
}