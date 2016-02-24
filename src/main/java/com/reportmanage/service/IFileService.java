package com.reportmanage.service;

import com.reportmanage.model.File;

/**
 * Created by C0dEr on 16/2/24.
 */
public interface IFileService {
    boolean upload(File file);

    File getFile(int id);

    boolean deleteFile(int id);
}
