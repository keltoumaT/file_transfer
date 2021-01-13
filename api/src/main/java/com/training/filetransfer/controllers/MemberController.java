package com.training.filetransfer.controllers;


import com.training.filetransfer.dtos.MemberDto;
import com.training.filetransfer.email.EmailConfig;
import com.training.filetransfer.services.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final EmailConfig emailConfig;

    public MemberController(MemberService memberService, EmailConfig emailConfig) {
        this.memberService = memberService;
        this.emailConfig = emailConfig;
    }


    @PostMapping
    public void create(@RequestBody MemberDto dto){
        memberService.create(dto);
    }

}
