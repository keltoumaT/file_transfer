package com.training.filetransfer.dtos;

import com.training.filetransfer.entities.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {

    private String extension;

    private String fileInBucketUrl;

    private String fileName;

    private Date uploadDate;

    private Date downloadDate;

    private Long memberId;

    private String recipientEmail;
}
