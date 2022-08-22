import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class BetFed {

    public boolean passwordValidation(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@])([a-zA-Z0-9!@]){6,20}$");
    }

    public void verifyIndustryList(List<String> actualIndustry) {
        List<String> expectedIndustry = this.getExpectedIndustryList();
        assert expectedIndustry.size() == actualIndustry.size();
        Collections.sort(actualIndustry);
        Collections.sort(expectedIndustry);
        for (int i = 0; i < actualIndustry.size(); i++) {
            assert actualIndustry.get(i).equals(expectedIndustry.get(i));
        }
    }

    public void verifyIndustryListOtherOption(List<String> actualIndustry) {
        List<String> expectedIndustry = this.getExpectedIndustryList();
        assertThat(actualIndustry, Matchers.containsInAnyOrder(expectedIndustry.toArray()));
    }

    private List<String> getExpectedIndustryList() {
        return new ArrayList<>(List.of("Agriculture", "IT", "Education", "Healthcare", "Unemployed", "Retired", "Other"));
    }

    @Test
    public void passwordValidationTest() {
        System.out.println(passwordValidation("!fsfs321"));
        System.out.println(passwordValidation("!f1"));
        System.out.println(passwordValidation("ff@!@!@!4343dfdfdf"));
    }

    @Test
    public void industryListTest() {
        List<String> unorganizedList = new ArrayList<>(List.of("Healthcare", "IT", "Education", "Agriculture", "Other", "Retired", "Unemployed"));
        this.verifyIndustryList(unorganizedList);
        this.verifyIndustryListOtherOption(unorganizedList);
    }
}
