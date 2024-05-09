package com.securityModel.service;

import com.securityModel.models.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    List<Message> allMessages();
    Message messageById(Long id);
    Message updateMessage(Long id,Message message);
    void deleteMessage(Long id);
}
