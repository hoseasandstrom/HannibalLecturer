package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hoseasandstrom on 6/30/16.
 */
@Controller
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String name) {
        Iterable<Lecturer> lectureList;
        if (name != null) {
            lectureList = lecturers.findAll();
            model.addAttribute("lecturers", lectureList);
        }

        return "index";
    }

    @RequestMapping(path = "/create-lecturer", method = RequestMethod.POST)
    public String lecturer(String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
        return "redirect:/";
    }

    @RequestMapping(path = "/create-review", method = RequestMethod.POST)
    public String review(String author, String text, Lecturer lecturer, boolean isGood) {
        Review review = new Review(author, text, lecturer, isGood);
        reviews.save(review);
        return "redirect:/";
    }

}
