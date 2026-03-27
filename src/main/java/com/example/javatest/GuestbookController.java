package com.example.javatest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GuestbookController {
    private final GuestbookRepository guestbookRepository;

    @GetMapping("/guestbook")
    public String list(Model model) {
        List<Guestbook> list = guestbookRepository.findAllOrderByIdDesc();
        model.addAttribute("models", list);
        return "guestbook-list";
    }

    @GetMapping("/guestbook/write")
    public String writeForm() {
        return "guestbook-write";
    }

    @PostMapping("/guestbook/write")
    public String write(@RequestParam("author") String author, @RequestParam("content") String content) {
        Guestbook guestbook = new Guestbook();
        guestbook.setAuthor(author);
        guestbook.setContent(content);

        guestbookRepository.save(guestbook);
        return "redirect:/guestbook";
    }

    @PostMapping("/guestbook/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        guestbookRepository.deleteById(id);
        return "redirect:/guestbook";
    }
}
