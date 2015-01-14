package is.bokun.dtos.mandrill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendTemplateRequestDto extends SendRequestDto {

    public String template_name;
    public List<Variable> template_content = new ArrayList<>();

    public String getTemplate_name() {
        return template_name;
    }

    public void setTemplate_name(String template_name) {
        this.template_name = template_name;
    }

    public List<Variable> getTemplate_content() {
        return template_content;
    }

    public void setTemplate_content(List<Variable> template_content) {
        this.template_content = template_content;
    }
}
