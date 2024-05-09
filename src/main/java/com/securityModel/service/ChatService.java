package com.securityModel.service;

import com.securityModel.models.Chat;

import java.util.List;

public interface ChatService {
    Chat createChat(Chat chat);
    List<Chat> allChats();
    Chat chatById(Long id);
    Chat updateChat(Long id,Chat chat);
    void deleteChat(Long id);

}
