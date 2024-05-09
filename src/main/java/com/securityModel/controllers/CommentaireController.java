package com.securityModel.controllers;

import com.securityModel.models.Chat;
import com.securityModel.models.Commentaire;
import com.securityModel.service.ChatService;
import com.securityModel.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("commentaires")
@CrossOrigin("*")
public class CommentaireController {
    @Autowired
    private CommentaireService commentaireService;
    @PostMapping("/add")
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire){
        return commentaireService.createCommentaire(commentaire);

    }
    @GetMapping("/all")
    public List<Commentaire> allCommentaires(){
        return commentaireService.allCommentaires();
    }
    @GetMapping("getone/{id}")
    public Commentaire commentaireById(@PathVariable Long id){
        return commentaireService.commentaireById(id);
    }
    @PutMapping("update/{id}")
    public Commentaire updateCommentaire(@PathVariable Long id,@RequestBody Commentaire commentaire){
        return commentaireService.updateCommentaire(id,commentaire);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteCommentaire(@PathVariable Long id){
        Commentaire ad=commentaireService.commentaireById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                commentaireService.deleteCommentaire(id);
                message.put("etat"," Commentaire deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","Commentaire not found");
            return message;
        }
    }
}
