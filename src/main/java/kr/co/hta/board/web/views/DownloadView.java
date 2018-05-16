package kr.co.hta.board.web.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.View;

import kr.co.hta.board.exception.SimpleBoardException;

public class DownloadView implements View {

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		
		File file = new File(directory, filename);
		if(!file.exists()) {
			throw new SimpleBoardException("파일이 존재하지 않습니다.");
		}
		filename = URLEncoder.encode(filename, "utf-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\";");
		
		InputStream input = new FileInputStream(file);
		OutputStream output = response.getOutputStream();
		
		FileCopyUtils.copy(input, output);
	}
}
