package com.example.mvcdemo2.repository;

import com.example.mvcdemo2.pojo.Message;

import java.util.List;

public interface MessageRspository {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
