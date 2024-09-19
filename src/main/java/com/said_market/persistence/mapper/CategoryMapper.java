package com.said_market.persistence.mapper;

import com.said_market.domain.Category;
import com.said_market.persistence.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Vamos a obtener un Category de Categoria
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")

    })
    Category toCategory(Categoria categoria );

    @InheritInverseConfiguration //Que es la inversa de arriba // No se usa mappings
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
