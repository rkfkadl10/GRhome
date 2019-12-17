package upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UploadSvl")
public class UploadSvl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileurl = getServletContext().getRealPath("")+"/image";
		String encType = "utf-8";
		int Maxsize = 5*1024*1024;
		String result = "";
		try {
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(request, fileurl, Maxsize, encType, policy);
			
			String name = (String)multi.getFileNames().nextElement(); //form의 type='file'의 name 속성
			String filename = (String)multi.getFilesystemName(name); //선택한 파일명
			System.out.println("---------------------");
			System.out.println("경로 : "+fileurl);
			System.out.println("---------------------");
			System.out.println("name = "+name +"\n");
			System.out.println("filename = "+filename +"\n");
			System.out.println("---------------------");
			if(filename!=null) {
				result = "SUCCESS";
			}else {
				result = "FAIL";
			}
		}catch(IOException ioe) {
			System.out.print(ioe);
		}response.sendRedirect("UploadResultJsp.jsp?result=" + result);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
