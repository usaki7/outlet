package com.sky.controller.admin;

import com.sky.entity.Employee;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "common api")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * file upload
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("file upload")
    public Result<String> upload(MultipartFile file) {
        log.info("file upload");
        try {
            String fileName = file.getOriginalFilename();
            String extension = fileName.substring(fileName.lastIndexOf("."));
            String suffix = UUID.randomUUID().toString() + extension;
            String filepath = aliOssUtil.upload(file.getBytes(), suffix);
            return Result.success(filepath);
        } catch (IOException e) {
            log.error("upload file fail:{}", e);
        }
        return Result.error("upload file fail");
    }
}
