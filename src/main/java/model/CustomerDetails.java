package model;

import lombok.*;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDetails {

    private String custID;
    private String custTitle;
    private String custName;
    private String DOB;
    private double salary;
    private String custAddress;
    private String city;
    private String province;
    private String postalCode;
}
