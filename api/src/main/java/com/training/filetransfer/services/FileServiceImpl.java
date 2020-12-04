package com.training.filetransfer.services;


import com.training.filetransfer.entities.File;
import com.training.filetransfer.entities.Member;
import com.training.filetransfer.repositories.FileRepository;
import com.training.filetransfer.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;

    private final MemberRepository memberRepository;

    public FileServiceImpl(FileRepository fileRepository, MemberRepository memberRepository) {
        this.fileRepository = fileRepository;
        this.memberRepository = memberRepository;
    }



    private String getExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }


    @Override
    public void create(String recipientEmail, String fileName, String url) {
        File file = new File();
        file.setFileInBucketUrl(url);
        file.setFileName(fileName);
        file.setUploadDate(new Date());
        file.setExtension(getExtension(fileName));
        file.setRecipientEmail(recipientEmail);
        //When authent is done use id of current User
        Member sender = memberRepository.getOne((long)7);
        //Check if there is already an user with this email
        // if so add its id to the file entity as recipient
        Member recipient = memberRepository.getByEmail(file.getRecipientEmail());
        if(recipient != null){
            file.setRecipient(recipient);
        }
        fileRepository.save(file);
    }
}
