package model;

import javax.persistence.Enumerated;

public class GoodsForSale extends IdEntity{

    @Enumerated
    private StoreGoodsTypes storeGoodsTypes;
}
