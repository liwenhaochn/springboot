package com.example.restfulcrud.controller;

import com.example.restfulcrud.entity.ExceptionMsgEnum;
import com.example.restfulcrud.entity.Response;
import com.example.restfulcrud.entity.ResponseData;
import com.example.restfulcrud.entity.Restroom;
import com.example.restfulcrud.repository.RestroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restfulCRUD")
public class ResponseController {
    @Autowired
    private RestroomRepo restroomRepo;

    protected Response result(ExceptionMsgEnum msg) {
        return new Response(msg);
    }

    protected Response result() {
        return new Response();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData getRestroomList() {
        List<Restroom> restroomList = new ArrayList<>(restroomRepo.findAll());
        return new ResponseData(ExceptionMsgEnum.SUCESS, restroomList);
    }

    // 增
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData add(Restroom restroom) {
        restroomRepo.save(restroom);
        return new ResponseData(ExceptionMsgEnum.SUCESS, restroom);
    }

    // 删
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseData delete(@PathVariable("id") long id) {
        restroomRepo.deleteById(id);
        return new ResponseData(ExceptionMsgEnum.SUCESS, id);
    }

    // 部分更新
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseData update(Restroom restroom) {
        restroomRepo.save(restroom);
        return new ResponseData(ExceptionMsgEnum.SUCESS, restroom);
    }

    // 全量更新
    @RequestMapping(value = "/replace", method = RequestMethod.PUT)
    public ResponseData replace(Restroom restroom) {
        restroomRepo.save(restroom);
        return new ResponseData(ExceptionMsgEnum.SUCESS, restroom);
    }

    // 查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData find(@PathVariable("id") long id) throws IOException {
        Restroom restroom = restroomRepo.findById(id);
        if (restroom == null) {
            return new ResponseData(ExceptionMsgEnum.FAIL, null);
        }
        return new ResponseData(ExceptionMsgEnum.SUCESS, restroom);
    }
}
