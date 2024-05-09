package com.securityModel.controllers;

import com.securityModel.models.Commentaire;
import com.securityModel.models.Message;
import com.securityModel.service.CommentaireService;
import com.securityModel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("messages")
@CrossOrigin("*")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping("/add")
    public Message createMessage(@RequestBody Message message){
        return messageService.createMessage(message);

    }
    @GetMapping("/all")
    public List<Message> allMessages(){
        return messageService.allMessages();
    }
    @GetMapping("getone/{id}")
    public Message messageById(@PathVariable Long id){
        return messageService.messageById(id);
    }
    @PutMapping("update/{id}")
    public Message updateMessage(@PathVariable Long id,@RequestBody Message message){
        return messageService.updateMessage(id,message);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteMessage(@PathVariable Long id){
        Message ad=messageService.messageById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                messageService.deleteMessage(id);
                message.put("etat"," Message deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","Message not found");
            return message;
        }
    }

}
