package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.message.ResponseFile;
import com.app.message.ResponseMessage;
import com.app.entity.FileDB;
import com.app.service.FileStorageService;

@RestController
//  ("http://localhost:3000")
public class FileController {

	@Autowired
	private FileStorageService storageService;
	
	@CrossOrigin
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			FileDB image = storageService.store(file);
				
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(image.getId());
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

//	@GetMapping("/files")
//	public ResponseEntity<List<ResponseFile>> getListFiles() {
//		System.out.println("in list files");
//		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
//			String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath() // Prepares a URL from the
//																							// host, port, scheme, and
//					// context path of the given HttpServletRequest.eg : http://localhost:8080/
//					.path("/files/")// apends the resource name eg : http://localhost:8080/files
//					.path(dbFile.getId().toString()) // appends file id(resource id) http://localhost:8080/files/1
//					.toUriString();
//			System.out.println("url " + fileDownloadUrl);
//
//			return new ResponseFile(dbFile.getName(), fileDownloadUrl, dbFile.getType(), dbFile.getData().length);
//		}).collect(Collectors.toList());
//
//		return ResponseEntity.status(HttpStatus.OK).body(files);
//	}
	@CrossOrigin
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
		System.out.println("in get file");
		FileDB fileDB = storageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
}
