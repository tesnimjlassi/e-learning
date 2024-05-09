package com.securityModel.controllers;

import com.securityModel.models.Admin;
import com.securityModel.models.Chat;
import com.securityModel.service.AdminService;
import com.securityModel.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("chats")
@CrossOrigin("*")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @PostMapping("/add")
    public Chat createChat(@RequestBody Chat chat){
        return chatService.createChat(chat);

    }
    @GetMapping("/all")
    public List<Chat> allChats(){
        return chatService.allChats();
    }
    @GetMapping("/getone/{id}")
    public Chat chatById(@PathVariable Long id){
        return chatService.chatById(id);
    }
    @PutMapping("/update/{id}")
    public Chat updateChat(@PathVariable Long id,@RequestBody Chat chat){
        return chatService.updateChat(id,chat);
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteChat(@PathVariable Long id){
        Chat ad=chatService.chatById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                chatService.deleteChat(id);
                message.put("etat"," Chat deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","Chat not found");
            return message;
        }
    }
}
