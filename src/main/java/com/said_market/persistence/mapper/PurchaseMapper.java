package com.said_market.persistence.mapper;

import com.said_market.domain.Purchase;
import com.said_market.persistence.entities.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = PurchaseItemMaper.class)
public interface PurchaseMapper {


    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "state"), //Purchase Item Mapper

    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchase (List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore =true)
    Compra toCompra(Purchase purchase );

}
