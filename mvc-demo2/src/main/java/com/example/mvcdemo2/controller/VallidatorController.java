package com.example.mvcdemo2.controller;

import com.example.mvcdemo2.pojo.Message;
import com.example.mvcdemo2.pojo.ValidatorObj;
import com.example.mvcdemo2.validator.MessageValidator;

import lombok.Data;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VallidatorController {
    @PostMapping(value = "/validate")
    public Map<String, Object> validate(@Valid @RequestBody ValidatorObj obj, Errors errors) {
        Map<String, Object> errMap = new HashMap<>();
        // 获取错误列表
        List<ObjectError> objectErrors = errors.getAllErrors();
        for (ObjectError error : objectErrors) {
            String key = null;
            String msg = null;
            // 字段错误
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                // 获取错误验证字段名
                key = fieldError.getField();
            } else {
                // 非字段错误
                // 获取验证对象名称
                key = error.getObjectName();
            }
            // 错误信息
            msg = error.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 绑定验证器
        binder.setValidator(new MessageValidator());
        // 定义日期参数格式，参数不再需注解@DateTimeFormat，boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @GetMapping("/msgValidator")
    public Map<String, Object> validator(@Valid Message msg, Errors Errors, Data date) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("date", date);
        // 判断是否存在错误
        if (Errors.hasErrors()) {
            // 获取全部错误
            List<ObjectError> objErrors = Errors.getAllErrors();
            for (ObjectError error : objErrors) {
                // 判定是否字段错误
                if (error instanceof FieldError) {
                    // 字段错误
                    FieldError fe = (FieldError) error;
                    map.put(fe.getField(), fe.getDefaultMessage());
                } else {
                    // 对象错误
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }
}
