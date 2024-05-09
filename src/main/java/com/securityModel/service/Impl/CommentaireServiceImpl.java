package com.securityModel.service.Impl;


import com.securityModel.models.Commentaire;
import com.securityModel.repository.CommentaireRepository;
import com.securityModel.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentaireServiceImpl implements CommentaireService {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Override
    public Commentaire createCommentaire(Commentaire commentaire){ return commentaireRepository.save(commentaire);}
    @Override
    public List<Commentaire> allCommentaires(){ return commentaireRepository.findAll();}
    @Override
    public Commentaire commentaireById(Long id){ return commentaireRepository.findById(id).orElseThrow(null);}
    @Override
    public Commentaire updateCommentaire(Long id,Commentaire commentaire){
        Commentaire ad=commentaireRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            commentaire.setId(id);
            return commentaireRepository.save(commentaire);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteCommentaire(Long id){
        commentaireRepository.deleteById(id);
    }
}
