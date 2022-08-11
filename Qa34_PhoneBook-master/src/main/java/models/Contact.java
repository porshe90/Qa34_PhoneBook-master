package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Contact {
    private String  name;
    private String  lastname;
    private String  phone;
    private String  email;
    private String  address;
    private String  description;

}
