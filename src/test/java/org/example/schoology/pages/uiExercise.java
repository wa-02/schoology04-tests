
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.core.ui.AbstractPage;
import org.openqa.selenium.support.ui.Select;

public class uiExercise extends AbstractPage {
    @FindBy(css = "")
    private WebElement categoryField;

    public void selectCategory(final String category) {
        Select selectCategory = new Select(categoryField);
        selectCategory.selectByVisibleText(category);
    }

}
