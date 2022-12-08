package com.example.studentappnew_backend.controller;

import com.example.studentappnew_backend.dao.Studentdao;
import com.example.studentappnew_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private Studentdao dao;

    @CrossOrigin(origins ="*")
    @GetMapping("/viewall")
    public List<Students> Viewall()
    {
        return (List<Students>) dao.findAll();
    }

    @CrossOrigin(origins="*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public Map<String, String> Addstudent(@RequestBody Students s) {
        System.out.println(s.getName().toString());
        System.out.println(s.getAdmno());
        System.out.println(s.getCollege().toString());
        System.out.println(s.getRollno());
        dao.save(s);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/search",consumes = "application/json",produces = "application/json")
    public List<Students> Search(@RequestBody Students pi)
    {
        String pats = String.valueOf(pi.getAdmno());
        System.out.println(pats);
        dao.SearchStudent(pi.getAdmno());
        return (List<Students>) dao.SearchStudent(pi.getAdmno());
    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Delete(@RequestBody Students ps)
    {
        String patd = String.valueOf(ps.getId());
        System.out.println(patd);
        dao.DeleteStudent(ps.getId());
        HashMap<String,String> map= new HashMap<>();
        map.put("status","success");
        return map;
    }

}
