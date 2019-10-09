package com.myth.springboot.service;

import com.myth.springboot.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TService {
    @Autowired
    AdminMapper mapper;
}
