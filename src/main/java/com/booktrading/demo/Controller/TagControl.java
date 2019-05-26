package com.booktrading.demo.Controller;

import com.booktrading.demo.Dto.TagDto;
import com.booktrading.demo.Model.Tag;
import com.booktrading.demo.Service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/tag")
public class TagControl {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping(value = "/all")
    public List<Tag> Getalltag()
    {
        return tagService.GetAlltag();
    }

    @PostMapping(value = "/create")
    public String CreatenewTag(@RequestBody TagDto tagDto)
    {
        System.out.println(tagDto.getTagname());
        return tagService.CreateNeaTag(tagDto);
    }

}
