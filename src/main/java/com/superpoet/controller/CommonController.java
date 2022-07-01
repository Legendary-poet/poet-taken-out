package com.superpoet.controller;

import com.superpoet.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
//
//@RestController
//@RequestMapping("/common")
//@Slf4j
//public class CommonController {
//    @Value("${poet.path}")  //el表达式，从配置文件读取
//    private  String basePath;
//    /**
//     * 文件上传
//     * @param file
//     * @return
//     */
//    @PostMapping("/upload")
//    public R<String> upload(MultipartFile file){//file的名字必须与前端传过来的名字相同
//
//        log.info(file.toString());
//
//        //原始文件名称
//        String originalFilename = file.getOriginalFilename();
//        String[] split = originalFilename.split("\\.");
//        //split是正则表达式所以要用转义字符，且java中\\.=\.
//        String s = ".".toString()+split[split.length-1];
//
//
//        //使用UUID随机生成文件名，防止因为文件名相同造成文件覆盖
//        String fileName= UUID.randomUUID().toString()+s;
//
//
//        //创建一个目录对象
//        File dir = new File(basePath);
//        //判断当前目录是否存在
//        if(!dir.exists()){
//            //目录不存在
//            dir.mkdirs();
//        }
//        //将临时文件转存到指定位置
//
//        try {
//            file.transferTo(new File(basePath+fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return R.success(fileName);
//    }

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${poet.path}")
    private String basePath;

    //文件上传
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        //file 是一个临时文件，需要转存到指定位置，否则请求完成后临时文件会删除
        //log.info("file:{}",file.toString());

        //原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID随机生成文件名，防止因为文件名相同造成文件覆盖
        String fileName = UUID.randomUUID().toString()+suffix;

        //创建一个目录对象
        File dir = new File(basePath);
        //判断当前目录是否存在
        if(!dir.exists()){
            //目录不存在
            dir.mkdirs();
        }

        try {
            //将临时文件转存到指定位置
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        //一直不回显的原因就是，没有在拦截器里添加取消拦截路径
        try {
            //输入流，读取文件
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));


            //输出流，写入到浏览器
            ServletOutputStream outputStream = response.getOutputStream();

            int len=0;
            byte[] bytes=new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
                //刷新此输出流并强制写入任何已缓冲的输出字节。
                // flush的一般约定是，调用flush表示，
                // 如果之前写入的任何字节已经被输出流的实现进行了缓冲，
                // 那么这些字节应该立即写入它们预期的目的地。

            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

