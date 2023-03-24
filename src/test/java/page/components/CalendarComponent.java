package page.components;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent{
    public void setCalendar(String month , String year, String day){
        $(".react-datepicker__year-dropdown-container--select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-dropdown-container--select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();
    }
}
