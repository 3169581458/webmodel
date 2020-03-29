package com.example.mvcdemo2.service.impl;

import com.example.mvcdemo2.exception.CustomException;
import com.example.mvcdemo2.pojo.Message;
import com.example.mvcdemo2.repository.MessageRspository;
import com.example.mvcdemo2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRspository rspository;

    @Override
    public List<Message> findAll() {
        return rspository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return rspository.findOne(id);
    }

    @Override
    public Message save(Message message) throws CustomException{
        return rspository.save(message);
    }

    @Override
    public void delete(Long id) {
        rspository.delete(id);

    }

    @Override
    public Message update(Message message) throws CustomException {
        return rspository.update(message);
    }

    @Override
    public Message updateText(Message message) throws CustomException{
        return rspository.updateText(message);
    }
}
