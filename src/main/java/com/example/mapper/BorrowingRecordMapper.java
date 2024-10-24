package com.example.mapper;

import com.example.dto.BorrowingRecordDTO;
import com.example.entity.BorrowingRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PatronMapper.class})
public interface BorrowingRecordMapper {

    BorrowingRecordMapper INSTANCE = Mappers.getMapper(BorrowingRecordMapper.class);

    BorrowingRecordDTO toDTO(BorrowingRecord borrowingRecord);

    BorrowingRecord toEntity(BorrowingRecordDTO borrowingRecordDTO);
}
//import com.example.dto.BorrowingRecordDTO;
//import com.example.entity.BorrowingRecord;
//import org.springframework.stereotype.Component;
//
//@Component
//public class BorrowingRecordMapper {
//
//    private final PatronMapper patronMapper;
//
//    public BorrowingRecordMapper(PatronMapper patronMapper) {
//        this.patronMapper = patronMapper;
//    }
//
//    public BorrowingRecordDTO toDTO(BorrowingRecord record) {
//        if (record == null) {
//            return null;
//        }
//
//        BorrowingRecordDTO recordDTO = new BorrowingRecordDTO();
//        recordDTO.setId(record.getId());
//        recordDTO.setBorrowDate(record.getBorrowDate());
//        recordDTO.setReturnDate(record.getReturnDate());
//        recordDTO.setPatron(patronMapper.toDTO(record.getPatron()));
//
//        return recordDTO;
//    }
//
//    public BorrowingRecord toEntity(BorrowingRecordDTO recordDTO) {
//        if (recordDTO == null) {
//            return null;
//        }
//
//        BorrowingRecord record = new BorrowingRecord();
//        record.setId(recordDTO.getId());
//        record.setBorrowDate(recordDTO.getBorrowDate());
//        record.setReturnDate(recordDTO.getReturnDate());
//        record.setPatron(patronMapper.toEntity(recordDTO.getPatron()));
//
//        return record;
//    }
//}