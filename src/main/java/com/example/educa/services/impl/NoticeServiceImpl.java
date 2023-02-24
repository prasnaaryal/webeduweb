package com.example.educa.services.impl;

import com.example.educa.Entity.Notice;

import com.example.educa.repo.NoticeRepository;

import com.example.educa.services.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class NoticeServiceImpl implements NoticeService {

        private NoticeRepository noticeRepository;

        public NoticeServiceImpl(NoticeRepository noticeRepository) {
            super();
            this.noticeRepository = noticeRepository;
        }

        @Override
        public List<Notice> getAllNotices() {
            return noticeRepository.findAll();
        }


        @Override
        public Notice saveNotice(Notice notice) {
            return noticeRepository.save(notice);
        }

        @Override
        public Notice getNoticeById(Long id) {
            return noticeRepository.findById(id).get();
        }

//        @Override
//        public Notice findByEmail(String email) {
//            return noticeRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Not Found"));
//        }

        @Override
        public Notice updateNotice(Notice notice) {
            return noticeRepository.save(notice);
        }

        @Override
        public void deleteNoticeById(Long id) {
            noticeRepository.deleteById(id);
        }

    }


