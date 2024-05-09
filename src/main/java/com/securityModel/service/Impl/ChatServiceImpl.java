package com.securityModel.service.Impl;

import com.securityModel.models.Chat;

import com.securityModel.repository.ChatRepository;

import com.securityModel.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public Chat createChat(Chat chat){ return chatRepository.save(chat);}
    @Override
    public List<Chat> allChats(){ return chatRepository.findAll();}
    @Override
    public Chat chatById(Long id){ return chatRepository.findById(id).orElseThrow(null);}
    @Override
    public Chat updateChat(Long id, Chat chat){
        Chat ad=chatRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            chat.setId(id);
            return chatRepository.save(chat);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteChat(Long id){
        chatRepository.deleteById(id);
    }
}
