package com.leekwah.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Item {

    private Long id;

    private String itemNm;

    private int price;


}
