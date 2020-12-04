package com.training.filetransfer.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extension;

    private String fileInBucketUrl;

    private String fileName;

    private Date uploadDate;

    private Date downloadDate;

    @ManyToOne
    private Member sender;

    //Check if already have an account => if yes => add memberId to the file
    private String recipientEmail;

    @ManyToOne
    private Member recipient;

}
