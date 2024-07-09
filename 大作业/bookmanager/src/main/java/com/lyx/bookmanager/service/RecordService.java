package com.lyx.bookmanager.service;

import com.lyx.bookmanager.mapper.RecordMapper;
import com.lyx.bookmanager.pojo.Reader;
import com.lyx.bookmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    RecordMapper recordMapper;
    public List<Record> getAllRecord(){
        return recordMapper.getAllRecord();
    }
    public Page<Record> getAllRecords(int page, int size) {
        List<Record> record=recordMapper.getAllRecord();
        int start=(page-1)*size;
        int end=Math.min(start+size,record.size());
        Sort sort = Sort.by(Sort.Direction.ASC, "sernum");
        if(page < 1) { page = 1; }
        // 在PageRequest里，page的值是从0（第1页）开始数的
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Record> recordPage=new PageImpl<>(record.subList(start,end),pageable,record.size());
        return recordPage;
    }
    public List<Record> getOwnRecord(String readerId){
        return recordMapper.getOwnRecord(readerId);
    }
    public Page<Record> getOwnRecords(String readerId,int page, int size) {
        List<Record> record=recordMapper.getOwnRecord(readerId);
        int start=(page-1)*size;
        int end=Math.min(start+size,record.size());
        Sort sort = Sort.by(Sort.Direction.ASC, "sernum");
        if(page < 1) { page = 1; }
        // 在PageRequest里，page的值是从0（第1页）开始数的
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Record> recordPage=new PageImpl<>(record.subList(start,end),pageable,record.size());
        return recordPage;
    }
    public Record getRecordBySernum(Long sernum){
        return recordMapper.getRecordBySernum(sernum);
    }
    public void insertRecord(Record record){
        recordMapper.insertRecord(record);
    }
    public void updateRecord(Record record){
        recordMapper.updateRecord(record);
    }
}
