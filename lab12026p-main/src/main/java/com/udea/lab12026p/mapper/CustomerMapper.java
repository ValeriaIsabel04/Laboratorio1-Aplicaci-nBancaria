package com.udea.lab12026p.mapper;

import com.udea.lab12026p.dto.CustomerDTO;
import com.udea.lab12026p.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.lang.NonNull;

/**
 * CustomerMapper
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @NonNull
    CustomerDTO toDTO(@NonNull Customer customer);

    @NonNull
    Customer toEntity(@NonNull CustomerDTO customerDTO);
}
