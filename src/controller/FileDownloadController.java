package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class FileDownloadController extends DownloadAction {

	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String filename = request.getParameter("filename");
		
		StreamInfo info = null;
		
		if(filename.contains("struts")) {
			File f = new File("C:/Users/Alfredo/wkStruts/Struts librerias-recursos/EXTERNOS/FILEFORDOWNLOAD/struts1.docx");
			info = new FileStreamInfo("application/docx", f);
			response.setContentType("application/msword");
			response.setHeader("Content-Disposition", "attachment;filename=juliostrutsbook.docx");
		}
//		if(filename.contains("pk")) {
//			File f = new File("C:/Users/Alfredo/wkStruts/Struts librerias-recursos/EXTERNOS/FILEFORDOWNLOAD/pk.3gp");
//			info = new FileStreamInfo("video/x-msvideo", f);
//			response.setContentType("video/x-msvideo");
//			response.setHeader("Content-Disposition", "attachment;filename=juliostrutsvideo.3gp");
//		}
		if(filename.contains("image")) {
			File f = new File("C:/Users/Alfredo/wkStruts/Struts librerias-recursos/EXTERNOS/FILEFORDOWNLOAD/image.png");
			info = new FileStreamInfo("image/jpeg", f); 
			response.setContentType("image/jpeg");
			response.setHeader("Content-Disposition", "attachment;filename=juliostrutsimagen.png");
		}
		return info;
	}

}
