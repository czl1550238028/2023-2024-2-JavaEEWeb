package com.lyx.bookmanager.mapper;

import com.lyx.bookmanager.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReaderMapper {
    List<Reader> getAllReader();
    String getReaderName(String readerId);
    Reader getReaderInfo(String readerId);
    void updateInfo(Reader reader);
    int addReader(Reader reader);
    void deleteReader(int readerId);
}
