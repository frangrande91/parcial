package com.parcialLabV.parcial.converter;

import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDTOConverter implements Converter<Person, PersonDto> {

    private final ModelMapper modelMapper;

    public PersonToPersonDTOConverter(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDto convert(Person source) {
        return modelMapper.map(source,PersonDto.class);
    }


}
