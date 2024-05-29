package com.easy.easytable.service;

import com.easy.easytable.entity.ClientEntity;
import com.easy.easytable.exception.EasyTableException;
import org.springframework.transaction.annotation.Transactional;

public interface IClientService {
    @Transactional( readOnly = true, timeout = 50)
    public abstract ClientEntity authentifier(String email, String password) throws Exception;
    @Transactional(readOnly = true, timeout = 50)
    public abstract ClientEntity getClientById(int id) throws EasyTableException;
    @Transactional(rollbackFor = Exception.class, timeout = 50)
    public  abstract ClientEntity creerCompte(ClientEntity client) throws EasyTableException;
}
