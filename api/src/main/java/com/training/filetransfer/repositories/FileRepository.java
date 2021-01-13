package com.training.filetransfer.repositories;

import com.training.filetransfer.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    List<File> getAllByRecipientEmail(String recipientEmail);
    File getByRecipientIdAndFileName(Long id, String fileName);
}
