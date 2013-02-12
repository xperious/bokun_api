package queries;


import org.codehaus.jackson.annotate.JsonIgnore;
import utils.StringUtils;

public class TextFilter {

    public String text;
    public String operator = "or";

    public boolean searchTitle = true;
    public boolean searchKeywords = true;
    public boolean searchFullText = true;

    @JsonIgnore
    public boolean isActive() {
        return !StringUtils.isNullOrEmpty(text) && (searchTitle || searchKeywords || searchFullText);
    }

    @JsonIgnore
    public boolean isAndOperator() {
        return !StringUtils.isNullOrEmpty(operator) && operator.equalsIgnoreCase("and");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(boolean searchTitle) {
        this.searchTitle = searchTitle;
    }

    public boolean isSearchKeywords() {
        return searchKeywords;
    }

    public void setSearchKeywords(boolean searchKeywords) {
        this.searchKeywords = searchKeywords;
    }

    public boolean isSearchFullText() {
        return searchFullText;
    }

    public void setSearchFullText(boolean searchFullText) {
        this.searchFullText = searchFullText;
    }
}
