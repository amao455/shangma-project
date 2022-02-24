package com.shangma.cn.controller;

/*
*
* 文件说明：用来爬取京东上面的数据
* */

import com.shangma.cn.entity.Brand;
import com.shangma.cn.service.BrandService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("common")
public class CommonController {

    @Autowired
    private BrandService brandService;

    @GetMapping("getBrandDataFromJD")
    public String getBrandDataFromJD() throws IOException {
        // 使用jsoup获得京东数据
        Document document = Jsoup.connect("https://www.jd.com/brand.aspx#JDS_07").get();
        Elements brandslist = document.getElementsByClass("tabcon");
        for(int i = 0; i < brandslist.size(); i++){
            Element element = brandslist.get(i);
            Elements li = element.getElementsByTag("li");
            for(int j = 0; j < li.size(); j++){
                Element element1 = li.get(j);
                //获取图片地址
                String img = element1.getElementsByClass("b-img").get(0).getElementsByTag("img").get(0).attr("src");
                String name = element1.getElementsByClass("b-name").get(0).text();
                Brand brand = new Brand();
                brand.setBrandDesc(name);
                brand.setBrandName(name);
                brand.setBrandLogo(img);
                brand.setBrandSite("http://www.baidu.com");
                brand.setCreateBy(1L);
                brand.setCreateTime(LocalDateTime.now());
                brandService.add(brand);

            }
        }
        return "success";

    }
}
