package com.example.educa.controller;
import com.example.educa.Entity.Notice;
import com.example.educa.services.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoticeController {
    private NoticeService noticeService;
    public  NoticeController(NoticeService noticeService) {
        super();
        this.noticeService = noticeService;
    }
    // handler method to handle list notice
    @GetMapping("/notices/new")
    public String createNoticeForm(Model model) {

        // create menu object to hold notice form data
        Notice notice = new Notice();
        model.addAttribute("notice", notice);
        return "create_notice";
    }
    @PostMapping("/notices")
    public String saveNotice(@ModelAttribute("notice") Notice notice) {
        noticeService.saveNotice(notice);
        return "redirect:/noticeList";
    }
    @GetMapping("/noticeList")
    public String listNotices(Model model) {
//        List<Notice> notices = noticeService.getAllNotices();
//        model.addAttribute("noticeList", notices.stream().map(notice ->
//                Notice.builder()
//                        .id(notice.getId())
//                        .noticeName(notice.getNoticeName())
//                        .build()
//        ));
        model.addAttribute("noticeList", noticeService.getAllNotices());
        return "notices";
    }
    @PostMapping("/notices/{id}")
    public String updateNotice(@PathVariable Long id,
                               @ModelAttribute("notice") Notice notice,
                               Model model) {
        Notice existingNotice = noticeService.getNoticeById(id);
        existingNotice.setId(id);
        existingNotice.setNoticeName(notice.getNoticeName());
        noticeService.updateNotice(existingNotice);
        return "redirect:/noticeList";
    }

    @GetMapping("/notices/edit/{id}")
    public String editNoticeForm(@PathVariable Long id, Model model) {
        model.addAttribute("notice", noticeService.getNoticeById(id));
        return "edit_notice";
    }

    // handler method to handle delete notice request
    @GetMapping("/notices/delete/{id}")
    public String deleteNotice(@PathVariable Long id) {
        noticeService.deleteNoticeById(id);
        return "redirect:/noticeList";
    }


}
