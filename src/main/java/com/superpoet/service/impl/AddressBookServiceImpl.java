package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superpoet.domain.AddressBook;
import com.superpoet.mapper.AddressBookMapper;
import com.superpoet.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
