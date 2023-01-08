import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.HomePageScooter;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)
public class DropdownTextTest {
    HomePageScooter objHomePage;
    WebDriver driver;

    @Before
    public void before() {
        //создание экземпляра драйвера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Найди раздел «Вопросы о важном» и сделать скролл до неё
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        // создай объект класса главной страницы приложения
        objHomePage = new HomePageScooter(driver);

    }

    /*@Parameterized.Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Parameterized.Parameter
    public String answer; //хотела в эту переменную описывать вопрос из параметризированного массива

    @Parameterized.Parameter(1)
    public String question; //хотела в эту переменную описывать ответ из параметризированного массива

    */

    @Test
    public void checkAccordion0() {
        int index = 0;
        objHomePage.clickPanel(index);
        Assert.assertTrue(objHomePage.isPanelVisible(index));
        //сюда вместо строки хотела передавать expected: answer
        assertEquals("Сколько это стоит? И как оплатить?",objHomePage.getTextFromAnswer(index));
        //сюда вместо строки хотела передавать expected: question
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",objHomePage.getTextFromQuestion(index));
        //но параметризацию выполнить не удалось, для каждого локатора запускалась проверка не 1 строки вопроса/ответа массива, а всех 8 строк
        //общение с наставником не помогло, сделать нормальную параметризацию не смогла, прошу помощи в реализации и наводки, как считывать 1 строку параметризированного массива для 1 теста

    }

    @Test
    public void checkAccordion1() { //вызов первого вып списка
        objHomePage.clickPanel(1);
        Assert.assertTrue(objHomePage.isPanelVisible(1));
        assertEquals("Хочу сразу несколько самокатов! Так можно?",objHomePage.getTextFromAnswer(1));
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
            ,objHomePage.getTextFromQuestion(1));
    }

    @Test
    public void checkAccordion2() {
        objHomePage.clickPanel(2);
        Assert.assertTrue(objHomePage.isPanelVisible(2));
        assertEquals("Как рассчитывается время аренды?",objHomePage.getTextFromAnswer(2));
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",objHomePage.getTextFromQuestion(2));
    }

    @Test
    public void checkAccordion3() {
        objHomePage.clickPanel(3);
        Assert.assertTrue(objHomePage.isPanelVisible(3));
        assertEquals("Можно ли заказать самокат прямо на сегодня?",objHomePage.getTextFromAnswer(3));
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",objHomePage.getTextFromQuestion(3));
    }

    @Test
    public void checkAccordion4() {
        objHomePage.clickPanel(4);
        Assert.assertTrue(objHomePage.isPanelVisible(4));
        assertEquals("Можно ли продлить заказ или вернуть самокат раньше?",objHomePage.getTextFromAnswer(4));
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",objHomePage.getTextFromQuestion(4));
    }

    @Test
    public void checkAccordion5() {
        objHomePage.clickPanel(5);
        Assert.assertTrue(objHomePage.isPanelVisible(5));
        assertEquals("Вы привозите зарядку вместе с самокатом?",objHomePage.getTextFromAnswer(5));
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",objHomePage.getTextFromQuestion(5));
    }

    @Test
    public void checkAccordion6() {
        objHomePage.clickPanel(6);
        Assert.assertTrue(objHomePage.isPanelVisible(6));
        assertEquals("Можно ли отменить заказ?",objHomePage.getTextFromAnswer(6));
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",objHomePage.getTextFromQuestion(6));
    }

    @Test
    public void checkAccordion7() {
        objHomePage.clickPanel(7);
        Assert.assertTrue(objHomePage.isPanelVisible(7));
        assertEquals("Я жизу за МКАДом, привезёте?",objHomePage.getTextFromAnswer(7));
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",objHomePage.getTextFromQuestion(7));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
