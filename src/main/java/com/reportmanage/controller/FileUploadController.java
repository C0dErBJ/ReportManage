package com.reportmanage.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.reportmanage.model.File;
import com.reportmanage.service.IFileService;
import com.reportmanage.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by C0dEr on 16/2/24.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    @Resource
    private IFileService fileService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(@RequestParam CommonsMultipartFile[] files, HttpServletRequest request) {
        if (files != null && files.length > 0) {
            File file = new File();
            file.setFilename(files[0].getOriginalFilename());
            if (!files[0].getOriginalFilename().equals("") && files[0].getOriginalFilename() != null) {
                String[] type = files[0].getOriginalFilename().split("\\.");
                if (type.length > 1) {
                    file.setFiletype(type[1]);
                }
            }

            java.io.File dirpath = new java.io.File(request.getSession().getServletContext().getRealPath("/") + "/uploads/");
            if (!dirpath.exists()) {
                dirpath.mkdirs();
            }
            String filePath = dirpath.getPath() + "/" + new Date().getTime() + files[0].getOriginalFilename();
            file.setFilepath(filePath);
            try {
                files[0].transferTo(new java.io.File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean isSave = fileService.upload(file);
            return file;
        }
        ObjectMapper mapper = new ObjectMapper();
        String str = "";
        try {
            str = mapper.writeValueAsString(new File());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@PathVariable int id) throws UnsupportedEncodingException {
        File file = fileService.getFile(id);
        if (file != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", java.net.URLEncoder.encode(file.getFilename(), "UTF-8"));
            try {
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new java.io.File(file.getFilepath())),
                        headers, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<byte[]>(null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> deleteFile(@PathVariable int id) {
        File file = fileService.getFile(id);
        if (file != null) {
            fileService.deleteFile(file.getId());
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<String>("False", HttpStatus.OK);
    }
}
