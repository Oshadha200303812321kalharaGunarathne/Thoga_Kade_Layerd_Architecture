package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDetails {
    private String OrderID;
    private String ItemCode;
    private int OrderQty;
    private int Discount;
}
