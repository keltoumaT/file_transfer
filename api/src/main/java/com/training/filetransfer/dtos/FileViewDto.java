package com.training.filetransfer.dtos;

import java.util.Date;

public interface FileViewDto {

    String getExtension();

    String getFileName();

    Long getMemberId();

    Date getUploadDate();

    Date getDownloadDate();

    String getRecipientEmail();
}
