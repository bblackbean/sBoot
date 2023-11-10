package com.bblackbean.sboot.data.entity;

import lombok.*;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "product")
public class ProcuctEntity {

    //@Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;
}
