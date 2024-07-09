package com.lyx.bookmanager.service;

import com.lyx.bookmanager.mapper.ReaderMapper;
import com.lyx.bookmanager.mapper.UserMapper;
import com.lyx.bookmanager.pojo.Book;
import com.lyx.bookmanager.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    UserMapper userMapper;
    public List<Reader> getAllReader(){
        return readerMapper.getAllReader();
    }
    public Page<Reader> getAllReaders(int page, int size) {
        List<Reader> reader=readerMapper.getAllReader();
        int start=(page-1)*size;
        int end=Math.min(start+size,reader.size());
        Sort sort = Sort.by(Sort.Direction.ASC, "readerId");
        if(page < 1) { page = 1; }
        // 在PageRequest里，page的值是从0（第1页）开始数的
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Reader> readerPage=new PageImpl<>(reader.subList(start,end),pageable,reader.size());
        return readerPage;
    }
    public String getReadName(String readerId){
        return readerMapper.getReaderName(readerId);
    }
    public Reader getReaderInfo(String readId){
        return readerMapper.getReaderInfo(readId);
    }
    public void updateInfo(Reader reader){
        readerMapper.updateInfo(reader);
    }
    public void addReader(Reader reader){
        readerMapper.addReader(reader);
        userMapper.addUser(String.valueOf(reader.getReaderId()));
    }
    public void deleteReader(int readId){
        readerMapper.deleteReader(readId);
    }
}
