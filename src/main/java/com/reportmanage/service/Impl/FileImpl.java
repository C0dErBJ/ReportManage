package com.reportmanage.service.Impl;

import com.reportmanage.dao.FileMapper;
import com.reportmanage.model.File;
import com.reportmanage.service.IFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by C0dEr on 16/2/24.
 */
@Service("fileService")
public class FileImpl implements IFileService {
    @Resource
    private FileMapper fileMapper;

    public boolean upload(File file) {
        return this.fileMapper.insert(file) >= 1;
    }

    public File getFile(int id) {
        return this.fileMapper.selectByPrimaryKey(id);
    }

    public boolean deleteFile(int id) {
        return this.fileMapper.deleteByPrimaryKey(id) >= 1;
    }

    public int insertBackPri(File record) {
        return this.fileMapper.insertBackPri(record);
    }
}
