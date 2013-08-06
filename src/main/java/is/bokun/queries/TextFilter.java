package is.bokun.queries;


import org.codehaus.jackson.annotate.*;

import is.bokun.utils.StringUtils;

/**
 * For filtering search results using textual search. The text provided is analyzed and the analysis process constructs a
 * boolean query from the provided text. The operator flag can be set to "or" or "and" to control
 * the boolean clauses (defaults to or).<br/>
 * We can control whether the textual search is performed on the product title, keywords, or full text (or any combination).
 * The default is to search all the fields. Double boosting is applied to title matches, and triple boosting to keyword
 * matches, compared with full text match.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextFilter {

    /**
     * The text to search by.
     */
    public String text;

    /**
     * The boolean operator, specifying whether to apply "or" or "and" to the words in the text.
     * Defaults to "or".
     */
    public String operator = "or";

    /**
     * Specifies whether to search the product title. Double boosting is applied to title matches.
     */
    public boolean searchTitle = true;
    /**
     * Specifies whether to search the product keywords. Triple boosting is applied to keyword matches.
     */
    public boolean searchKeywords = true;
    /**
     * Specifies whether to search the product full text field. No boosting is applied.
     */
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
