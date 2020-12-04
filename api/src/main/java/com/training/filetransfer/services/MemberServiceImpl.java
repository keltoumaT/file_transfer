package com.training.filetransfer.services;

import com.training.filetransfer.dtos.MemberDto;
import com.training.filetransfer.entities.File;
import com.training.filetransfer.entities.Member;
import com.training.filetransfer.repositories.FileRepository;
import com.training.filetransfer.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final FileRepository fileRepository;

    public MemberServiceImpl(MemberRepository memberRepository, FileRepository fileRepository) {
        this.memberRepository = memberRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public void create(MemberDto dto) {
        Member member = new Member();
        populateAndSave(dto, member);
    }

    private void populateAndSave(MemberDto dto, Member member) {
        member.setUsername(dto.getUsername());
        member.setEmail(dto.getEmail());
        member.setFirstName(dto.getFirstName());
        member.setLastName(dto.getLastName());
        member.setPassword(dto.getPassword());
        memberRepository.save(member);
        List<File>files =  fileRepository.getAllByRecipientEmail(member.getEmail());
        if(!files.isEmpty()){
            files.forEach(file -> {
                if (file.getRecipientEmail().equals(member.getEmail())){
                    file.setRecipient(member);
                    fileRepository.save(file);
                }
            });
        }

    }
}
