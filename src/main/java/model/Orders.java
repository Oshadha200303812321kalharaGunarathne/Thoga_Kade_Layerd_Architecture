package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Orders {
    private String OrderID;
    private String OrderDate;
    private String CustID;
}
