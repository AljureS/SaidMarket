package com.said_market.persistence.mapper;

import com.said_market.domain.PurchaseItem;
import com.said_market.persistence.entities.ComprasProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMaper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "", target = "")
    })
    PurchaseItem toPurchaseItem (ComprasProducto producto);



}
