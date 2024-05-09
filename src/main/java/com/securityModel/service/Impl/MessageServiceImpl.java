package com.securityModel.service.Impl;


import com.securityModel.models.Message;

import com.securityModel.repository.MessageRepository;
import com.securityModel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl  implements MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Override
    public Message createMessage(Message message){ return messageRepository.save(message);}
    @Override
    public List<Message> allMessages(){ return messageRepository.findAll();}
    @Override
    public Message messageById(Long id){ return messageRepository.findById(id).orElseThrow(null);}
    @Override
    public Message updateMessage(Long id,Message message){
        Message ad=messageRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            message.setId(id);
            return messageRepository.save(message);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

}
