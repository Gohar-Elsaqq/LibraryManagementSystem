package com.example.mapper;

import com.example.dto.PatronDTO;
import com.example.entity.Patron;
import org.springframework.stereotype.Component;

//@Component
//public class PatronMapper {


//    public PatronDTO toDTO(Patron patron) {
//        if (patron == null) {
//            return null;
//        }
//
//        PatronDTO patronDTO = new PatronDTO();
//        patronDTO.setId(patron.getId());
//        patronDTO.setName(patron.getName());
//        patronDTO.setContactInformation(patron.getContactInformation());
//
//        return patronDTO;
//    }

//    public Patron toEntity(PatronDTO patronDTO) {
//        if (patronDTO == null) {
//            return null;
//        }
//
//        Patron patron = new Patron();
//        patron.setId(patronDTO.getId());
//        patron.setName(patronDTO.getName());
//        patron.setContactInformation(patronDTO.getContactInformation());
//
//        return patron;
//    }
//}
import com.example.dto.PatronDTO;
import com.example.entity.Patron;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatronMapper {

    PatronMapper INSTANCE = Mappers.getMapper(PatronMapper.class);

    PatronDTO toDTO(Patron patron);

    Patron toEntity(PatronDTO patronDTO);
}