package com.securityModel.service;

import com.securityModel.models.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire createCommentaire(Commentaire commentaire);
    List<Commentaire> allCommentaires();
    Commentaire commentaireById(Long id);
    Commentaire updateCommentaire(Long id,Commentaire commentaire);
    void  deleteCommentaire(Long id);
}
