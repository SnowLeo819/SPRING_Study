package com.TISpjh.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.TISpjh.model.GalleryDao;
import com.TISpjh.model.GalleryDto;
import com.TISpjh.model.ReplyDao;
import com.TISpjh.model.ReplyDto;
import com.TISpjh.util.ScriptWriter;

@Controller
public class GalleryController {

	@Autowired
	GalleryDao galleryDao;

	@Autowired
	GalleryDto galleryDto;

	@Autowired
	ReplyDto replyDto;

	@Autowired
	ReplyDao replyDao;

	@RequestMapping("/Insert.do")
	public String insertGallery() {
		return "insert";
	}

	@RequestMapping("/InsertProcess.do")
	public void insertProcessGallery(GalleryDto galleryDto, MultipartFile multipartFile, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String context = request.getContextPath(); // 현재 실행중인 context 구해오기
		String imgFolder = "C:\\galleryImage\\";
		String originalFileName = multipartFile.getOriginalFilename(); // 중복 파일 방지...

		System.out.println("originalFileName===" + originalFileName);

		String extention = FilenameUtils.getExtension(originalFileName); // 확장자
		String savedFileName = UUID.randomUUID() + "." + extention; // 16자리 랜덤 문자
		File targetFile = new File(imgFolder + savedFileName);
		String dbFileName = context + "/galleryImage/" + savedFileName;

		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); // 폴더에 저장됨
		} catch (IOException e) {
			e.printStackTrace();
		}

		galleryDto.setRealImg(originalFileName);
		galleryDto.setImg(dbFileName);

		int result = galleryDao.insert(galleryDto);
		if (result > 0) {
			ScriptWriter.alertAndNext(response, "글이 등록되었습니다.", "List02.do");
		} else {
			ScriptWriter.alertAndBack(response, "시스템 오류입니다.");
		}
	}

	@RequestMapping("/List.do")
	public String list() {
		return "list";
	}

	@RequestMapping("/JsonList.do")
	@ResponseBody
	public Map<String, List<GalleryDto>> jsonList() {
		Map<String, List<GalleryDto>> hashMap = new HashMap<>();
		List<GalleryDto> galleryList = galleryDao.getAllList();
		hashMap.put("galleryList", galleryList);
		return hashMap;
	}

	@RequestMapping("/List02.do")
	public String list02() {
		return "list02";
	}

	@RequestMapping("/JsonList02.do")
	@ResponseBody
	public Map<String, List<GalleryDto>> jsonList02() {
		Map<String, List<GalleryDto>> hashMap = new HashMap<>();
		List<GalleryDto> galleryList = galleryDao.getAllList();
		hashMap.put("galleryList", galleryList);
		return hashMap;
	}

	// 입력하자마자 리스트 아래에 추가
	@RequestMapping("/InsertReply.do")
	@ResponseBody
	public Map<String, Object> insertReply(ReplyDto replyDto) {
		int result = replyDao.insertReply(replyDto);
		Map<String, Object> hashMap = new HashMap<>();

		List<ReplyDto> replyList = replyDao.getAllReply(replyDto.getBoardId());
		hashMap.put("replyList", replyList);
		hashMap.put("result", result);

		return hashMap;
	}

	// 클릭해서 들어갔을 때..
	@RequestMapping("/ReplyList.do")
	@ResponseBody
	public Map<String, Object> getAllReply(ReplyDto replyDto) {
		Map<String, Object> hashMap = new HashMap<>();

		List<ReplyDto> replyList = replyDao.getAllReply(replyDto.getBoardId());
		hashMap.put("replyList", replyList);

		return hashMap;
	}

	@RequestMapping("/DeleteReply.do")
	@ResponseBody
	public Map<String, Object> deleteReply(ReplyDto replyDto) {
		Map<String, Object> hashMap = new HashMap<>();

		int result = replyDao.deleteReply(replyDto.getNo());
		List<ReplyDto> replyList = replyDao.getAllReply(replyDto.getBoardId());
		hashMap.put("replyList", replyList);
		hashMap.put("result", result);

		return hashMap;
	}

	@RequestMapping("/DeleteAllReply.do")
	@ResponseBody
	public Map<String, Object> deleteAllReply(ReplyDto replyDto) {
		Map<String, Object> hashMap = new HashMap<>();

		int result = replyDao.deleteAllReply(replyDto.getBoardId());
		List<ReplyDto> replyList = replyDao.getAllReply(replyDto.getBoardId());
		hashMap.put("replyList", replyList);
		hashMap.put("result", result);

		return hashMap;
	}

	@RequestMapping("/DeleteGallery.do")
	@ResponseBody
	public Map<String, Object> deleteGallery(int boardId) {
		Map<String, Object> hashMap = new HashMap<>();

		int replyResult = 0;
		List<ReplyDto> replyList = replyDao.getAllReply(boardId);
		if(replyList.size()==0) {
			replyResult = 1;
		} else {
			replyResult = replyDao.deleteAllReply(boardId);
		}
		int galleryResult = galleryDao.delete(boardId); 
		List<GalleryDto> galleryList = galleryDao.getAllList();
	
		hashMap.put("galleryList", galleryList);
		hashMap.put("replyResult", replyResult);
		hashMap.put("galleryResult", galleryResult);

		return hashMap;

	}
}
