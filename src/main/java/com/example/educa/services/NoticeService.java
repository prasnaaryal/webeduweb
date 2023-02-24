package com.example.educa.services;

import com.example.educa.Entity.Notice;
import com.example.educa.Entity.Student;

import java.util.List;

public interface NoticeService {
    List<Notice> getAllNotices();
    Notice saveNotice(Notice notice);
    Notice getNoticeById(Long id);
//    Notice findByEmail(String email);
    Notice updateNotice(Notice notice);

    void deleteNoticeById(Long id);
}
