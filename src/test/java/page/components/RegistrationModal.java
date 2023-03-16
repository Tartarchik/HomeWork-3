package page.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationModal {
    public RegistrationModal verifyModal(String value){
        $(".modal-open").shouldHave(text(value));

        return this;
    }
    public RegistrationModal verifyModalResult(String key , String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

}
