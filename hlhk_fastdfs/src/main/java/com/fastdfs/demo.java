package com.fastdfs;

import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/file")
@RestController
public class demo {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @PostMapping("/uplod")
    public String test(@RequestParam MultipartFile file)throws IOException {

        //设置文件信息,可以设置文件的一些信息，mataDataSet也可以为空
        Set<MataData> mataDataSet = new HashSet<>();
        mataDataSet.add(new MataData("white", "50px"));
        mataDataSet.add(new MataData("height", "60px"));

        //上传
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        System.out.print("storePath="+storePath);
        return "";
    }
}
