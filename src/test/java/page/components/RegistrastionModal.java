package page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrastionModal {
    public void verifModal(String value){
        $(".modal-open").shouldHave(text(value));
    }
    public void regResultModal(String key , String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

}
