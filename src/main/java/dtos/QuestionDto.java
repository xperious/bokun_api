package dtos;

import com.codiform.moo.annotation.Property;

public class QuestionDto {

    public Long id;

    public boolean active = true;
    public String label;

    @Property(translation = "type.name()")
    public String type;

    public String options;
}
