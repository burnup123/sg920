package com.sg.purchase.rest;

import com.sg.common.base.controller.BaseController;
import com.sg.common.base.utils.Identities;
import com.sg.common.base.utils.ReturnUtil;
import com.sg.purchase.service.SupplierProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 供应商商品  restful控制器
 * Description: 供应商商品信息
 * Company: com.sg920
 * author: luomj
 * time:2017-09-06 23:34:44
 * version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/supplierProduct")
public class SupplierProductRestController extends BaseController{

    @Autowired
    private SupplierProductService supplierProductService;

    /**
     * 保存数据
     * url: {ctx}/api/v1/supplierProduct/save
     * type: supplierProduct
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object save(@RequestBody Map map) throws Exception {
        try {
            if(null==map.get("id") || "".equals((String) map.get("id"))) {
                map.put("id", Identities.uuid2());
            }
            supplierProductService.save(map);
            return ReturnUtil.getSucessInfo(null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
     * 更新数据
     * url: {ctx}/api/v1/supplierProduct/update
     * type: supplierProduct
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object update(@RequestBody Map map) throws Exception {
        try {
            supplierProductService.update(map);
            return ReturnUtil.getSucessInfo(null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
    * 根据ID，删除单个或多个,多个用","号分隔
    * url: {ctx}/api/v1/supplierProduct/delete/{ids}
    * type: get
    */
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    public Object delete(@PathVariable("ids") String ids) throws Exception {
        try {
            supplierProductService.delete(ids.split(","));
            return ReturnUtil.getSucessInfo(null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
    * 根据ID，获取单个
    * url: {ctx}/api/v1/supplierProduct/fetch/{id}
    * type: get
    */
    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    public Object find(@PathVariable("id") String id) throws Exception {
        try {
            Map map = supplierProductService.fetch(id);
            return ReturnUtil.getSucessInfo(map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
    * 根据条件，获取多个
    * url: {ctx}/api/v1/supplierProduct/finds
    * type: get
    */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Object find() throws Exception {
        try {
            List list = supplierProductService.find(this.getParamData(), null);
            return ReturnUtil.getSucessInfo(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
    * 根据条件，分页获取多个
    * url: {ctx}/api/v1/supplierProduct/query
    * type: get
    */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Object query(@RequestParam(value = "size") int size,@RequestParam(value = "page") int page) throws Exception {
        try {
            Map<String, Object> terms = this.getParamData();
            PageRequest pageRequest = new PageRequest(page - 1, size);
            Long count = supplierProductService.count(terms);
            List list = supplierProductService.page(pageRequest, terms, null);
            Map ret = new HashMap();
            ret.put("total",count);
            ret.put("rows",list);
            return ReturnUtil.getSucessInfo(ret);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }

    /**
    * 统计数量
    * url: {ctx}/api/v1/supplierProduct/count
    * type: get
    */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Object count(HttpServletRequest request) throws Exception {
        try {
            return ReturnUtil.getSucessInfo(supplierProductService.count(this.getParamData()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ReturnUtil.getErrorInfo(e.getMessage());
        }
    }
}