package com.sg.common.codebuilder.controller;

import com.sg.common.base.controller.BaseController;
import com.sg.common.codebuilder.service.CodeBuilderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/buildcode/")
public class CodeBuilderController extends BaseController{

    @Autowired
    CodeBuilderService codeBuilderService;

    @RequestMapping(value = "/buildtable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object buildtable(@RequestBody List<Map> info){
        String tableName = (String) info.get(0).get("tableName");
        logger.info(tableName);
        codeBuilderService.buildTables(info);
        return "{\"success\":\"done!!!!\"}";
    }
}
