package com.example.demo2.file;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author lanxinghua
 * @date 2018/08/29 23:12
 * @description
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private String path = "d:\\";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception{
        System.out.println(JSON.toJSONString(file));
        File localFile = new File(path, file.getOriginalFilename());
        file.transferTo(localFile);
        return new FileInfo("http://localhost:8080/file/"+file.getOriginalFilename());
    }

    @GetMapping("/{id}")
    public void downLoad(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try {
            File file = new File(path, id );
            FileInputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachement;filename="+id+".jpg");
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}