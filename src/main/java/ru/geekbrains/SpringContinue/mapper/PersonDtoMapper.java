package ru.geekbrains.SpringContinue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.SpringContinue.dto.PersonDto;
import ru.geekbrains.SpringContinue.entity.Person;

@Mapper
public interface PersonDtoMapper {

    PersonDtoMapper MAPPER = Mappers.getMapper(PersonDtoMapper.class);

    @Mapping(target = "first_name", source = "personDto.first_name")
    Person toPerson(PersonDto personDto);
}
